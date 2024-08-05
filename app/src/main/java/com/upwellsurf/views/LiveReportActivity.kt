package com.upwellsurf.views

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.AssetFileDescriptor
import android.media.MediaPlayer
import android.media.MediaScannerConnection
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.google.android.material.snackbar.Snackbar
import com.upwellsurf.R
import com.upwellsurf.adapters.ChatAdapter
import com.upwellsurf.models.ChatMessages
import com.upwellsurf.views.frgs.PrivateMsgDialogFrg
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class LiveReportActivity : AppCompatActivity() {
    lateinit var txt_upload_picture: TextView
    lateinit var img_capture_pic: ImageView
    val REQUEST_CAMERA_PERMISSION = 1001
    private val REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION = 1002
    private lateinit var photoFile: File
    private val REQUEST_IMAGE_CAPTURE = 1003
    var listOfMessages = ArrayList<ChatMessages>()
    lateinit var bt_send: AppCompatButton
    lateinit var et_message: EditText
    lateinit var photoURI: Uri
    val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) {
        val galleryUri = it
        try {
            if (galleryUri != null) {
                img_capture_pic.setImageURI(galleryUri)
                startSound("photo_upload.mp3")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
    val cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()) {
        try {
            img_capture_pic.setImageURI(photoURI)
            startSound("photo_upload.mp3")
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_report)
        val dialogFragment = PrivateMsgDialogFrg()
        dialogFragment.show(supportFragmentManager, "PrivateMsgDialogFrg")

        photoURI = FileProvider.getUriForFile(
            this,
            this.applicationContext.packageName,
            createImageFile()
        )

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.live_report)
        txt_upload_picture = findViewById(R.id.txt_upload_picture)
        img_capture_pic = findViewById(R.id.img_capture_pic)
        bt_send = findViewById(R.id.bt_send)
        et_message = findViewById(R.id.et_message)

        txt_upload_picture.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CAMERA
                ) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                optionChoosePickPicherDialog(this)

            } else {
                checkPermissions()
            }
        }

        bt_send.setOnClickListener {
            val msg = et_message.text.toString()
            if (msg.isNotEmpty()) {
                listOfMessages.add(ChatMessages(msg))
                et_message.text.clear()
                val adapter = ChatAdapter(listOfMessages)
                val recy_chat_list =
                    findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recy_chat_list)
                recy_chat_list.layoutManager =
                    androidx.recyclerview.widget.LinearLayoutManager(this)
                recy_chat_list.adapter = adapter
            } else {
                Snackbar.make(this.bt_send, "Please enter a message", Snackbar.LENGTH_SHORT).show()
            }

        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun checkPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_CAMERA_PERMISSION
            )
        } else if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_CAMERA_PERMISSION || requestCode == REQUEST_WRITE_EXTERNAL_STORAGE_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
                optionChoosePickPicherDialog(this)
            } else {
                // Permission denied
                // Handle the denial case
            }
        }
    }

    private fun createImageFile(): File {
        val timeStamp: String =
            SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val storageDir: File? =
            this.applicationContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timeStamp}_", ".jpg", externalMediaDirs.first()).apply {
            photoFile = this
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            // Photo captured successfully, you can now update the gallery
            updateGallery(photoFile)
        }
    }

    private fun updateGallery(photoFile: File) {
        MediaScannerConnection.scanFile(this, arrayOf(photoFile.absolutePath), null) { _, uri ->
            // Gallery is updated, you can use the uri if needed
            img_capture_pic.setImageURI(uri)
        }
    }

    // Function to show the video player dialog
    private fun optionChoosePickPicherDialog(context: Context) {
        // Inflate the dialog layout
        val dialogLayout = LayoutInflater.from(context).inflate(R.layout.dialog_pick_picture, null)
        // Find the VideoView in the dialog layout
        val camera = dialogLayout.findViewById<TextView>(R.id.txt_camera)
        val gallery = dialogLayout.findViewById<TextView>(R.id.txt_gallery)
        // Create an AlertDialog builder
        val builder = AlertDialog.Builder(context)
            .setTitle("Select Your option to upload a picture")
            .setView(dialogLayout)
            .setPositiveButton("Close") { dialog, _ -> dialog.dismiss() }
        // Create and show the dialog
        val dialog = builder.create()

        camera.setOnClickListener {
            dialog.dismiss()
            cameraLauncher.launch(photoURI)
        }
        gallery.setOnClickListener {
            galleryLauncher.launch("image/*")
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun startSound(filename: String) {
        val player = MediaPlayer()
        var afd: AssetFileDescriptor? = null
        try {
            afd = resources.assets.openFd(filename)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        try {
            checkNotNull(afd)
            player.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        try {
            player.prepare()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        player.start()
    }

}