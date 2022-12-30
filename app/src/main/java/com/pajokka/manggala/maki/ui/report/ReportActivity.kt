package com.pajokka.manggala.maki.ui.report

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_report.*
import kotlinx.coroutines.*
import java.util.*
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlin.coroutines.CoroutineContext
import com.google.firebase.storage.FirebaseStorage
import com.pajokka.manggala.maki.R
import com.pajokka.manggala.maki.model.Report
import com.pajokka.manggala.maki.utils.Preferences
import kotlinx.android.synthetic.main.activity_sign_up.*

class ReportActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var preferences: Preferences
    private lateinit var firebaseAuth: FirebaseAuth
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default
    private var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val dataUri = intent.getParcelableExtra<Uri>("URI")

        preferences = Preferences(this)
        firebaseAuth = FirebaseAuth.getInstance()

        Glide.with(this)
            .asBitmap()
            .load(dataUri)
            .into(img_report)

        kirim.setOnClickListener {
            pb_send_report.visibility = View.VISIBLE
            val title = input_title_edt.text.toString()
            val phoneNumber = input_phone_edt.text.toString()
            val desc = edReview.text.toString()

            if (title.isEmpty() || title == "") {
                input_title_edt.error = "Silakan isi judul laporan"
                input_title_edt.requestFocus()
                pb_send_report.visibility = View.GONE
            } else if (phoneNumber.isEmpty() || phoneNumber == "") {
                input_phone_edt.error = "Silakan tambahkan nomor telepon anda"
                input_phone_edt.requestFocus()
                pb_send_report.visibility = View.GONE
            } else if (!Patterns.PHONE.matcher(phoneNumber).matches()) {
                input_phone_edt.error = "Format nomor telepon anda salah"
                input_phone_edt.requestFocus()
                pb_send_report.visibility = View.GONE
            } else if (desc.isEmpty() || desc == "") {
                edReview.error = "Silakan tambahkan deskripsi laporan"
                edReview.requestFocus()
                pb_send_report.visibility = View.GONE
            } else {
                uploadImageToFirebaseStorage(title, phoneNumber, desc, dataUri)
            }
        }
        whenClickingRetakeButton()
        whenClickingCancelButton()
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
                            pb_send_report.visibility = View.GONE
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
        card_photo.setOnClickListener {
            openCamera()
        }
    }

    private fun whenClickingCancelButton() {
        btn_cancel.setOnClickListener {
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
            val uri: Uri = data?.data!!
            when (requestCode) {
                CAMERA_IMAGE_REQ_CODE -> {
                    Glide.with(this)
                        .asBitmap()
                        .load(uri)
                        .into(img_report)
                }
            }
        }
    }

    companion object {
        const val CAMERA_IMAGE_REQ_CODE = 103
    }
}