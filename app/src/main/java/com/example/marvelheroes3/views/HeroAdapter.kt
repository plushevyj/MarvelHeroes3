package com.example.marvelheroes3.views

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelheroes3.R
import com.example.marvelheroes3.databinding.HeroItemBinding
import com.example.marvelheroes3.model.Hero
import com.squareup.picasso.Picasso


class HeroAdapter : RecyclerView.Adapter<HeroAdapter.HeroHolder>() {
    private val heroList = ArrayList<Hero>()
    class HeroHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = HeroItemBinding.bind(item)
        fun bind(hero: Hero) = with(binding) {
            Log.d("kek1", hero.imageUrl.toString())
            Picasso.get().load(hero.imageUrl).into(imageView)
            textView.text = hero.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroAdapter.HeroHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return HeroHolder(view)
    }

    override fun onBindViewHolder(holder: HeroAdapter.HeroHolder, position: Int) {
        holder.bind(heroList[position])
    }

    override fun getItemCount(): Int {
        return heroList.size
    }

    fun addHero(hero: Hero) {
        heroList.add(hero)
//        notifyDataSetChanged()
    }
}