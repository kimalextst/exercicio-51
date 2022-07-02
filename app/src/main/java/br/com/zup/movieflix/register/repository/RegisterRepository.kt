package br.com.zup.movieflix.register.repository

import br.com.zup.movieflix.register.model.RegisterModel

class RegisterRepository {

    private var baseUser : RegisterModel = RegisterModel()

    fun registerUser (user : RegisterModel) : RegisterModel {
        baseUser = user
        return baseUser
    }
}