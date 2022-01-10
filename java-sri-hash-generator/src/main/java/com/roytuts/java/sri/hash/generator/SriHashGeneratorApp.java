package com.roytuts.java.sri.hash.generator;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SriHashGeneratorApp {

	public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
		String sri = generateSriHash(new File("src/main/resources/sample.js"), Algorithm.SHA256);

		System.out.println("SRI 256: " + sri);

		sri = generateSriHash(new File("src/main/resources/sample.js"), Algorithm.SHA384);

		System.out.println("SRI 384: " + sri);

		sri = generateSriHash(new File("src/main/resources/sample.js"), Algorithm.SHA512);

		System.out.println("SRI 512: " + sri);
	}

	public static String generateSriHash(File file, Algorithm algorithm) throws IOException, NoSuchAlgorithmException {
		byte[] data = Files.readAllBytes(file.toPath());

		MessageDigest digester = MessageDigest.getInstance(algorithm.getCode());
		digester.update(data);

		return Base64.getEncoder().encodeToString(digester.digest());
	}

}
