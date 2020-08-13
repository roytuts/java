package com.roytuts.java.pdf.to.csv;

import java.io.FileWriter;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class PdfToCsvConverter {

	public static void main(String[] args) throws IOException, DocumentException {
		PdfReader pdfReader = new PdfReader("student.pdf");

		int pages = pdfReader.getNumberOfPages();

		FileWriter csvWriter = new FileWriter("student.csv");

		for (int i = 1; i <= pages; i++) {
			String content = PdfTextExtractor.getTextFromPage(pdfReader, i);

			String[] splitContents = content.split("\n");

			boolean isTitle = true;

			for (int j = 0; j < splitContents.length; j++) {
				if (isTitle) {
					isTitle = false;
					continue;
				}

				csvWriter.append(splitContents[j].replaceAll(" ", ","));
				csvWriter.append("\n");
			}
		}

		csvWriter.flush();
		csvWriter.close();
	}

}
