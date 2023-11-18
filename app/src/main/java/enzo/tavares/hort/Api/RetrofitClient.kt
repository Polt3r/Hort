package enzo.tavares.hort.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    private val BASE_URL = "https://web-s4p27wq3uls4.up-de-fra1-1.apps.run-on-seenode.com/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val PlantaService: ServicoPlanta = retrofit.create(ServicoPlanta::class.java)
}