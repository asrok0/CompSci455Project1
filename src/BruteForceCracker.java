import java.io.*;
import java.util.*;

public class BruteForceCracker {

    // Turn dictionary.txt into a hashset
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

    // Generate all possible keys
    public static void generateKeys(String prefix, int keyLength, ArrayList<String> keys) {
        if (prefix.length() == keyLength) {
            keys.add(prefix);
            return;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            generateKeys(prefix + c,keyLength, keys);
        }
    }

    // Brute force the Vigenere Cipher
    public static void bruteForceVigenere(String ciphertext, int keyLength, int firstWordLength, HashSet<String> dictionary) {
        ArrayList<String> keys = new ArrayList<>();

        generateKeys("", keyLength, keys);

        long startTime = System.currentTimeMillis();

        for (String key : keys) {
            String plaintext = VigenereCipher.vigenereDecrypt(ciphertext, key);
            String firstWord = plaintext.substring(0, firstWordLength);

            if (dictionary.contains(firstWord)) {
                System.out.println("Possible Key: " + key);
                System.out.println("Possible Plaintext: " + plaintext);
                System.out.println();
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time to complete: " + (endTime - startTime) + "ms");
    }

}