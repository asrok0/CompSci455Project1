import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        //Task 1: Vigenere Cipher
        String plaintext = "Testing this cipher";
        String key = "key";

        System.out.println("---------- Task 1 ----------");

        String encrypted = VigenereCipher.vigenereEncrypt(plaintext, key);
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = VigenereCipher.vigenereDecrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);
        System.out.println();


        //Task 2: Brute forcing Vigenere Cipher
        HashSet<String> dictionary = BruteForceCracker.loadDictionary("P1_dict.txt");

        System.out.println("---------- Task 2 ----------");

        String ciphertext = "diqdmlqxfswastfov";
        BruteForceCracker.bruteForceVigenere(ciphertext, 3, 7, dictionary);
        System.out.println();


        //Task 3: Brute forcing more messages
        System.out.println("---------- Task 3.1 ----------");
        String cipher1 = "MSOKKJCOSXOEEKDTOSLGFWCMCHSUSGX";
        BruteForceCracker.bruteForceVigenere(cipher1, 2, 6, dictionary);
        System.out.println();

        System.out.println("---------- Task 3.2 ----------");
        String cipher2 = "PSPDYLOAFSGFREQKKPOERNIYVSDZSUOVGXSRRIPWERDIPCFSDIQZIASEJVCGXAYBGYXFPSREKFMEXEBIYDGFKREOWGXEQSXSKXGYRRRVMEKFFIPIWJSKFDJMBGCC";
        BruteForceCracker.bruteForceVigenere(cipher2, 3, 7, dictionary);
        System.out.println();

        System.out.println("---------- Task 3.3 ----------");
        String cipher3 = "MTZHZEOQKASVBDOWMWMKMNYIIHVWPEXJA";
        BruteForceCracker.bruteForceVigenere(cipher3, 4, 10, dictionary);
        System.out.println();

        System.out.println("---------- Task 3.4 ----------");
        String cipher4 = "SQLIMXEEKSXMDOSBITOTYVECRDXSCRURZYPOHRG";
        BruteForceCracker.bruteForceVigenere(cipher4, 5, 11, dictionary);
        System.out.println();

        System.out.println("---------- Task 3.5 ----------");
        String cipher5 = "LDWMEKPOPSWNOAVBIDHIPCEWAETYRVOAUPSINOVDIEDHCDSELHCCPVHRPOHZUSERSFS";
        BruteForceCracker.bruteForceVigenere(cipher5, 6, 9, dictionary);
        System.out.println();

        System.out.println("---------- Task 3.6 ----------");
        String cipher6 = "VVVLZWWPBWHZDKBTXLDCGOTGTGRWAQWZSDHEMXLBELUMO";
        BruteForceCracker.bruteForceVigenere(cipher6, 7, 13, dictionary);
    }
}