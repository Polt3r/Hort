package enzo.tavares.hort.Api

import retrofit2.Call
import retrofit2.http.*
import enzo.tavares.hort.Model.Planta

interface ServicoPlanta {

    @GET("alimentosmobile")
    fun getAllAlimentos(): Call<List<Planta>>

}