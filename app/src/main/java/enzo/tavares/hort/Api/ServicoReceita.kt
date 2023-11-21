package enzo.tavares.hort.Api

import enzo.tavares.hort.Model.Planta
import enzo.tavares.hort.Model.Receita
import retrofit2.Call
import retrofit2.http.GET

interface ServicoReceita {

    @GET("receitasmobile")
    fun getAllReceitas(): Call<List<Receita>>

}