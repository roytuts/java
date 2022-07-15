package com.roytuts.java.lru.cache;

import java.util.concurrent.TimeUnit;

public class App {

	public static void main(String[] args) {
		LruCache<String, Integer> lru = new LruCache<String, Integer>(5, TimeUnit.SECONDS);
		
		for (int i = 1; i < 10; i++) {
			lru.put(String.valueOf(i), i * 2);
		}
	}

}
