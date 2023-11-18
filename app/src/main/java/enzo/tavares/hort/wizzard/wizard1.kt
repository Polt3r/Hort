package enzo.tavares.hort.wizzard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import enzo.tavares.hort.MainActivity
import enzo.tavares.hort.R
import enzo.tavares.hort.databinding.ActivityWizard1Binding

class wizard1 : AppCompatActivity() {

    private lateinit var binding: ActivityWizard1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWizard1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.anteriorTela.setOnClickListener {
            val voltarTela = Intent(this, MainActivity::class.java)
            startActivity(voltarTela)
        }

        binding.proximaTela.setOnClickListener {
            val proximaTela = Intent(this, wizard2::class.java)
            startActivity(proximaTela)
        }

    }
}