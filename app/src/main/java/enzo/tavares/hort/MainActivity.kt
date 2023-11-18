package enzo.tavares.hort

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import enzo.tavares.hort.databinding.ActivityMainBinding
import enzo.tavares.hort.wizzard.wizard1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pularTutorial.setOnClickListener {
            val pulartutoriais = Intent(this, HomeActivity::class.java)
            startActivity(pulartutoriais)
        }

        binding.proximaTela.setOnClickListener {
            val proximaTela = Intent(this, wizard1::class.java)
            startActivity(proximaTela)
        }

    }
}