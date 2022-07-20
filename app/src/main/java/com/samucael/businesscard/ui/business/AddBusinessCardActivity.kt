package com.samucael.businesscard.ui.business

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.samucael.businesscard.App
import com.samucael.businesscard.R
import com.samucael.businesscard.data.BusinessCard
import com.samucael.businesscard.databinding.ActivityAddBusinessCardBinding
import com.samucael.businesscard.ui.main.MainViewModel
import com.samucael.businesscard.ui.main.MainViewModelFactory

class AddBusinessCardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBusinessCardBinding

    private val mainViewModel: MainViewModel by viewModels { MainViewModelFactory((application as App).repository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBusinessCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners()

    }

    private fun insertListeners() {
        binding.btnClose.setOnClickListener {
            finish()
        }

        binding.btnConfirm.setOnClickListener() {
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                enterprise = binding.tilEnterprise.editText?.text.toString(),
                telephone = binding.tilTelephone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                background = binding.tilColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}