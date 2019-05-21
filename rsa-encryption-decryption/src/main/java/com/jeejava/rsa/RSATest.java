package com.jeejava.rsa;

import java.security.Key;
import java.security.KeyPair;
import java.util.Arrays;

public class RSATest {

	public static void main(String[] args) {
		String password = "password";
		KeyPair keyPair = RSAKeyPair.keyPairRSA();
		Key publicKey = keyPair.getPublic();
		Key privateKey = keyPair.getPrivate();

		System.out.println("Encrypt Start");
		System.out.println("Original: " + password);
		byte[] encrypted = RSAEncryptDecrypt.encrypt(password, privateKey);
		System.out.println("Encrypted: " + new String(encrypted));
		System.out.println("Encrypt End");

		System.out.println();

		System.out.println("Decrypt Start");
		byte[] decrypted = RSAEncryptDecrypt.decrypt(encrypted, publicKey);
		System.out.println("Decrypted: " + new String(decrypted));
		System.out.println("Decrypted matches Original: " + Arrays.equals(decrypted, password.getBytes()));
		System.out.println("Decrypt End");
	}

}
