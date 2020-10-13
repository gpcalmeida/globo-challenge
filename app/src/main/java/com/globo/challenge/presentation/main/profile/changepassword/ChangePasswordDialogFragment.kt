package com.globo.challenge.presentation.main.profile.changepassword

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.globo.challenge.R
import com.globo.challenge.databinding.FragmentDialogChangePasswordBinding

class ChangePasswordDialogFragment(
    private val changeCallback : (newPassword : String) -> Unit
) : DialogFragment() {

    lateinit var binding : FragmentDialogChangePasswordBinding
    private lateinit var builder : AlertDialog.Builder

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        return activity?.let {
            binding = FragmentDialogChangePasswordBinding.inflate(it.layoutInflater, null, false)

            binding.let { dialog ->

                dialog.changePasswordButton.setOnClickListener {
                    val newPassword = binding.passwordEditText.text
                    val confirmNewPassword = binding.confirmPasswordEditText.text

                    when {
                        newPassword.isEmpty() -> { binding.passwordEditText.error = getString(R.string.fill_field) }
                        confirmNewPassword.isEmpty() -> { binding.confirmPasswordEditText.error = getString(R.string.fill_field) }
                        newPassword.toString() != confirmNewPassword.toString() -> {
                            binding.passwordEditText.error = getString(R.string.pass_not_matching)
                            binding.confirmPasswordEditText.error = getString(R.string.pass_not_matching)
                        }
                        else -> {
                            changeCallback.invoke(newPassword.toString())
                            this.dialog?.dismiss()
                        }

                    }
                }
            }

            builder = AlertDialog.Builder(binding.root.context, R.style.CustomGrayAlertDialog)
            builder.setView(binding.root)
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}