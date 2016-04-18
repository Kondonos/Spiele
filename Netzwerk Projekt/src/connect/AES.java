package connect;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class AES {
	String strKey;
	String methode;
	SecretKeySpec key;
	public AES(String strKey,String methode,int length) {
		try {
			this.strKey =strKey;
			byte[] key=strKey.getBytes("UTF-8");
			Set<String> methodes=new HashSet<>();
			methodes.add("MD5");
			methodes.add("SHA-1");
			methodes.add("SHA-256");
			this.methode=methode;
			if(!methodes.contains(methode)){
				System.err.println("wrong hash methode. Choose between MD5, SHA-1 and SHA-256");
				return;
			}
			MessageDigest sha=MessageDigest.getInstance(this.methode);
			key=sha.digest(key);
			if((this.methode.equals("MD5")&& length>128) || 
			   (this.methode.equals("SHA-1") && length>160) ||
			   (this.methode.equals("SHA-256") && length>256)){
				System.err.println("Wrong length for methode");
				return;
			}
			if(length<2){
				System.err.println("Lenght is to short");
			}
			key=Arrays.copyOf(key, length);
			this.key=new SecretKeySpec(key, "AES");
			
		} catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String encrypt(String plaintext){
		Cipher cipher;	
		String secret=null;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, this.key);
			byte[] encrypted=cipher.doFinal(plaintext.getBytes());
			
			Base64.Encoder base64encoder=Base64.getEncoder();
			secret=base64encoder.encodeToString(encrypted);
			
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return secret;
	}
	
	public String decrypt(String secret){
		Base64.Decoder decoder=Base64.getDecoder();
		byte[] crypted=decoder.decode(secret);
		Cipher cipher;
		String plaintext=null;
		try {
			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, this.key);
			byte[] cipherdata=cipher.doFinal(crypted);
			plaintext=new String(cipherdata);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plaintext;
	}
}
