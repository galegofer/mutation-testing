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
        // Given
        var input = "";

        // When
        boolean result = underTest.isPalindromeUsingStringBuilder(input);

        // Then
        verify(externalLogger).log(String.format(PALINDROME_FOUND, input));

        assertThat(result).isTrue();
    }

    @Test
    void testPalindromeWithSingleLetter() {
        // Given
        var input = "a";

        // When
        boolean result = underTest.isPalindromeUsingStringBuilder(input);

        // Then
        verify(externalLogger).log(String.format(PALINDROME_FOUND, input));

        assertThat(result).isTrue();
    }

    @Test
    void testNoPalindromeWithNull() {
        // When
        boolean result = underTest.isPalindromeUsingStringBuilder(null);

        // Then
        verify(externalLogger).log(PROVIDED_NULL);

        assertThat(result).isFalse();
    }

    @Test
    void testNoPalindromePairLetters() {
        // Given
        var input = "ab";

        // When
        boolean result = underTest.isPalindromeUsingStringBuilder(input);

        // Then
        verify(externalLogger).log(String.format(PALINDROME_NOT_FOUND, input));

        assertThat(result).isFalse();
    }


    @Test
    void testPalindromeWithImpairNumberOfLetters() {
        // Given
        var input = "aaabaaa";

        // When
        boolean result = underTest.isPalindromeUsingStringBuilder(input);

        // Then
        verify(externalLogger).log(String.format(PALINDROME_FOUND, input));

        assertThat(result).isTrue();
    }

    @Test
    void testPalindromeWithPairNumberOfLetters() {
        // Given
        var input = "aabbaa";

        // When
        boolean result = underTest.isPalindromeUsingStringBuilder(input);

        // Then
        verify(externalLogger).log(String.format(PALINDROME_FOUND, input));

        assertThat(result).isTrue();
    }

    @Test
    void testPalindromeScore5Times() {
        // Given
        var input = "a";

        // When
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);

        // Then
        verify(externalLogger, times(5)).log(String.format(PALINDROME_FOUND, input));
        assertThat(underTest.getHistoricMatches()).isEqualTo(0);
    }

    @Test
    void testPalindromeScore4Times() {
        // Given
        var input = "a";

        // When
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);
        underTest.isPalindromeUsingStringBuilder(input);

        // Then
        verify(externalLogger, times(4)).log(String.format(PALINDROME_FOUND, input));
        assertThat(underTest.getHistoricMatches()).isEqualTo(4);
    }
}