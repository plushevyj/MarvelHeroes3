package com.odhiambopaul.movies.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelheroes3.R
import com.example.marvelheroes3.network.HeroesListItem
import com.odhiambopaul.movies.network.ServiceBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            ServiceBuilder.buildService().getMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({response -> onResponse(response)}, {t -> onFailure(t) }))

    }

    private fun onFailure(t: Throwable) {
        Toast.makeText(this,t.message, Toast.LENGTH_SHORT).show()
    }

    private fun onResponse(response: MutableList<HeroesListItem>) {
        Log.d("kek", response.toString())
//        progress_bar.visibility = View.GONE
//        recyclerView.apply {
//            setHasFixedSize(true)
//            layoutManager = LinearLayoutManager(this@MainActivity)
//            adapter =
//                MoviesAdapter(response.results)
    }
}
