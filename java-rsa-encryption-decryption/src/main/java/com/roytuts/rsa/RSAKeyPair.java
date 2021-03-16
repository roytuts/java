package com.roytuts.rsa;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class RSAKeyPair {

	public static KeyPair keyPairRSA() {
		KeyPairGenerator generator = null;
		try {
			generator = KeyPairGenerator.getInstance(RSAConstants.ALGORITHM);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (generator != null) {
			generator.initialize(RSAConstants.ALGORITHM_BITS);
			KeyPair keyPair = generator.genKeyPair();
			return keyPair;
		}
		return null;
	}

}
