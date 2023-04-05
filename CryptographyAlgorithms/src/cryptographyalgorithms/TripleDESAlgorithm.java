/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cryptographyalgorithms;

import static cryptographyalgorithms.Algorithm.generateRandomKey;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author basel_c8nyn
 */
public class TripleDESAlgorithm extends Algorithm {

    public TripleDESAlgorithm() {

        super.setKeyBytes(generateRandomKey(192));
        super.setKey(new SecretKeySpec(super.getKeyBytes(), "DESede"));// Create a secret key from the key bytes
        super.setIv(generateRandomIV()); // Generate a random 56-bit IV
        // Create an 3TDES cipher object and initialize it with the secret key and IV
        try {
            super.setCipher(Cipher.getInstance("DESede/CBC/PKCS5Padding"));
        } catch (Exception ex) {
        }
    }

    //generate intitalize vector becuse we use CBC model
    @Override
    protected byte[] generateRandomIV() {
        byte[] ivKey = new byte[8];
        SecureRandom secureRandomIV = new SecureRandom();
        secureRandomIV.nextBytes(ivKey);
        return ivKey;
    }
}
