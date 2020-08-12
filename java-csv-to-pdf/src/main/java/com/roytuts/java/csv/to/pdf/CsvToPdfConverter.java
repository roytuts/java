package com.roytuts.java.csv.to.pdf;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CsvToPdfConverter {

	public static void main(String[] args) throws IOException, DocumentException {
		Path path = Paths.get("student.csv");

		byte[] bytes = Files.readAllBytes(path);

		String str = new String(bytes);

		String[] splitted = Arrays.stream(str.split("\n")).map(String::trim).toArray(String[]::new);

		// System.out.println(Arrays.toString(splitted));

		List<String> list = Arrays.asList(splitted);

		Document document = new Document(PageSize.A4, 25, 25, 25, 25);
		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("student.pdf"));

		document.open();

		Paragraph heading = new Paragraph("~: Student Details :~",
				FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD, new BaseColor(0, 255, 0)));

		document.add(heading);

		PdfPTable t = new PdfPTable(4);
		t.setSpacingBefore(25);
		t.setSpacingAfter(25);

		boolean isHeader = true;
		for (String record : list) {
			String[] line = Arrays.stream(record.split(",")).map(String::trim).toArray(String[]::new);

			String id = line[0];
			String dob = line[1];
			String email = line[2];
			String address = line[3];

			if (isHeader) {
				PdfPCell c1 = new PdfPCell(new Phrase(id));
				t.addCell(c1);

				PdfPCell c2 = new PdfPCell(new Phrase(dob));
				t.addCell(c2);

				PdfPCell c3 = new PdfPCell(new Phrase(email));
				t.addCell(c3);

				PdfPCell c4 = new PdfPCell(new Phrase(address));
				t.addCell(c4);
			} else {
				PdfPCell c1 = new PdfPCell(new Phrase(id));
				t.addCell(c1);

				PdfPCell c2 = new PdfPCell(new Phrase(dob));
				t.addCell(c2);

				PdfPCell c3 = new PdfPCell(new Phrase(email));
				t.addCell(c3);

				PdfPCell c4 = new PdfPCell(new Phrase(address));
				t.addCell(c4);
			}

		}

		document.add(t);

		document.close();
		pdfWriter.close();
	}

}
