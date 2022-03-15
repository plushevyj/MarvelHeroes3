package com.odhiambopaul.movies.network

import com.example.marvelheroes3.network.HeroesListItem
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbEndpoints {

    @GET("demos/marvel/")
    fun getMovies(): Observable<MutableList<HeroesListItem>>

}
