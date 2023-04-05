/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cryptographyalgorithms;

import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


/**
 *
 * @author basel_c8nyn
 */
public class AESAlgorithm extends Algorithm {

    public AESAlgorithm() {
        super.setKeyBytes(generateRandomKey(256));
        super.setKey(new SecretKeySpec(super.getKeyBytes(), "AES"));// Create a secret key from the key bytes
        super.setIv(generateRandomIV()); // Generate a random 128-bit IV
        // Create an AES cipher object and initialize it with the secret key and IV
        try {
            super.setCipher(Cipher.getInstance("AES/CBC/PKCS5Padding"));
        } catch (Exception ex) {
        }
    }

    //generate intitalize vector becuse we use CBC model
    @Override
    protected byte[] generateRandomIV() {
        byte[] ivKey = new byte[16];
        SecureRandom secureRandomIV = new SecureRandom();
        secureRandomIV.nextBytes(ivKey);
        return ivKey;
    }

}
