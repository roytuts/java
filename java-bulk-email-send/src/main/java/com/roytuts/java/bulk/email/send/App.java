package com.roytuts.java.bulk.email.send;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import jakarta.mail.BodyPart;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class App {

	public static void main(String[] args) {
		// Email config
		Properties emailConfig = new Properties();
		emailConfig.put("mail.smtp.user", "smtp username");
		emailConfig.put("mail.smtp.host", "smtp host");
		emailConfig.put("mail.smtp.auth", false);
		emailConfig.put("mail.smtp.starttls.enable", false);

		// Email Info
		EmailInfo emailInfo = new EmailInfo("email@email.com", Arrays.asList("email1@email.com", "email2@email.com"),
				Arrays.asList("email1@email.com", "email2@email.com"), "Subject");

		// Sending simple email
		BulkEmailSender bulkEmailSender = new BulkEmailSender(emailInfo, emailConfig);
		MimeMessage mimeMessage = bulkEmailSender.getMimeMessage();
		Multipart multipart = new MimeMultipart();
		BodyPart bodyPart = new MimeBodyPart();
		try {
			bodyPart.setContent("Please find the email regarding ....", "text/html;charset=utf-8");
			multipart.addBodyPart(bodyPart);
			mimeMessage.setContent(multipart);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		bulkEmailSender.sendEmail(mimeMessage);

		// Sending email with attachment
		BulkEmailSender bulkEmailSender2 = new BulkEmailSender(emailInfo, emailConfig);
		MimeMessage mimeMessage2 = bulkEmailSender2.getMimeMessage();
		Multipart multipart2 = new MimeMultipart();
		BodyPart bodyPart2 = new MimeBodyPart();
		MimeBodyPart attachPart = new MimeBodyPart();
		File attachment = new File("test.txt");
		try {
			bodyPart.setContent("Please find the attachment in the email regarding ....", "text/html;charset=utf-8");
			multipart2.addBodyPart(bodyPart2);
			attachPart.setFileName(attachment.getName());
			attachPart.attachFile(attachment);
			multipart2.addBodyPart(attachPart);
			mimeMessage2.setContent(multipart2);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		bulkEmailSender.sendEmail(mimeMessage2);
	}

}
