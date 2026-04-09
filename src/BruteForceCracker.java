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
    public static void generateAndTestKeys(String prefix, int keyLength, String ciphertext, int firstWordLength, HashSet<String> dictionary, List<String> matches) {

        if (prefix.length() == keyLength) {
            String plaintext = VigenereCipher.vigenereDecrypt(ciphertext, prefix);

            if (plaintext.length() >= firstWordLength) {
                String firstWord = plaintext.substring(0, firstWordLength);

                if (dictionary.contains(firstWord)) {
                    matches.add("Possible Key: " + prefix + " | Possible Plaintext: " + plaintext);
                }
            }

            return;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            generateAndTestKeys(prefix + c, keyLength, ciphertext, firstWordLength, dictionary, matches);
        }
    }

    // Brute force wrapper
    public static void bruteForceVigenere(String ciphertext, int keyLength, int firstWordLength, HashSet<String> dictionary) {

        long startTime = System.currentTimeMillis();

        List<String> matches = new ArrayList<>();
        generateAndTestKeys("", keyLength, ciphertext, firstWordLength, dictionary, matches);

        long endTime = System.currentTimeMillis();

        for (String match : matches) {
            System.out.println(match);
        }

        System.out.println("Time to complete: " + (endTime - startTime) + "ms");
    }

}