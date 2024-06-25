package belajar.android.kicaumania.home.camera

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import belajar.android.kicaumania.R
import belajar.android.kicaumania.databinding.ActivityOpenCameraBinding

class OpenCameraActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOpenCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOpenCameraBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}