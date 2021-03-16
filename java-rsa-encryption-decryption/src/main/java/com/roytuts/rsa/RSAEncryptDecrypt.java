package com.roytuts.rsa;

import java.security.Key;

import javax.crypto.Cipher;

public class RSAEncryptDecrypt {

	public static byte[] encrypt(String original, Key privateKey) {
		if (original != null && privateKey != null) {
			byte[] bs = original.getBytes();
			byte[] encData = convert(bs, privateKey, Cipher.ENCRYPT_MODE);
			return encData;
		}
		return null;
	}

	public static byte[] decrypt(byte[] encrypted, Key publicKey) {
		if (encrypted != null && publicKey != null) {
			byte[] decData = convert(encrypted, publicKey, Cipher.DECRYPT_MODE);
			return decData;
		}
		return null;
	}

	private static byte[] convert(byte[] data, Key key, int mode) {
		try {
			Cipher cipher = Cipher.getInstance(RSAConstants.ALGORITHM);
			cipher.init(mode, key);
			byte[] newData = cipher.doFinal(data);
			return newData;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
