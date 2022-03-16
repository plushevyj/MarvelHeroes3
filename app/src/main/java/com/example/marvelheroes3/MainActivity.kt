package com.example.marvelheroes3

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelheroes3.api.Service
import com.example.marvelheroes3.model.Hero
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

    }
}
