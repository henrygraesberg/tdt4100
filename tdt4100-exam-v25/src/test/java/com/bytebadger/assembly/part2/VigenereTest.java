package com.bytebadger.assembly.part2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VigenereTest {

    private Vigenere cipher;

    @BeforeEach
    void setUp() {
       
    }

    // Constructor

    @Test
    void testConstructorThrowsOnEmptyKey() {
        assertThrows(IllegalArgumentException.class, () -> new Vigenere(new int[]{}));
}

    @Test
    void testConstructorThrowsOnNullKey() {
        assertThrows(IllegalArgumentException.class, () -> new Vigenere(null));
}
    // Encrypt

    @Test
    void testNullInput() {
        cipher = new Vigenere(new int[]{2, 5, -1, 0});
        assertEquals(null, cipher.encrypt(null));
        assertEquals(null, cipher.decrypt(null));
    }

    @Test
    void testEmptyInput() {
        cipher = new Vigenere(new int[]{2, 5, -1, 0});
        assertEquals("", cipher.encrypt(""));
        assertEquals("", cipher.decrypt(""));
    }

    @Test
    void testEncryptWithValidInput() {
        cipher = new Vigenere(new int[]{2, 5, -1, 0});
        assertEquals("Jjklq, Bnrni!", cipher.encrypt("Hello, World!"));
        assertEquals("Vmdrg nr a ujbrgy leuxzgg!", cipher.encrypt("There is a secret message!"));
    }

    @Test
    void testEncryptWithNoShift() {
        cipher = new Vigenere(new int[]{0});
        assertEquals("Hello, World!", cipher.encrypt("Hello, World!"));
    }

    @Test
    void testEncryptWithNegativeShift() {
        cipher = new Vigenere(new int[]{-2});
        assertEquals("Fcjjm, Umpjb!", cipher.encrypt("Hello, World!"));
    }

    @Test
    void testEncryptWithWrapAround() {
        cipher = new Vigenere(new int[]{25});
        assertEquals("Sghr hr z sghmj xnt!", cipher.encrypt("This is a think you!"));
    }

    // Decrypt
    @Test
    void testDecryptWithValidInput() {
        cipher = new Vigenere(new int[]{2, 5, -1, 0});
        assertEquals("Hello, World!", cipher.decrypt("Jjklq, Bnrni!"));
        assertEquals("There is a secret message!", cipher.decrypt("Vmdrg nr a ujbrgy leuxzgg!"));
    }

    @Test
    void testDecryptWithNoShift() {
        cipher = new Vigenere(new int[]{0});
        assertEquals("Hello, World!", cipher.decrypt("Hello, World!"));
    }

    @Test
    void testDecryptWithNegativeShift() {
        cipher = new Vigenere(new int[]{-2});
        assertEquals("Hello, World!", cipher.decrypt("Fcjjm, Umpjb!"));
    }

    @Test
    void testDecryptWithWrapAround() {
        cipher = new Vigenere(new int[]{25});
        assertEquals("This is a think you!", cipher.decrypt("Sghr hr z sghmj xnt!"));
    }
}
