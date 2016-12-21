package interactive.encryp;

public interface Encryp {
	
	byte[] encrypt(byte[] srcBytes) throws Exception;
	
	byte[] decrypt(byte[] srcBytes) throws Exception;
}
