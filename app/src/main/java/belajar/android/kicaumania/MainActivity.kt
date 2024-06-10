package belajar.android.kicaumania

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import belajar.android.kicaumania.databinding.ActivityMainBinding
import belajar.android.kicaumania.explore.ExploreFragment
import belajar.android.kicaumania.home.HomeFragment
import belajar.android.kicaumania.settings.SettingsFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        fragmentTransaction()




    }

    private fun fragmentManager(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.content, fragment, fragment.javaClass.simpleName)
        transaction.commit()
    }

    private fun fragmentTransaction() {
        binding.apply {
            bottomNav.setOnItemSelectedListener(object : ChipNavigationBar.OnItemSelectedListener {
                override fun onItemSelected(id: Int) {
                    when (id) {
                        R.id.nav_home -> fragmentManager(HomeFragment())
                        R.id.nav_explore -> fragmentManager(ExploreFragment())
                        R.id.nav_library -> fragmentManager(SettingsFragment())
                    }
                }

            })
            fragmentManager(HomeFragment.newInstance())
            bottomNav.setItemSelected(R.id.nav_home)
        }
    }
}