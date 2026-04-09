import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //Task 1: Vigenere Cipher
        String plaintext = "This is a test";
        String key = "key";

        String encrypted = VigenereCipher.vigenereEncrypt(plaintext, key);
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = VigenereCipher.vigenereDecrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);


        //Task 2: Brute forcing Vigenere Cipher
        HashSet<String> dictionary = BruteForceCracker.loadDictionary("P1_dict.txt");
        String ciphertext = "dlgcmqkxccx";
        BruteForceCracker.bruteForceVigenere(ciphertext, 3, 4, dictionary);
    }
}