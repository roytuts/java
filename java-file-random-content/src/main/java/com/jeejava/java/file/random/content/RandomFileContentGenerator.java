package com.jeejava.java.file.random.content;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.kohsuke.randname.RandomNameGenerator;

public class RandomFileContentGenerator {

	private static File root = new File("./data");
	private final String fileName;
	private final int lines;

	RandomFileContentGenerator(String fileName, int lineCount) {
		this.fileName = fileName;
		this.lines = lineCount;
	}

	void generate() throws IOException {
		Path fullPath = new File(root, fileName).toPath();
		// make sure file exists
		Files.createDirectories(fullPath.getParent());

		RandomNameGenerator rng = new RandomNameGenerator(0);

		try (BufferedWriter bw = Files.newBufferedWriter(fullPath)) {
			for (int i = 0; i < lines; ++i) {
				String line = String.format("%s %s%n", rng.next(), rng.next());
				bw.write(line);
			}
		}
	}

}
