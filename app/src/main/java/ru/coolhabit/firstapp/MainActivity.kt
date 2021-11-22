package ru.coolhabit.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.coolhabit.firstapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        initNavigation()

    }

    private fun initNavigation() {
        binding?.topAppBar?.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.settings -> {
                    Toast.makeText(this, R.string.btn_sett, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }

        binding?.bottomNavigation?.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.favorites -> {
                    Toast.makeText(this, R.string.btn_fav, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.search -> {
                    Toast.makeText(this, R.string.btn_srch, Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.movies -> {
                    Toast.makeText(this, R.string.btn_movie, Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}