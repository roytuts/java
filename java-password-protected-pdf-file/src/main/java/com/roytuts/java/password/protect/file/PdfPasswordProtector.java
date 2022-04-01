package com.roytuts.java.password.protect.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfPasswordProtector {

	public static void main(String[] args) throws IOException, DocumentException {
		System.out.println();
		System.out.println("Password Protected using iTextPdf");
		protectPdf("simple.pdf", "simple_protected.pdf");
		protectPdf("gre_research_validity_data.pdf", "gre_research_validity_data_protected.pdf");

		System.out.println();
		System.out.println("Password Protected using Apache PdfBox");
		protectPdf("simple.pdf", "simple2_protected.pdf");
		protectPdf("gre_research_validity_data.pdf", "gre_research_validity_data2_protected.pdf");
	}

	public static void protectPdf(String sourceFile, String destFile) throws IOException, DocumentException {
		PdfReader reader = new PdfReader(sourceFile);
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(destFile));
		stamper.setEncryption("roytuts".getBytes(), "roytuts".getBytes(), PdfWriter.ALLOW_PRINTING,
				PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
		stamper.close();
		reader.close();
	}

	public static void protectPdfBox(String sourceFile, String destFile) throws IOException {
		PDDocument document = Loader.loadPDF(new File(sourceFile));
		AccessPermission ap = new AccessPermission();
		StandardProtectionPolicy spp = new StandardProtectionPolicy("roytuts", "roytuts", ap);
		spp.setEncryptionKeyLength(128);
		// spp.setPermissions(ap);
		document.protect(spp);

		FileOutputStream os = new FileOutputStream(destFile);
		document.save(os);
		document.close();
	}

}
