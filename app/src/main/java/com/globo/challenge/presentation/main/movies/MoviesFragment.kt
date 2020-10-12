package com.globo.challenge.presentation.main.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.globo.challenge.databinding.FragmentMoviesBinding
import com.globo.challenge.presentation.BaseFragment
import com.globo.challenge.presentation.adapter.MoviesAdapter
import com.globo.challenge.presentation.main.MainActivity
import com.globo.challenge.presentation.main.movies.moviedetails.MovieDetailsFragmentDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MoviesFragment : BaseFragment() {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    override fun getViewModel() = (activity as MainActivity).getViewModel()

    private lateinit var binding : FragmentMoviesBinding

    private val moviesAdapter = MoviesAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)

        screenComponent.inject(this)

        binding.let {
            it.viewModel = getViewModel()
            it.lifecycleOwner = activity

            binding.moviesRecyclerView.adapter = moviesAdapter.apply {
                onFavoriteClickedListener = {
                    GlobalScope.launch {
                        val a = it.isFavorite
                        if(it.isFavorite)
                            getViewModel().setAsFavorite(it)
                        else
                            getViewModel().deleteFavorite(it)
                    }
                }
                onMovieClickedListener = { movie ->
                    MovieDetailsFragmentDialog(movie).show(activity!!.supportFragmentManager, "")
                }
            }
            binding.moviesRecyclerView.layoutManager = GridLayoutManager(activity!!, 3)

        }

        getViewModel().getMovies().observe(this, Observer {
            it?.let {
                moviesAdapter.replaceMovies(it)
            }
        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        getViewModel().boundMovies()
    }
}