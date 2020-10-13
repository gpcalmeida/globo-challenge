package com.globo.challenge.presentation.main.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.globo.challenge.databinding.FragmentFavoritesBinding
import com.globo.challenge.presentation.BaseFragment
import com.globo.challenge.presentation.adapter.FavoritesAdapter
import com.globo.challenge.presentation.main.MainActivity

class FavoritesFragment : BaseFragment() {

    companion object {
        fun newInstance() = FavoritesFragment()
    }

    override fun getViewModel() = (activity as MainActivity).getViewModel()

    private lateinit var binding : FragmentFavoritesBinding

    private val favoritesAdapter = FavoritesAdapter(emptyList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        screenComponent.inject(this)

        binding.let {
            it.viewModel = getViewModel()
            it.lifecycleOwner = activity

            binding.moviesRecyclerView.adapter = favoritesAdapter
            binding.moviesRecyclerView.layoutManager = LinearLayoutManager(activity!!)

        }

        getViewModel().getFavorites().observe(this, Observer {
            it?.let {
                favoritesAdapter.replaceMovies(it)
            }
        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        getViewModel().boundFavorites()
    }
}