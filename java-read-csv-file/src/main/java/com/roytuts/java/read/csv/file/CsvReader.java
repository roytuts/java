package com.roytuts.java.read.csv.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CsvReader {

	public static void main(String[] args) throws IOException {
		// readCsv("sample.csv");
		readCsv2("sample.csv");
	}

	public static void readCsv(final String fileName) throws IOException {
		Path path = Paths.get(fileName);
		byte[] bytes = Files.readAllBytes(path);

		String str = new String(bytes);

		String[] splitted = Arrays.stream(str.split("\n")).map(String::trim).toArray(String[]::new);

		// System.out.println(Arrays.toString(splitted));

		List<String> list = Arrays.asList(splitted);

		// System.out.println();

		boolean skipHeader = true;

		for (String string : list) {
			String[] line = Arrays.stream(string.split(",")).map(String::trim).toArray(String[]::new);

			// System.out.println(Arrays.toString(line));

			if (skipHeader) {
				skipHeader = false;
				continue;
			}

			String sl = line[0];
			String id = line[1];
			String name = line[2];
			String manager = line[3];

			System.out.println("Sl No: " + sl + ", ID: " + id + ", Name: " + name + ", Manager: " + manager);
		}
	}

	public static void readCsv2(final String fileName) throws IOException {
		Path path = Paths.get(fileName);
		Stream<String> lines = Files.lines(path).skip(1); // skipping the header

		lines.forEach(line -> {
			String[] info = line.split(",");

			String sl = info[0];
			String id = info[1];
			String name = info[2];
			String manager = info[3];

			System.out.println("Sl No: " + sl + ", ID: " + id + ", Name: " + name + ", Manager: " + manager);
		});

		lines.close();
	}

}
