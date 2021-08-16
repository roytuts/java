package com.roytuts.java.defaultstatic;

import java.time.LocalDateTime;

public class ClassDefaultStaticMethods implements InterfaceDefaultStaticMethods {

	@Override
	public LocalDateTime getLocalDateTime() {
		return LocalDateTime.now();
	}

}
