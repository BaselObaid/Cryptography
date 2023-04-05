/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cryptographyalgorithms;

import java.nio.charset.StandardCharsets;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.Base64;

abstract public class Algorithm {

    private String plainText;
    private byte[] keyBytes;
    private SecretKeySpec key;
    private byte[] iv;
    private Cipher cipher;

    public Algorithm() {
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

    public byte[] getKeyBytes() {
        return keyBytes;
    }

    public void setKeyBytes(byte[] keyBytes) {
        this.keyBytes = keyBytes;
    }

    public SecretKeySpec getKey() {
        return key;
    }

    public void setKey(SecretKeySpec key) {
        this.key = key;
    }

    public byte[] getIv() {
        return iv;
    }

    public void setIv(byte[] iv) {
        this.iv = iv;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    //encrypt the plaintext
    public String encrypt() {
        String encryptedText = "";
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
            // Encrypt the plaintext and encode it in Base64
            byte[] encryptedBytes = cipher.doFinal(getPlainText().getBytes(StandardCharsets.UTF_8));
            encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return encryptedText;
    }

    // decrypt the cipher text
    public String decrypt(String encryptedText) {
        String decryptedText = "";
        // Decrypt the ciphertext and display the plaintext
        try {
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(iv));
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
            decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception ex) {
        }
        return decryptedText;
    }

    protected static byte[] generateRandomKey(int keysize) {

        byte[] keybyte = new byte[keysize / 8];
        //generates a sequence of random bytes and stores them in the keyBytes array.
        SecureRandom secureRandomKey = new SecureRandom();
        secureRandomKey.nextBytes(keybyte);

        return keybyte;
    }

    abstract protected byte[] generateRandomIV();

}
