package com.allianz.direct.mutation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Palindrome {

    static final String PROVIDED_NULL = "Provided text is null, so no palindrome";
    static final String PALINDROME_FOUND = "Palindrome found: %s";
    static final String PALINDROME_NOT_FOUND = "Palindrome NOT found: %s";
    static final int MAX_MATCHES = 5;

    @Getter
    private int historicMatches = 0;

    private final ExternalLogger logger;

    public boolean isPalindromeUsingStringBuilder(String text) {
        if (text == null) {
            logger.log(PROVIDED_NULL);
            return false;
        }

        String clean = text.replaceAll("\\s+", "").toLowerCase();

        StringBuilder reverse = new StringBuilder(clean).reverse();

        if (reverse.toString().equals(clean)) {
            historicMatches++;

            if (historicMatches == MAX_MATCHES) {
                historicMatches = 0;
            }

            logger.log(String.format(PALINDROME_FOUND, text));
            return true;
        }
        else {
            logger.log(String.format(PALINDROME_NOT_FOUND, text));
            return false;
        }
    }
}
