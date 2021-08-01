package com.pajokka.manggala.maki.ui.lapor

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_report.*
import kotlinx.coroutines.*
import java.util.*
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.firebase.database.FirebaseDatabase
import kotlin.coroutines.CoroutineContext
import com.google.firebase.storage.FirebaseStorage
import com.pajokka.manggala.maki.R
import com.pajokka.manggala.maki.model.Report
import com.pajokka.manggala.maki.utils.Preferences

class ReportActivity : AppCompatActivity(), CoroutineScope {

    private lateinit var preferences: Preferences

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Default

    private var url = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report)

        val data = intent.getParcelableExtra<Uri>("URI")

        preferences = Preferences(this)

        Glide.with(this)
            .asBitmap()
            .load(data)
            .into(img_report)

        kirim.setOnClickListener {
            pb_send_report.visibility = View.VISIBLE
            uploadImageToFirebaseStorage(data)
        }

        whenClickingRetakeButton()
        whenClickingCancelButton()
    }

    private fun uploadImageToFirebaseStorage(uri: Uri?) {
        val nama = input_title_edt.text.toString()
        val deskripsi = edReview.text.toString()
        val uploadTime = System.currentTimeMillis()
        val userName = preferences.getValues("nama")
        val filename = UUID.randomUUID().toString()
        val phoneNumber = input_phone_edt.text.toString()

        val ref = FirebaseStorage.getInstance().getReference("/report-images/$filename")
        val mDatabase = FirebaseDatabase.getInstance().getReference("/reports")

        if (uri != null) {
            ref.putFile(uri)
                .addOnSuccessListener {
                    ref.downloadUrl
                        .addOnSuccessListener {
                            url = it.toString()
                            val report = Report(nama, deskripsi, url, userName, uploadTime, phoneNumber)
                            mDatabase.push().setValue(report)
                            finish()
                            pb_send_report.visibility = View.GONE
                            Toast.makeText(
                                this@ReportActivity,
                                "Laporan berhasil ditambahkan",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                        .addOnFailureListener {
                            Toast.makeText(this@ReportActivity, "Gagal upload!", Toast.LENGTH_SHORT)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
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