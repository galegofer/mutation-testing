package com.allianz.direct.mutation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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
    }
}