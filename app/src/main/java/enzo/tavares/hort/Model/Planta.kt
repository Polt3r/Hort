package enzo.tavares.hort.Model

import kotlinx.serialization.Serializable

@Serializable
class Planta (

    val _id: String,
    val nome: String,
    val nomeCientifico: String,
    val categoria: String,
    val descricao: String,
    val foto: String,

):java.io.Serializable
