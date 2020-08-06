package com.roytuts.java.file.read.last.n.lines;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileOperation {

	public static void main(String[] args) throws IOException {
		tailFile(Paths.get("Terms and Conditions 2012_FRL.txt"), 10).forEach(line -> System.out.println(line));
	}

	public static final List<String> tailFile(final Path source, final int noOfLines) throws IOException {
		try (Stream<String> stream = Files.lines(source)) {
			FileBuffer fileBuffer = new FileBuffer(noOfLines);
			stream.forEach(line -> fileBuffer.collect(line));
			return fileBuffer.getLines();
		}
	}

	private static final class FileBuffer {
		private int offset = 0;
		private final int noOfLines;
		private final String[] lines;

		public FileBuffer(int noOfLines) {
			this.noOfLines = noOfLines;
			this.lines = new String[noOfLines];
		}

		public void collect(String line) {
			lines[offset++ % noOfLines] = line;
		}

		public List<String> getLines() {
			return IntStream.range(offset < noOfLines ? 0 : offset - noOfLines, offset)
					.mapToObj(idx -> lines[idx % noOfLines]).collect(Collectors.toList());
		}
	}

}
