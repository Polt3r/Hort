package enzo.tavares.hort.Model

import android.net.Uri
import kotlinx.serialization.Serializable

@Serializable
data class Receita(
    val _id: String,
    val nome: String,
    val foto: String,
    val tempoDePreparo: String,
    val ingredientes: String,
    val modoDePreparo: String
):java.io.Serializable