package com.example.flavorfinder.view.ui.profile

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.flavorfinder.R
import com.example.flavorfinder.databinding.ActivityProfileBinding
import com.example.flavorfinder.helper.ViewModelFactory
import com.example.flavorfinder.network.response.Data
import com.example.flavorfinder.network.response.LoginResponse
import com.example.flavorfinder.pref.UserModel
import com.example.flavorfinder.view.ui.signin.SigninActivity

class ProfileActivity : AppCompatActivity() {
    private val viewModel by viewModels<ProfileViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private lateinit var binding: ActivityProfileBinding

    private lateinit var userModel: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnLogout.setOnClickListener {
            viewModel.logout()
            val intent = Intent(this, SigninActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}