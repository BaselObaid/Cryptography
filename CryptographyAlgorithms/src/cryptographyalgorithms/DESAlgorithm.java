/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cryptographyalgorithms;

/**
 *
 * @author basel_c8nyn
 */
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

public class DESAlgorithm extends Algorithm {

    public DESAlgorithm() {

        super.setKeyBytes(generateRandomKey(64));
        super.setKey(new SecretKeySpec(super.getKeyBytes(), "DES"));// Create a secret key from the key bytes
        super.setIv(generateRandomIV()); // Generate a random 56-bit IV
        // Create an DES cipher object and initialize it with the secret key and IV
        try {
            super.setCipher(Cipher.getInstance("DES/CBC/PKCS5Padding"));
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
