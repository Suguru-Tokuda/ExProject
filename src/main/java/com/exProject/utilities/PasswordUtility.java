package com.exProject.utilities;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * This class contains methods that manipulates String values ref:
 * http://www.appsdeveloperblog.com/encrypt-user-password-example-java/
 * @author Suguru
 */
public class PasswordUtility {

	private static final Random RANDOM = new SecureRandom();
	private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String KEY = "V6vsvQJUyAdGkM6b4poeU0P1gh2LAr";
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;

	public static String getSalt(int length) {
		StringBuilder retVal = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			retVal.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return new String(retVal);
	}

	//   public static byte[] hash(char[] password, byte[] salt) {
	public static byte[] hash(char[] password) {
		PBEKeySpec spec = new PBEKeySpec(password, KEY.getBytes(), ITERATIONS, KEY_LENGTH);
		Arrays.fill(password, Character.MIN_VALUE);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}

	public static String generateSecurePassword(String password) {
		//       public static String generateSecurePassword(String password, String salt) {
		String retVal = null;
		byte[] securePassword = hash(password.toCharArray());
		retVal = Base64.getEncoder().encodeToString(securePassword);
		return retVal;
	}

	public static boolean verifyUserPassword(String providedPassword, String securedPassword) {
		//		public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt) {
		boolean retVal = false;
		String newSecurePassword = generateSecurePassword(providedPassword);
		retVal = newSecurePassword.equalsIgnoreCase(securedPassword);
		return retVal;
	}

}
