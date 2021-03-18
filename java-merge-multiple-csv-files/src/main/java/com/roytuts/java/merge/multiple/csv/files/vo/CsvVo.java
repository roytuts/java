package com.roytuts.java.merge.multiple.csv.files.vo;

import java.util.LinkedHashMap;
import java.util.Map;

public class CsvVo {

	private Map<String, String> keyVal;

	public CsvVo(String id) {
		keyVal = new LinkedHashMap<>();// you may also use HashMap if you don't need to keep order
	}

	public Map<String, String> getKeyVal() {
		return keyVal;
	}

	public void setKeyVal(Map<String, String> keyVal) {
		this.keyVal = keyVal;
	}

	public void put(String key, String val) {
		keyVal.put(key, val);
	}

	public String get(String key) {
		return keyVal.get(key);
	}

}
