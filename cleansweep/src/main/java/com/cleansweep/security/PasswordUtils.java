package com.cleansweep.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.cleansweep.entities.User;

public class PasswordUtils {

	private final static int ITERATION_NUMBER = 1593;

	/**
	 * Authenticates the user with a given login and password If password and/or
	 * login is null then always returns false. If the user does not exist in the
	 * database returns false.
	 * 
	 * @param login
	 *          String The login of the user
	 * @param password
	 *          String The password of the user
	 * @return boolean Returns true if the user is authenticated, false otherwise
	 * @throws SQLException
	 *           If the database is inconsistent or unavailable ( (Two users with
	 *           the same login, salt or digested password altered etc.)
	 * @throws NoSuchAlgorithmException
	 *           If the algorithm SHA-1 is not supported by the JVM
	 * @throws InvalidKeySpecException 
	 */
	public static boolean authenticate(String login, String password)
	    throws NoSuchAlgorithmException, InvalidKeySpecException {
		boolean authenticated = false;
		try {
			boolean userExist = true;
			// INPUT VALIDATION
			if (login == null || password == null) {
				// TIME RESISTANT ATTACK
				// Computation time is equal to the time needed by a legitimate user
				userExist = false;
				login = "";
				password = "";
			}

			String digest, salt;
			int iterations;

			String storedDigest = "";

			if (storedDigest != null) {
				String[] parts = storedDigest.split(":");

				iterations = Integer.parseInt(parts[0]);
				salt = parts[1];
				digest = parts[2];

			} else { // TIME RESISTANT ATTACK (Even if the user does not exist the
				// Computation time is equal to the time needed for a legitimate user
				digest = "000000000000000000000000000=";
				salt = "00000000000=";
				userExist = false;
			}

			byte[] bDigest = base64ToByte(digest);
			byte[] bSalt = base64ToByte(salt);

			// Compute the new DIGEST
			String proposedDigest = getHash(password, bSalt);

			authenticated = proposedDigest.equals(storedDigest) && userExist;
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return authenticated;
	}

	/**
	 * Inserts a new user in the database
	 * 
	 * @param con
	 *          Connection An open connection to a database
	 * @param login
	 *          String The login of the user
	 * @param password
	 *          String The password of the user
	 * @return boolean Returns true if the login and password are ok (not null and
	 *         length(login)<=100
	 * @throws InvalidKeySpecException
	 * @throws NoSuchAlgorithmException
	 *           If the algorithm SHA-1 or the SecureRandom is not supported by
	 *           the JVM
	 * @throws UnsupportedEncodingException
	 */
	public static User createUser(String login, String password) throws NoSuchAlgorithmException, InvalidKeySpecException
	{
		if (login != null && password != null && login.length() <= 100) {

			String digest = getHash(password, getSalt());

			User user = new User();
			user.setUsername(login);
			user.setPassword(digest);

			return user;
		} else {
			return null;
		}
	}

	/**
	 * From a password returns the corresponding digest using a generated salt
	 * 
	 * @param password
	 *          String The password to encrypt
	 * @return String The digested password
	 * @throws NoSuchAlgorithmException
	 *           If the PBKDF2WithHmacSHA1 algorithm doesn't exist
	 * @throws InvalidKeySpecException
	 */
	public static String getHash(String password, byte[] salt) throws NoSuchAlgorithmException, InvalidKeySpecException {
		char[] passChars = password.toCharArray();

		PBEKeySpec spec = new PBEKeySpec(passChars, salt, ITERATION_NUMBER, 512);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

		byte[] hash = skf.generateSecret(spec).getEncoded();

		return byteToBase64(salt) + ":" + byteToBase64(hash);
	}

	/**
	 * Returns a cryptographically secure random salt.
	 * 
	 * @return String
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt;
	}

	/**
	 * From a base 64 representation, returns the corresponding byte[]
	 * 
	 * @param data
	 *          String The base64 representation
	 * @return byte[]
	 * @throws IOException
	 */
	public static byte[] base64ToByte(String data) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		return decoder.decodeBuffer(data);
	}

	/**
	 * From a byte[] returns a base 64 representation
	 * 
	 * @param data
	 *          byte[]
	 * @return String
	 * @throws IOException
	 */
	public static String byteToBase64(byte[] data) {
		BASE64Encoder endecoder = new BASE64Encoder();
		return endecoder.encode(data);
	}

}
