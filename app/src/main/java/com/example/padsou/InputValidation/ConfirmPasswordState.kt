package com.example.padsou.InputValidation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class ConfirmPasswordState:TextFieldState(
    validator = {confirm_password -> isValidConfirmPassword(confirm_password)},
    errorMessage = ::passwordErrorMessage,
){
    var state :Boolean = false

    override fun isValid() = state
}

private fun isValidConfirmPassword(confirm_password : String) : Boolean{
    return false
}

private fun passwordErrorMessage(confirm_password: String) = "Les mots de passe ne correspondent pas."