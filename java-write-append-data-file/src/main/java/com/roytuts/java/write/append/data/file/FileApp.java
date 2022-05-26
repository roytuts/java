package com.roytuts.java.write.append.data.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileApp {

	public static void main(String[] args) throws IOException {
		writeAppendToFile(null);
	}

	public static void writeAppendToFile(final String fileName) throws IOException {
		String outFileName = null;
		if (fileName == null || fileName.trim().length() <= 0) {
			final Date date = new Date();
			final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			outFileName = sdf.format(date) + ".txt";
		} else {
			outFileName = fileName;
		}

		PrintWriter pw = null;
		final File file = new File(outFileName);

		if (file.exists() && !file.isDirectory()) {
			pw = new PrintWriter(new FileWriter(file, true));

			pw.printf("This is an existing file");
			pw.println();
		} else {
			pw = new PrintWriter(new FileWriter(file));

			pw.printf("This is a new file");
			pw.println();
		}

		pw.close();
	}

}
