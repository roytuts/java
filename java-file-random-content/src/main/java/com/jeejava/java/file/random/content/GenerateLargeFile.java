package com.jeejava.java.file.random.content;

import java.io.IOException;

public class GenerateLargeFile {

	public static void main(String[] args) throws IOException {
		new RandomFileContentGenerator("large.txt", 10000000).generate();
	}

}
