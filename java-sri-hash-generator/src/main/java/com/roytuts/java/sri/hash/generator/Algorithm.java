package com.roytuts.java.sri.hash.generator;

public enum Algorithm {

	SHA256("SHA-256"), //
	SHA384("SHA-384"), //
	SHA512("SHA-512");

	private final String code;

	private Algorithm(final String code) {
		this.code = code;
	}

	public String getName() {
		return name();
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return code;
	}

}
