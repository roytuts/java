package com.roytuts.java.create.pdf.file.content;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfContentGenerator {

	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		PdfContentGenerator pdfContentGenerator = new PdfContentGenerator();

		final String fileName = "sample.pdf";

		pdfContentGenerator.generatePdf(fileName);
	}

	public void generatePdf(final String fileName) throws DocumentException, MalformedURLException, IOException {
		Document document = new Document(PageSize.A4, 25, 25, 25, 25);

		PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(fileName));

		document.open();

		Anchor anchorTarget = new Anchor("First page of the document.");
		anchorTarget.setName("BackToTop");

		Paragraph paragraph = new Paragraph();
		paragraph.setSpacingBefore(50);
		paragraph.add(anchorTarget);

		document.add(paragraph);

		Paragraph chapter1 = new Paragraph("Chapter 1: Sample Label",
				FontFactory.getFont(FontFactory.COURIER, 16, Font.BOLD));

		document.add(chapter1);

		Paragraph paragraph1 = new Paragraph(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.",
				FontFactory.getFont(FontFactory.HELVETICA, 12));

		document.add(paragraph1);

		document.add(new Paragraph(
				"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \\'Content here, content here\\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \\'lorem ipsum\\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose.",
				FontFactory.getFont(FontFactory.COURIER, 12, Font.UNDERLINE)));

		document.add(new Paragraph(
				"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \\'Content here, content here\\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \\'lorem ipsum\\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose.",
				FontFactory.getFont(FontFactory.HELVETICA, 12, Font.ITALIC)));

		document.add(new Paragraph(
				"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \\'Content here, content here\\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \\'lorem ipsum\\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose.",
				FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD, new BaseColor(0, 255, 0))));

		document.add(new Paragraph(
				"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \\'Content here, content here\\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \\'lorem ipsum\\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose.",
				FontFactory.getFont(FontFactory.HELVETICA, 12, Font.STRIKETHRU)));

		document.add(new Paragraph(
				"It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using \\'Content here, content here\\', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for \\'lorem ipsum\\' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose.",
				FontFactory.getFont(FontFactory.COURIER_BOLD, 12, Font.BOLDITALIC)));

		Paragraph title2 = new Paragraph("Chapter 2",
				FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new BaseColor(0, 255, 255)));
		Chapter chapter2 = new Chapter(title2, 1);
		chapter2.setNumberDepth(0);

		document.add(chapter2);

		Paragraph title21 = new Paragraph("This is Section 1 in Chapter 2",
				FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new BaseColor(0, 255, 255)));
		Section section1 = chapter2.addSection(title21);
		Paragraph someSectionText = new Paragraph("This text comes as part of section 1 of chapter 2.");
		section1.add(someSectionText);
		someSectionText = new Paragraph("Following is a 4 X 3 table.");
		section1.add(someSectionText);

		PdfPTable t = new PdfPTable(4);
		t.setSpacingBefore(25);
		t.setSpacingAfter(25);

		PdfPCell c1 = new PdfPCell(new Phrase("Header 1"));
		t.addCell(c1);

		PdfPCell c2 = new PdfPCell(new Phrase("Header 2"));
		t.addCell(c2);

		PdfPCell c3 = new PdfPCell(new Phrase("Header 3"));
		t.addCell(c3);

		PdfPCell c4 = new PdfPCell(new Phrase("Header 4"));
		t.addCell(c4);

		t.addCell("Row 1: Text under header 1");
		t.addCell("Row 1: Text under header 2");
		t.addCell("Row 1: Text under header 3");
		t.addCell("Row 1: Text under header 4");

		t.addCell("Row 2: Text under header 1");
		t.addCell("Row 2: Text under header 2");
		t.addCell("Row 2: Text under header 3");
		t.addCell("Row 2: Text under header 4");

		section1.add(t);

		List l = new List(true, false, 10);
		l.add(new ListItem("First item of list"));
		l.add(new ListItem("Second item of list"));
		section1.add(l);

		someSectionText = new Paragraph("Following is an image.");
		section1.add(someSectionText);
		Image image = Image.getInstance("sample.jpg");
		image.scaleAbsolute(120f, 120f);
		section1.add(image);

		someSectionText = new Paragraph("Following link takes you to the top");
		section1.add(someSectionText);
		Anchor anchor2 = new Anchor("Back to Top", FontFactory.getFont(FontFactory.COURIER, 14, Font.UNDERLINE));
		anchor2.setReference("#BackToTop");
		section1.add(anchor2);

		document.add(section1);

		document.close();
		pdfWriter.close();
	}
}
