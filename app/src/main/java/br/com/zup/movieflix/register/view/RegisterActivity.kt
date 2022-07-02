package br.com.zup.movieflix.register.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.EQUAL_PASSWORD_TEXT
import br.com.zup.movieflix.databinding.ActivityRegisterBinding
import br.com.zup.movieflix.home.view.HomeActivity
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observers()
        binding.bvLogin.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        if (confirmMatchingPasswords()) {
            viewModel.registerUser(
                RegisterModel(
                    binding.etUserNameRegister.text.toString(),
                    binding.etEmailRegister.text.toString(),
                    binding.etPasswordRegister.text.toString()
                )
            )
        } else {
            Toast.makeText(this, EQUAL_PASSWORD_TEXT, Toast.LENGTH_LONG).show()
        }
    }


    private fun confirmMatchingPasswords(): Boolean {
        var match = false

        if (binding.etPasswordRegister.text.toString() == binding.etConfirmPasswordRegister.text.toString()) {
            match = true
        }

        return match
    }

    private fun observers() {
        viewModel.response.observe(this) {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }
}