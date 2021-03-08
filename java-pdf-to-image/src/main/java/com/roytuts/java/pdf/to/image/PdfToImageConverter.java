package com.roytuts.java.pdf.to.image;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class PdfToImageConverter {

	public static void main(String[] args) {
		try {
			String destinationDir = "pdf-to-image/";

			File sourceFile = new File("sample.pdf");
			File destinationFile = new File(destinationDir);

			if (!destinationFile.exists()) {
				destinationFile.mkdir();
				System.out.println("Folder Created -> " + destinationFile.getAbsolutePath());
			}

			if (sourceFile.exists()) {
				PDDocument document = PDDocument.load(sourceFile);
				PDFRenderer pdfRenderer = new PDFRenderer(document);

				String fileName = sourceFile.getName().replace(".pdf", "");

				// int pageNumber = 0;

				// for (PDPage page : document.getPages()) {
				for (int pageNumber = 0; pageNumber < document.getNumberOfPages(); ++pageNumber) {
					BufferedImage bim = pdfRenderer.renderImage(pageNumber);

					String destDir = destinationDir + fileName + "_" + pageNumber + ".png";

					ImageIO.write(bim, "png", new File(destDir));
				}

				document.close();

				System.out.println("Image saved at -> " + destinationFile.getAbsolutePath());
			} else {
				System.err.println(sourceFile.getName() + " File does not exist");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
