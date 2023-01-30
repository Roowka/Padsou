package com.example.padsou.InputValidation

import java.util.regex.Pattern

class LinkState : TextFieldState(
    validator = ::isValidLink,
    errorMessage = ::passwordErrorMessage,
) {
}


private const val LINK_PATTERN_VALIDATION = "^https?:\\/\\/(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()!@:%_\\+.~#?&\\/\\/=]*)$";
private fun isValidLink(link: String): Boolean {
    return Pattern.matches(LINK_PATTERN_VALIDATION,link)
}

private fun passwordErrorMessage(link: String) =
    "Le lien n'est pas valide."