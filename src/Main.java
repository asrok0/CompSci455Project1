import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //Task 1: Vigenere Cipher
        String plaintext = "This is a test";
        String key = "testkey";

        String encrypted = VigenereCipher.vigenereEncrypt(plaintext, key);
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = VigenereCipher.vigenereDecrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);


        //Task 2: Brute forcing Vigenere Cipher
        HashSet<String> dictionary = BruteForceCracker.loadDictionary("P1_dict.txt");
        String ciphertext = "mlalswymikm";
        BruteForceCracker.bruteForceVigenere(ciphertext, 7, 4, dictionary);
    }
}