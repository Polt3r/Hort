package enzo.tavares.hort.wizzard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import enzo.tavares.hort.HomeActivity
import enzo.tavares.hort.MainActivity
import enzo.tavares.hort.R
import enzo.tavares.hort.databinding.ActivityWizard1Binding
import enzo.tavares.hort.databinding.ActivityWizard2Binding

class wizard2 : AppCompatActivity() {

    private lateinit var binding : ActivityWizard2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWizard2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.anteriorTela.setOnClickListener {
            val voltarTela = Intent(this, wizard1::class.java)
            startActivity(voltarTela)
        }

        binding.proximaTela.setOnClickListener {
            val proximaTela = Intent(this, HomeActivity::class.java)
            startActivity(proximaTela)
        }
    }
}