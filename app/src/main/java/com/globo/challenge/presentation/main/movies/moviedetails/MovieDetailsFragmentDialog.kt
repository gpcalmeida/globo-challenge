package com.globo.challenge.presentation.main.movies.moviedetails

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.globo.challenge.R
import com.globo.challenge.databinding.FragmentDialogMovieDetailsBinding
import com.globo.domain.model.Movie

class MovieDetailsFragmentDialog(private val movie : Movie) : DialogFragment() {

    lateinit var binding : FragmentDialogMovieDetailsBinding
    private lateinit var builder : AlertDialog.Builder

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            binding = FragmentDialogMovieDetailsBinding.inflate(it.layoutInflater, null, false)

            binding.let { dialog ->
                dialog.titleTextView.text = movie.title
                dialog.subtitleTextView.text = movie.subtitle
                dialog.durationTextView.text = movie.duration
                dialog.synopsisTextView.text = movie.synopsis
            }

            builder = AlertDialog.Builder(binding.root.context, R.style.CustomWhiteAlertDialog)
            builder.setView(binding.root)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}