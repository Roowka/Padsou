package com.example.padsou.InputValidation

class PasswordState : TextFieldState(
    validator = ::isGoodPassword,
    errorMessage = ::passwordErrorMessage,
) {

}

private fun isGoodPassword(password :String) : Boolean{
    return password.length >= 6
}

private fun passwordErrorMessage(password :String) = "6 caractères minimum"