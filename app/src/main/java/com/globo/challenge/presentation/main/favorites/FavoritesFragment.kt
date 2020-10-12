package com.globo.challenge.presentation.main.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.globo.challenge.databinding.FragmentMoviesBinding
import com.globo.challenge.presentation.BaseFragment
import com.globo.challenge.presentation.adapter.MoviesAdapter
import com.globo.challenge.presentation.main.MainActivity

class FavoritesFragment : BaseFragment() {

    companion object {
        fun newInstance() = FavoritesFragment()
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
                    Toast.makeText(activity!!, "ASDASD ASD AS", Toast.LENGTH_SHORT).show()
                }
                onMovieClickedListener = {}
            }
            binding.moviesRecyclerView.layoutManager = GridLayoutManager(activity!!, 3)

        }

        getViewModel().getFavorites().observe(this, Observer {
            it?.let {
                moviesAdapter.replaceMovies(it)
            }
        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        getViewModel().boundFavorites()
    }
}