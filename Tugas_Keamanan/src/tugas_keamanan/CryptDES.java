/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas_keamanan;

import org.apache.commons.codec.binary.Base64;
import javax.crypto.*;


public class CryptDES {
    private Cipher encryptCipher = null;
    
    private Cipher decryptCipher = null;
    
    //konstruktor dari class dan mengambil key
    
    public CryptDES(SecretKey Key)throws Exception {
        
        encryptCipher = Cipher.getInstance("DES");
        
        decryptCipher = Cipher.getInstance("DES");
        
        encryptCipher.init(Cipher.ENCRYPT_MODE, Key);
        
        decryptCipher.init(Cipher.DECRYPT_MODE, Key);
    }
    //method untuk proses enkripsi
    public String encryptBase64 (String unencryptedString)throws Exception {
        byte[] unencryptedByteArray = unencryptedString.getBytes("UTF8");
        
        byte[] encryptedBytes = encryptCipher.doFinal(unencryptedByteArray);
        
        byte[] encodeBytes = Base64.encodeBase64(encryptedBytes);
        
        return new String(encodeBytes);
      
    }
    
    //method untuk proses dekripsi
    public String decryptBase64 (String encryptedString) throws Exception {
        byte[] decodeBytes = Base64.decodeBase64(encryptedString.getBytes());
        
        byte[] unencryptedByteArray = decryptCipher.doFinal (decodeBytes);
        
        return new String(unencryptedByteArray, "UTF8");
        
    }
}
