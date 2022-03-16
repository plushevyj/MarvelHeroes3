package com.example.marvelheroes3.api

import com.example.marvelheroes3.model.Hero
import io.reactivex.Observable
import retrofit2.http.GET

interface TmdbEndpoints {

    @GET("demos/marvel/")
    fun getHeroes(): Observable<MutableList<Hero>>

}
