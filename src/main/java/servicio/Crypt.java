/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.decodeBase64;
import static org.apache.commons.codec.binary.Base64.encodeBase64;

/**
 *
 * @author ghernandez
 */
public class Crypt {

    // Algoritmo (AES, DES, RSA)
    private final static String algoritmo = "AES";
    // Tipo de cifrado, por bloques, padding etc.
    private final static String tipoCifrado = "AES/CBC/PKCS5Padding";

    /**
     Función para encriptación de un String mediante algoritmo AES por bloques con los siguientes parámetros:     
      @param llave tipo String a utilizar
      @param iv el vector de inicialización
      @param texto el texto a encriptar
      @return el texto cifrado en modo String codificado en base64
      @throws Exception excepciones que puede devolver: NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException
     */
    public static String encrypt(String llave, String iv, String texto) throws Exception {
            Cipher cipher = Cipher.getInstance(tipoCifrado);
            SecretKeySpec secretKeySpec = new SecretKeySpec(llave.getBytes(), algoritmo);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(texto.getBytes());
            return new String(encodeBase64(encrypted));
    }

    /**
    Función para desencriptar un String mediante algoritmo AES por bloques con los siguientes parámetros:     
     @param llave tipo String a utilizar
     @param iv el vector de inicialización
     @param encrypted el texto a desencriptar previamente encriptado con la misma llave y codificado en base64
     @return el texto descrifrado en modo String codificado en base64
     @throws Exception excepciones que puede devolver: NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException
    */
    public static String decrypt(String llave, String iv, String encrypted) throws Exception {
            Cipher cipher = Cipher.getInstance(tipoCifrado);
            SecretKeySpec secretKeySpec = new SecretKeySpec(llave.getBytes(), algoritmo);
            IvParameterSpec ivParameterSpec = new IvParameterSpec(iv.getBytes());
            byte[] enc = decodeBase64(encrypted);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
            byte[] decrypted = cipher.doFinal(enc);
            return new String(decrypted);
    }

}
