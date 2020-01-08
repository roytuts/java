package com.roytuts.java.count.word.para.sentence.whitespace.text.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaCountWordParaSentenceWhitespaceTextFile {

	public static void main(String[] args) throws IOException {
		countWordParaSentenceWhitespaceTextFile(new File("C:/jee_workspace/sample.txt"));
	}

	public static void countWordParaSentenceWhitespaceTextFile(final File file) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

		String line;
		int countWord = 0;
		int sentenceCount = 0;
		int characterCount = 0;
		int paragraphCount = 1;
		int whitespaceCount = 0;

		while ((line = br.readLine()) != null) {

			if (line.equals("")) {
				paragraphCount++;
			} else {
				characterCount += line.length();

				String[] wordList = line.split("\\s+");

				countWord += wordList.length;

				whitespaceCount += countWord - 1;

				String[] sentenceList = line.split("[!?.:]+");

				sentenceCount += sentenceList.length;
			}

		}

		System.out.println("Total number of words = " + countWord);

		System.out.println("Total number of sentences = " + sentenceCount);

		System.out.println("Total number of characters = " + characterCount);

		System.out.println("Total number of paragraphs = " + paragraphCount);

		System.out.println("Total number of whitespaces = " + whitespaceCount);
	}
}
