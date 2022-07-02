package br.com.zup.movieflix.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.movieflix.register.model.RegisterModel
import br.com.zup.movieflix.register.repository.RegisterRepository

class RegisterViewModel : ViewModel() {
    private val repository = RegisterRepository()
    private var _response: MutableLiveData<RegisterModel> = MutableLiveData()
    val response: LiveData<RegisterModel> = _response

    fun registerUser (register : RegisterModel) {
        _response.value = repository.registerUser(register)
    }
}