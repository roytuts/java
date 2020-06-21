package com.roytuts.java.read.csv.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CsvReader {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("C:/jee_workspace/sample.csv");
		byte[] bytes = Files.readAllBytes(path);

		String str = new String(bytes);

		String[] splitted = Arrays.stream(str.split("\n")).map(String::trim).toArray(String[]::new);

		// System.out.println(Arrays.toString(splitted));

		List<String> list = Arrays.asList(splitted);

		//System.out.println();

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

}
