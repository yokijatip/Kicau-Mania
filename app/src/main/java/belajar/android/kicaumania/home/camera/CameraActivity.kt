package belajar.android.kicaumania.home.camera

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts

import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import belajar.android.kicaumania.R
import belajar.android.kicaumania.databinding.ActivityCameraBinding
import belajar.android.kicaumania.home.camera.OpenCameraActivity.Companion.CAMERAX_RESULT

class CameraActivity : AppCompatActivity() {

    companion object {
        private const val REQUIRED_PERMISSION_CAMERA = Manifest.permission.CAMERA
    }

    private lateinit var binding: ActivityCameraBinding
    private var currentImageUri: Uri? = null

    //    Permission Camera START
    private fun allPermissionGranted() = ContextCompat.checkSelfPermission(
        this, REQUIRED_PERMISSION_CAMERA
    ) == PackageManager.PERMISSION_GRANTED

    private val requestPermissionLauncer =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(this@CameraActivity, "Perizinan diijinkan", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this@CameraActivity, "Perizinan ditolak", Toast.LENGTH_SHORT).show()
            }
        }

    private val launcherIntentCameraX = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == CAMERAX_RESULT) {
            currentImageUri =
                it.data?.getStringExtra(OpenCameraActivity.EXTRA_CAMERAX_IMAGE)?.toUri()
            convertImageToBitmap()
        }
    }

    private fun startCameraX() {
        val intent = Intent(this@CameraActivity, OpenCameraActivity::class.java)
        launcherIntentCameraX.launch(intent)
    }
    //    Permission Camera END

    //    Permission Gallery START
    private val launcherGallery =
        registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri: Uri? ->
            if (uri != null) {
                currentImageUri = uri
                //  show image
                convertImageToBitmap()
            } else {
                Log.d("IMAGE URI", "Photo Picker : No Media Selected")
            }
        }

    private fun startGallery() {
        launcherGallery.launch(
            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
        )
    }

    private fun convertImageToBitmap() {
        currentImageUri?.let {
            val bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(it))
            binding.ivManuk.setImageBitmap(bitmap)
            //  Prediction nya simpan disini dan dijalankan disini
        }
    }
    //    Permission Gallery END

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityCameraBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        Permission All Granted Handle
        if (!allPermissionGranted()) {
            requestPermissionLauncer.launch(REQUIRED_PERMISSION_CAMERA)
        }

        binding.apply {
            btnOpenCamera.setOnClickListener {
                startCameraX()
            }

            btnGallery.setOnClickListener {
                startGallery()
            }

            btnBack.setOnClickListener {
                finish()
            }
        }
    }


}