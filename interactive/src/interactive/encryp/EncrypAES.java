package interactive.encryp;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class EncrypAES implements Encryp {

	private KeyGenerator keygen;
	private SecretKey deskey;
	private Cipher cipher;

	public EncrypAES() throws NoSuchAlgorithmException, NoSuchPaddingException {
		Security.addProvider(new com.sun.crypto.provider.SunJCE());
		keygen = KeyGenerator.getInstance("AES");
		deskey = keygen.generateKey();
		cipher = Cipher.getInstance("AES");
	}

	@Override
	public byte[] encrypt(byte[] srcBytes) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		cipher.init(Cipher.ENCRYPT_MODE, deskey);
		byte[] cipherByte = cipher.doFinal(srcBytes);
		return cipherByte;
	}

	@Override
	public byte[] decrypt(byte[] srcBytes) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		cipher.init(Cipher.DECRYPT_MODE, deskey);
		byte[] cipherByte = cipher.doFinal(srcBytes);
		return cipherByte;
	}
}
