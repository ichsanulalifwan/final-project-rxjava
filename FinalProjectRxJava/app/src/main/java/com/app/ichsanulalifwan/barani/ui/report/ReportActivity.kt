package com.app.ichsanulalifwan.barani.ui.report

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.app.ichsanulalifwan.barani.core.model.Report
import com.app.ichsanulalifwan.barani.databinding.ActivityReportBinding
import com.app.ichsanulalifwan.barani.utils.Preferences
import com.bumptech.glide.Glide
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.CoroutineContext

class ReportActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var binding: ActivityReportBinding
    private lateinit var preferences: Preferences
    private lateinit var firebaseAuth: FirebaseAuth
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default
    private var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)

        binding = ActivityReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataUri = intent.getParcelableExtra<Uri>("URI")

        preferences = Preferences(this)
        firebaseAuth = FirebaseAuth.getInstance()

        Glide.with(this)
            .asBitmap()
            .load(dataUri)
            .into(binding.imgReport)

        binding.kirim.setOnClickListener {
            validateInput(dataUri)
        }

        whenClickingRetakeButton()
        whenClickingCancelButton()
    }

    private fun validateInput(data: Uri?) {
        binding.run {
            pbSendReport.visibility = View.VISIBLE
            val title = inputTitleEdt.text.toString()
            val phoneNumber = inputPhoneEdt.text.toString()
            val desc = edReview.text.toString()

            if (title.isEmpty() || title == "") {
                inputTitleEdt.error = "Silakan isi judul laporan"
                inputTitleEdt.requestFocus()
                pbSendReport.visibility = View.GONE
            } else if (phoneNumber.isEmpty() || phoneNumber == "") {
                inputPhoneEdt.error = "Silakan tambahkan nomor telepon anda"
                inputPhoneEdt.requestFocus()
                pbSendReport.visibility = View.GONE
            } else if (!Patterns.PHONE.matcher(phoneNumber).matches()) {
                inputPhoneEdt.error = "Format nomor telepon anda salah"
                inputPhoneEdt.requestFocus()
                pbSendReport.visibility = View.GONE
            } else if (desc.isEmpty() || desc == "") {
                edReview.error = "Silakan tambahkan deskripsi laporan"
                edReview.requestFocus()
                pbSendReport.visibility = View.GONE
            } else {
                uploadImageToFirebaseStorage(title, phoneNumber, desc, data)
            }
        }

    }

    private fun uploadImageToFirebaseStorage(
        titel: String,
        phoneNumber: String,
        description: String,
        uri: Uri?
    ) {
        val uploadTime = System.currentTimeMillis()
        val userName = preferences.getValues("nama")
        val filename = UUID.randomUUID().toString()

        val userId = firebaseAuth.currentUser?.uid
        val ref = FirebaseStorage.getInstance().getReference("/report-images/$filename")
        val mDatabase = FirebaseDatabase.getInstance().getReference("/reports")

        if (uri != null) {
            ref.putFile(uri)
                .addOnSuccessListener {
                    ref.downloadUrl
                        .addOnSuccessListener {
                            url = it.toString()
                            val report =
                                Report(titel, description, url, userName, uploadTime, phoneNumber)
                            if (userId != null) {
                                mDatabase.child(userId).push().setValue(report)
                            }
                            finish()
                            binding.pbSendReport.visibility = View.GONE
                            Toast.makeText(
                                this@ReportActivity,
                                "Laporan berhasil dikirimkan",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                        .addOnFailureListener {
                            Toast.makeText(
                                this@ReportActivity,
                                "Gagal mengirimkan laporan!",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                }
        }
    }

    private fun whenClickingRetakeButton() {
        binding.cardPhoto.setOnClickListener {
            openCamera()
        }
    }

    private fun whenClickingCancelButton() {
        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun openCamera() = launch {
        withContext(Dispatchers.IO) {
            ImagePicker.with(this@ReportActivity)
                .cameraOnly()
                .compress(1024)
                .maxResultSize(620, 620)
                .start(CAMERA_IMAGE_REQ_CODE)
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val uri: Uri? = data?.data
            when (requestCode) {
                CAMERA_IMAGE_REQ_CODE -> {
                    Glide.with(this)
                        .asBitmap()
                        .load(uri)
                        .into(binding.imgReport)
                }
            }
        }
    }

    companion object {
        const val CAMERA_IMAGE_REQ_CODE = 103
    }
}