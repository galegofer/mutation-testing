package com.allianz.direct.mutation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.allianz.direct.mutation.Palindrome.PALINDROME_FOUND;
import static com.allianz.direct.mutation.Palindrome.PALINDROME_NOT_FOUND;
import static com.allianz.direct.mutation.Palindrome.PROVIDED_NULL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class PalindromeTest {

    @Mock
    ExternalLogger externalLogger;

    @InjectMocks
    Palindrome underTest;

    @Test
    void testPalindromeWithEmpty() {
        var input = "";

        boolean result = underTest.isPalindromeUsingStringBuilder(input);

        verify(externalLogger).log(String.format(PALINDROME_FOUND, input));

        assertThat(result).isTrue();
    }

    @Test
    void testPalindromeWithSingleLetter() {
        var input = "a";

        boolean result = underTest.isPalindromeUsingStringBuilder(input);
    }

    @Test
    void testNoPalindromeWithNull() {
        boolean result = underTest.isPalindromeUsingStringBuilder(null);

        verify(externalLogger).log(PROVIDED_NULL);

        assertThat(result).isFalse();
    }

    @Test
    void testNoPalindromePairLetters() {
        var input = "ab";

        boolean result = underTest.isPalindromeUsingStringBuilder(input);
    }


    @Test
    void testPalindromeWithImpairNumberOfLetters() {
        var input = "aaabaaa";

        boolean result = underTest.isPalindromeUsingStringBuilder(input);
    }

    @Test
    void testPalindromeWithPairNumberOfLetters() {
        var input = "aabbaa";

        boolean result = underTest.isPalindromeUsingStringBuilder(input);
    }

    @Test
    void testPalindromeScore5Times() {
        var input = "a";

        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
    }

    @Test
    void testPalindromeScore4Times() {
        var input = "a";

        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
    }
}