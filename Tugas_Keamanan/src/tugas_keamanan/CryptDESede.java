
package tugas_keamanan;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.apache.commons.codec.binary.Base64;


public class CryptDESede {
    private Cipher encryptCipher = null;
    
    private Cipher decryptCipher = null;
    
    //konstruktor dari class dan mengambil key
    
    public CryptDESede(SecretKey key) throws Exception {
        encryptCipher = Cipher.getInstance("DESede");
        
        decryptCipher = Cipher.getInstance("DESede");
        
        encryptCipher.init(Cipher.ENCRYPT_MODE, key);
        
        decryptCipher.init(Cipher.DECRYPT_MODE, key);
    }
    //method untuk proses enkripsi
    
    public String encrpytBase64 (String unencryptedString) throws Exception {
        byte [] unencryptedByteArray = unencryptedString.getBytes("UTF8");
        
        byte [] encryptedBytes = encryptCipher.doFinal(unencryptedByteArray);
        
        byte [] encodeBytes = Base64.encodeBase64(encryptedBytes);
        
        return new String(encodeBytes);
    }
    
    //method untuk proses dekripsi
    public String decrpytBase64 (String encrpyedString)throws Exception {
        byte [] decodeBytes = Base64.decodeBase64(encrpyedString.getBytes());
        
        byte [] unencryptedByteArray = decryptCipher.doFinal (decodeBytes);
        
        return new String(unencryptedByteArray, "UTF8");
    }
}
