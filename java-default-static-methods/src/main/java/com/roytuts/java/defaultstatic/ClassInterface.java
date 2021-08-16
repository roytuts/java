package com.roytuts.java.defaultstatic;

public class ClassInterface implements Interface1, Interface2 {

	@Override
	public String getMsg() {
		//return Interface1.super.getMsg();
		return "Greeting";
	}

}
