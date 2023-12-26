import java.util.Random;
import java.util.Scanner;

public class vinegarCipher {

    private static final char[] VINEGAR_ALPHABET = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print(":: Enter plaintext ::");
            String plaintext = input.nextLine();
            String key = generateVinegarKey(plaintext.length());

            // Encryption
            String ciphertext = encrypt(plaintext, key);
            System.out.println("Encrypted: " + ciphertext);

            // Decryption
            String decryptedText = decrypt(ciphertext, key);
            System.out.println("Decrypted: " + decryptedText);
        }
    }

    private static String generateVinegarKey(int length) {
        Random random = new Random();
        StringBuilder key = new StringBuilder();

        while (key.length() < length) {
            int randomIndex = random.nextInt(VINEGAR_ALPHABET.length);
            key.append(VINEGAR_ALPHABET[randomIndex]);
        }

        return key.toString();
    }

    private static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();

        for (int i = 0; i < plaintext.length(); i++) {
            char plainChar = plaintext.charAt(i);

            // Skip non-alphabetic characters
            if (!Character.isAlphabetic(plainChar)) {
                ciphertext.append(plainChar);
                continue;
            }

            char keyChar = key.charAt(i % key.length());

            char encryptedChar = (char) ((Character.toLowerCase(plainChar) + keyChar - 2 * 'a') % 26 + 'a');

            // Preserve the case of the original character
            if (Character.isUpperCase(plainChar)) {
                encryptedChar = Character.toUpperCase(encryptedChar);
            }

            ciphertext.append(encryptedChar);
        }

        return ciphertext.toString();
    }

    private static String decrypt(String ciphertext, String key) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < ciphertext.length(); i++) {
            char encryptedChar = ciphertext.charAt(i);

            // Skip non-alphabetic characters
            if (!Character.isAlphabetic(encryptedChar)) {
                decryptedText.append(encryptedChar);
                continue;
            }

            char keyChar = key.charAt(i % key.length());

            char decryptedChar = (char) ((Character.toLowerCase(encryptedChar) - keyChar + 26) % 26 + 'a');

            // Preserve the case of the original character
            if (Character.isUpperCase(encryptedChar)) {
                decryptedChar = Character.toUpperCase(decryptedChar);
            }

            decryptedText.append(decryptedChar);
        }

        return decryptedText.toString();
    }
}
