package com.globo.challenge.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.globo.challenge.databinding.ItemFavoriteBinding
import com.globo.domain.model.Movie

class FavoritesAdapter(
    private var movies: List<Movie>
) : RecyclerView.Adapter<FavoritesAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder (
            ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }

    override fun getItemCount(): Int {
        return movies.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(movies[position])
    }

    fun replaceMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    class Holder(
        private val binding: ItemFavoriteBinding
    ):
        RecyclerView.ViewHolder(binding.root) {

        lateinit var movie: Movie

        fun bind(movie: Movie){
            this.movie = movie

            Glide.with(itemView)
                .load(movie.thumbnail)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(binding.movieImageView)

            binding.titleTextView.text = movie.title
            binding.subtitleTextView.text = movie.subtitle
            binding.durationTextView.text = movie.duration
            binding.synopsisTextView.text = movie.synopsis

        }
    }
}