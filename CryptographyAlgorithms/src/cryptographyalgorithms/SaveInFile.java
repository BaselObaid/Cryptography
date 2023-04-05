/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cryptographyalgorithms;


  import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
/**
 *
 * @author basel_c8nyn
 */
public class SaveInFile  {
    


    private SecretKey secretKey;
    private Cipher cipher;

    public SaveInFile() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
        secretKey = keyGenerator.generateKey();
        cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
    }

    public byte[] encryptTripleDES(String message, byte[] iv) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] messageBytes = message.getBytes("UTF-8");
        byte[] encryptedBytes = cipher.doFinal(messageBytes);
        return encryptedBytes;
    }

    public String decryptTripleDES(byte[] encryptedBytes, byte[] iv) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String message = new String(decryptedBytes, "UTF-8");
        return message;
    }
}
    
    


