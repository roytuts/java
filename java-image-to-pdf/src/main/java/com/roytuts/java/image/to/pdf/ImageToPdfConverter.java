package com.roytuts.java.image.to.pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class ImageToPdfConverter {

	public static void main(String arg[]) throws Exception {
		File root = new File("C:/Users/SoumitraSarkar/Desktop");
		String outputFile = "sampleout.pdf";

		List<String> files = new ArrayList<String>();
		files.add("sample.jpg");
		files.add("stored-procedure-spring.jpg");

		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(new File(root, outputFile)));
		document.open();

		for (String f : files) {
			document.newPage();

			Image image = Image.getInstance(new File(root, f).getAbsolutePath());

			image.setAlignment(Element.ALIGN_CENTER);

			float imageWidth = image.getWidth();

			if (imageWidth > document.getPageSize().getWidth()) {
				int indentation = 0;
				float scaler = ((document.getPageSize().getWidth() - document.leftMargin() - document.rightMargin()
						- indentation) / image.getWidth()) * 100;
				image.scalePercent(scaler);
			}

			document.add(image);
		}

		document.close();
	}

}
