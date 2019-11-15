package com.roytuts.httpserver.enums;

public enum HttpMethod {

	GET, //
	POST, //
	PUT, //
	DELETE, //
	HEAD;

	public String getName() {
		return name();
	}

	@Override
	public String toString() {
		return name();
	}

}
