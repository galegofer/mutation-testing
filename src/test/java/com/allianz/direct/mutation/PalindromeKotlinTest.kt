package com.allianz.direct.mutation

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
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
    }
}
