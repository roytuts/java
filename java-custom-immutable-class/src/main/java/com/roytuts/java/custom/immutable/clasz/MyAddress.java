package com.roytuts.java.custom.immutable.clasz;

public class MyAddress extends Address implements Cloneable {

	public MyAddress(String city, String country) {
		super(city, country);
	}

	@Override
	public void setCity(String city) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setCountry(String country) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (Exception e) {
			return null;
		}
	}
}
