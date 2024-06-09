package belajar.android.kicaumania.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import belajar.android.kicaumania.R
import belajar.android.kicaumania.databinding.ActivityOnboardingBinding
import belajar.android.kicaumania.login.LoginActivity

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            btnLogin.setOnClickListener {
                startActivity(Intent(this@OnboardingActivity, LoginActivity::class.java))
                finish()
            }

            btnRegister.setOnClickListener {
                startActivity(Intent(this@OnboardingActivity, LoginActivity::class.java))
                finish()
            }
        }


    }
}