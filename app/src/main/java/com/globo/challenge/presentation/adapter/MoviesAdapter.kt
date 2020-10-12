package com.globo.challenge.presentation.adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.globo.challenge.R
import com.globo.challenge.databinding.ItemMovieBinding
import com.globo.domain.model.Movie


class MoviesAdapter(
    private var movies: List<Movie>
) : RecyclerView.Adapter<MoviesAdapter.Holder>(){

    lateinit var onMovieClickedListener: (movie: Movie) -> Unit
    lateinit var onFavoriteClickedListener: (movie: Movie) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder (
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent,false),
            onMovieClickedListener,
            onFavoriteClickedListener
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
        private val binding: ItemMovieBinding,
        private val onMovieClickedListener: ((movie: Movie) -> Unit),
        private val onFavoriteClickedListener: ((movie: Movie) -> Unit)):
        RecyclerView.ViewHolder(binding.root) {

        lateinit var movie: Movie

        fun bind(movie: Movie){
            this.movie = movie

            Glide.with(itemView)
                .load(movie.thumbnail)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(binding.movieImageView)

            setAsFavorite()

            binding.favoriteImageButton.setOnClickListener {
                this.movie.isFavorite = !this.movie.isFavorite
                setAsFavorite()
                onFavoriteClickedListener.invoke(movie)
            }

        }

        private fun setAsFavorite() {
            if(movie.isFavorite)
                binding.favoriteImageButton.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, R.color.colorAccent))
            else
                binding.favoriteImageButton.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(itemView.context, R.color.lightGray))
        }

    }
}