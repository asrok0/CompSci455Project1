public class VigenereCipher {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    // Convert characters to numbers starting at a=0
    public static int charToNum(char c) {
        return Character.toLowerCase(c) - 'a';
    }

    //Convert numbers to characters
    public static char numToChar(int x) {
        return (char) ('a' + (x%26));
    }

    //Extend the key to match the text length
    public static String extendKey(String text, String key) {
        StringBuilder extendedKey = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            extendedKey.append(key.charAt(i % key.length()));
        }

        return extendedKey.toString();
    }

    //Encrypt using the Vigenere Cipher
    public static String vigenereEncrypt(String plaintext, String key) {
        plaintext = plaintext.replaceAll("\\s+", "").toLowerCase();
        key = key.toLowerCase();

        String extendedKey = extendKey(plaintext, key);

        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            int p = charToNum(plaintext.charAt(i));
            int k = charToNum(extendedKey.charAt(i));
            int encryptedValue = (p + k) % 26;
            ciphertext.append(numToChar(encryptedValue));
        }

        return ciphertext.toString();
    }

    //Decrypt ciphertext using Vigenere Cipher
    public static String vigenereDecrypt(String ciphertext, String key) {
        ciphertext = ciphertext.toLowerCase();
        key = key.toLowerCase();

        String extendedKey = extendKey(ciphertext, key);

        StringBuilder plaintext = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            int c = charToNum(ciphertext.charAt(i));
            int k = charToNum(extendedKey.charAt(i));
            int decryptedValue = (c - k + 26) % 26;
            plaintext.append(numToChar(decryptedValue));
        }

        return plaintext.toString();
    }

}