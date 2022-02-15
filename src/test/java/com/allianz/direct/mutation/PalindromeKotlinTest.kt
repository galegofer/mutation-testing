package com.allianz.direct.mutation

import com.allianz.direct.mutation.Palindrome.PALINDROME_FOUND
import com.allianz.direct.mutation.Palindrome.PALINDROME_NOT_FOUND
import com.allianz.direct.mutation.Palindrome.PROVIDED_NULL
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PalindromeKotlinTest(@Mock val externalLogger: ExternalLogger) {

    @InjectMocks
    lateinit var underTest: PalindromeKotlin

    @Test
    fun testPalindromeWithEmpty() {
        // Given
        val input = ""
        // When
        val result = underTest.isPalindromeUsingStringBuilder(input)
        // Then
        verify(externalLogger).log(String.format(PALINDROME_FOUND, input))
        assertThat(result).isTrue
    }

    @Test
    fun testPalindromeWithSingleLetter() {
        // Given
        val input = "a"
        // When
        val result = underTest.isPalindromeUsingStringBuilder(input)
        // Then
        verify(externalLogger).log(String.format(PALINDROME_FOUND, input))
        assertThat(result).isTrue
    }

    @Test
    fun testNoPalindromeWithNull() {
        // When
        val result = underTest.isPalindromeUsingStringBuilder(null)
        // Then
        verify(externalLogger).log(PROVIDED_NULL)
        assertThat(result).isFalse()
    }

    @Test
    fun testNoPalindromePairLetters() {
        // Given
        val input = "ab"
        // When
        val result = underTest.isPalindromeUsingStringBuilder(input)
        // Then
        verify(externalLogger).log(String.format(PALINDROME_NOT_FOUND, input))
        assertThat(result).isFalse
    }

    @Test
    fun testPalindromeWithImpairNumberOfLetters() {
        // Given
        val input = "aaabaaa"
        // When
        val result = underTest.isPalindromeUsingStringBuilder(input)
        // Then
        verify(externalLogger).log(String.format(PALINDROME_FOUND, input))
        assertThat(result).isTrue
    }

    @Test
    fun testPalindromeWithPairNumberOfLetters() {
        // Given
        val input = "aabbaa"
        // When
        val result = underTest.isPalindromeUsingStringBuilder(input)
        // Then
        verify(externalLogger).log(String.format(PALINDROME_FOUND, input))
        assertThat(result).isTrue
    }

    @Test
    fun testPalindromeScore5Times() {
        // Given
        val input = "a"
        // When
        underTest.isPalindromeUsingStringBuilder(input)
        underTest.isPalindromeUsingStringBuilder(input)
        underTest.isPalindromeUsingStringBuilder(input)
        underTest.isPalindromeUsingStringBuilder(input)
        underTest.isPalindromeUsingStringBuilder(input)
        // Then
        verify(externalLogger, times(5)).log(String.format(PALINDROME_FOUND, input))
        assertThat(underTest.historicMatches).isEqualTo(0)
    }

    @Test
    fun testPalindromeScore4Times() {
        // Given
        val input = "a"
        // When
        underTest.isPalindromeUsingStringBuilder(input)
        underTest.isPalindromeUsingStringBuilder(input)
        underTest.isPalindromeUsingStringBuilder(input)
        underTest.isPalindromeUsingStringBuilder(input)
        // Then
        verify(externalLogger, times(4)).log(String.format(PALINDROME_FOUND, input))
        assertThat(underTest.historicMatches).isEqualTo(4)
    }
}
