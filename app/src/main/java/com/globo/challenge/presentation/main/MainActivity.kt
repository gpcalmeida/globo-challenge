package com.globo.challenge.presentation.main

import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.globo.challenge.R
import com.globo.challenge.databinding.ActivityMainBinding
import com.globo.challenge.presentation.BaseActivity
import com.globo.challenge.presentation.adapter.MoviesAdapter
import com.globo.challenge.presentation.main.favorites.FavoritesFragment
import com.globo.challenge.presentation.main.movies.MoviesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainActivity : BaseActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun getViewModel() = mainViewModel

    private val moviesAdapter = MoviesAdapter(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        screenComponent.inject(this)

        binding.let {
            it.viewModel = mainViewModel

            binding.mainBottomNavigationView.setOnNavigationItemSelectedListener(this)
            binding.mainBottomNavigationView.selectedItemId = R.id.moviesAction
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.moviesAction -> {
                openFragment(MoviesFragment.newInstance())
            }
            R.id.favoritesAction -> {
             openFragment(FavoritesFragment.newInstance())
            }
            R.id.profileAction ->{
                openFragment(Fragment())
            }
        }
        return true
    }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.mainFrameLayout, fragment)
        transaction.commit()
    }

}