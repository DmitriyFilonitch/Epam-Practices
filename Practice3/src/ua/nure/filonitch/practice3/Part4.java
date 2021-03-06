package ua.nure.filonitch.practice3;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Part4 {
	private static final int CONSTANT1 = 16;

	public static void main(String[] args) {
		System.out.println("MD5     :   " + hash("passw", "MD5"));
		System.out.println("SHA-256 :   " + hash("passw", "SHA-256"));
	}

	public static String hash(String input, String algorithm) {
		byte[] hash;
		char[] chars = null;
		try {
			MessageDigest digest = MessageDigest.getInstance(algorithm);
			digest.update(input.getBytes("Cp1251"));

			hash = digest.digest();
			chars = new char[hash.length * 2];

			for (int k = 0; k < hash.length; k++) {
				symbolToChars(hash[k], chars, k);
			}
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
			System.out.println("Exception!!!");
		}

		return new String(chars);

	}

	private static void symbolToChars(byte b, char[] chars, int k) {
		int symbolUpper = b & 0b1111_0000;
		symbolUpper = Math.abs(symbolUpper / CONSTANT1);
		chars[k * 2] = symbolToHex(symbolUpper);
		int symbolLower = b & 0b0000_1111;
		chars[k * 2 + 1] = symbolToHex(symbolLower);
	}

	private static char symbolToHex(int e) {
		return (e < 10) ? (char) (e + '0') : (char) (e + 'A' - 10);
	}

}
