import java.io.*;
import java.util.*;

public class BruteForceCracker {

    // Turn dictionary into a hashset
    public static HashSet<String> loadDictionary(String filePath) throws IOException {
        HashSet<String> dictionary = new HashSet<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            dictionary.add(line.trim().toLowerCase());
        }

        reader.close();
        return dictionary;
    }

    // Generate all possible keys and test them
    public static void generateAndTestKeys(String prefix, int keyLength, String ciphertext, int firstWordLength, HashSet<String> dictionary) {

        if (prefix.length() == keyLength) {
            String plaintext = VigenereCipher.vigenereDecrypt(ciphertext, prefix);
            String firstWord = plaintext.substring(0, firstWordLength);

            if (dictionary.contains(firstWord)) {
                System.out.println("Possible Key: " + prefix);
                System.out.println("Possible Plaintext: " + plaintext);
                System.out.println();
            }

            return;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            generateAndTestKeys(prefix + c, keyLength, ciphertext, firstWordLength, dictionary);
        }
    }

    // Brute force wrapper
    public static void bruteForceVigenere(String ciphertext, int keyLength, int firstWordLength, HashSet<String> dictionary) {

        long startTime = System.currentTimeMillis();

        generateAndTestKeys("", keyLength, ciphertext, firstWordLength, dictionary);

        long endTime = System.currentTimeMillis();

        System.out.println("Time to complete: " + (endTime - startTime) + "ms");
    }

}