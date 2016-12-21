package interactive.encryp;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncrypRSA implements Encryp {

	private KeyPair keyPair;

	public EncrypRSA() throws NoSuchAlgorithmException {
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(1024);
		this.keyPair = keyPairGen.generateKeyPair();
	}

	@Override
	public byte[] encrypt(byte[] srcBytes)
			throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {

		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		if (publicKey != null) {
			Cipher cipher = Cipher.getInstance("RSA");
			try {
				cipher.init(Cipher.ENCRYPT_MODE, publicKey);
			} catch (InvalidKeyException e) {
				e.printStackTrace();
			}
			byte[] resultBytes = cipher.doFinal(srcBytes);
			return resultBytes;
		}
		return null;
	}

	@Override
	public byte[] decrypt(byte[] srcBytes) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
			IllegalBlockSizeException, BadPaddingException {
		
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		if (privateKey != null) {
			// Cipher负责完成加密或解密工作，基于RSA
			Cipher cipher = Cipher.getInstance("RSA");
			// 根据公钥，对Cipher对象进行初始化
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			byte[] resultBytes = cipher.doFinal(srcBytes);
			return resultBytes;
		}
		return null;
	}
}
