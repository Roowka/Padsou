package com.example.padsou.InputValidation

class PostInfoState : TextFieldState(
    validator = ::isValidPostInfo,
    errorMessage = ::postInfoErrorMessage
) {
}

private fun isValidPostInfo(text : String): Boolean{
    return text.length > 1
}

private fun postInfoErrorMessage(text :String) = "2 caractères minimum"