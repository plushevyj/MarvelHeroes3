package com.example.marvelheroes3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.marvelheroes3.api.Service
import com.example.marvelheroes3.databinding.ActivityMainBinding
import com.example.marvelheroes3.model.Hero
import com.example.marvelheroes3.views.HeroAdapter
import com.squareup.picasso.Picasso
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = HeroAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val compositeDisposable = CompositeDisposable()
        compositeDisposable.add(
            Service.buildService().getHeroes()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({response -> onResponse(response)}, {t -> onFailure(t) }))

    }

    private fun onFailure(t: Throwable) {
        Toast.makeText(this, t.message, Toast.LENGTH_SHORT).show()
    }

    private fun onResponse(response: MutableList<Hero>) {
        Log.d("kek", response.toString())
        for (i in 0 until response.size) {
            Log.d("kek", "${response[i].name}\n")
        }

        binding.apply {
            heroesView.layoutManager = GridLayoutManager(this@MainActivity, 1)
            heroesView.adapter = adapter
            for (hero in response) {
                adapter.addHero(hero)
            }
        }
    }

//    private fun init() {
//        binding.apply {
//            heroesView.layoutManager = GridLayoutManager(this@MainActivity, 1)
//            heroesView.adapter = adapter
//            for (i in 0 until heroesUrlImages.size) {
//                adapter.addHero(Hero(image, names[i]))
//            }
//        }
//    }
}
