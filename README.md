# vinegarCipher

This repository contains a simple implementation of the Vinegar Cipher in Java. The Vinegar Cipher is a substitution cipher that involves encrypting and decrypting messages using a key composed of random letters.

Usage
Clone the Repository:

                    git clone https://github.com/nurendraB/vinegarCipher.git
                    
                    
                    cd vinegarCipher
Compile and Run:

Compile the Java program and run it:

                                    javac VinegarCipher.java
                                    java VinegarCipher

Enter Plaintext:

Enter the plaintext when prompted.

Observe Results:
![vc](https://github.com/nurendraB/vinegarCipher/assets/70723460/e6dc335e-b865-4192-a85f-f3b9e6eb9198)

The program will display the encrypted and decrypted versions of the entered plaintext using the Vinegar Cipher.

Implementation Details
Encryption
The encryption process involves substituting each alphabetic character in the plaintext with a corresponding character from the Vinegar Alphabet. Non-alphabetic characters are preserved in the ciphertext.

Decryption
The decryption process reverses the encryption by substituting each alphabetic character in the ciphertext with the original character from the Vinegar Alphabet. Non-alphabetic characters are preserved in the decrypted text.

Key Generation
The Vinegar Cipher key is randomly generated, ensuring that it matches the length of the plaintext. The key is composed of random letters from the Vinegar Alphabet.


Encryption Formula
For each alphabetic character in the plaintext, the following steps are performed:

Skip Non-Alphabetic Characters:

If the character is not alphabetic, it is preserved in the ciphertext without any modification.
Obtain Key Character:

Retrieve the corresponding key character based on the current position in the key.
Encrypt Alphabetic Character:

Convert the alphabetic character to lowercase.
Apply the formula (plainChar + keyChar - 2 * 'a') % 26 + 'a' to obtain the encrypted character.
This formula involves modular arithmetic to ensure that the result falls within the range of lowercase alphabet characters.
Preserve Case:

If the original character in the plaintext was uppercase, convert the encrypted character to uppercase.
Decryption Formula
For each alphabetic character in the ciphertext, the following steps are performed:

Skip Non-Alphabetic Characters:

If the character is not alphabetic, it is preserved in the decrypted text without any modification.
Obtain Key Character:

Retrieve the corresponding key character based on the current position in the key.
Decrypt Alphabetic Character:

Convert the alphabetic character to lowercase.
Apply the formula (encryptedChar - keyChar + 26) % 26 + 'a' to obtain the decrypted character.
This formula involves modular arithmetic to ensure that the result falls within the range of lowercase alphabet characters.
Preserve Case:

If the original character in the ciphertext was uppercase, convert the decrypted character to uppercase.
