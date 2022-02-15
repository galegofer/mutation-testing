package com.allianz.direct.mutation

import java.util.Locale

class PalindromeKotlin(private val logger: ExternalLogger) {

    var historicMatches: Int = 0

    fun isPalindromeUsingStringBuilder(text: String?): Boolean {
        if (text == null) {
            logger.log(PROVIDED_NULL)
            return false
        }

        val clean = text.replace("\\s+".toRegex(), "").lowercase(Locale.getDefault())
        val reverse = StringBuilder(clean).reverse()

        return if (reverse.toString() == clean) {
            historicMatches++

            if (historicMatches == 5) {
                historicMatches = 0
            }

            logger.log(String.format(PALINDROME_FOUND, text))
            true
        } else {
            logger.log(String.format(PALINDROME_NOT_FOUND, text))
            false
        }
    }

    companion object {
        const val PROVIDED_NULL = "Provided text is null, so no palindrome"
        const val PALINDROME_FOUND = "Palindrome found: %s"
        const val PALINDROME_NOT_FOUND = "Palindrome NOT found: %s"
    }
}