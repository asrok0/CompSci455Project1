public class Main {
    public static void main(String[] args) {

        //Task 1: Vignere Cipher
        String plaintext = "This is a test";
        String key = "testkey";

        String encrypted = VignereCipher.vignereEncrypt(plaintext, key);
        System.out.println("Plaintext: " + plaintext);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = VignereCipher.vignereDecrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);

    }
}