package com.example.padsou.InputValidation

class ConfirmPasswordState(confirm_password : String) :TextFieldState(
    validator = {password -> isValidConfirmPassword(password,confirm_password)},
    errorMessage = ::passwordErrorMessage,
){
}

private fun isValidConfirmPassword(password : String,confirm_password : String) : Boolean{
    return password === confirm_password
}

private fun passwordErrorMessage(password: String) = "Les mots de passe ne correspondent pas."