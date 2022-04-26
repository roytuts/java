package com.roytuts.java.bulk.email.send;

import java.util.Date;
import java.util.Objects;
import java.util.Properties;
import java.util.function.Function;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class BulkEmailSender {

	private EmailInfo emailInfo;
	private Properties emailConfig;
	private MimeMessage mimeMessage;

	public BulkEmailSender(EmailInfo emailInfo, Properties emailConfig) {
		this.emailInfo = emailInfo;
		this.emailConfig = emailConfig;
	}

	public EmailInfo getEmailInfo() {
		return emailInfo;
	}

	public void sendEmail(MimeMessage mimeMessage) {
		try {
			Transport.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MimeMessage getMimeMessage() {
		mimeMessage = buildMimeMessage();
		return mimeMessage;
	}

	private MimeMessage buildMimeMessage() {
		Session session = Session.getInstance(emailConfig);
		MimeMessage mimeMessage = new MimeMessage(session);

		// if you want to use authentication for your email, so "mail.smtp.auth" need to
		// be set true
		// Session session = Session.getInstance(emailConfig, new Authenticator() {
		// @Override
		// protected PasswordAuthentication getPasswordAuthentication() {
		// return new PasswordAuthentication("username", "password");
		// }
		// });

		try {
			setFromAddress().andThen(setToAddress()).andThen(setCcAddress()).andThen(setSubject()).apply(mimeMessage);

			mimeMessage.setSentDate(new Date());
		} catch (Exception e) {
			mimeMessage = null;
			throw new RuntimeException("Error in setting from, to, cc address and subject of the email");
		}

		return mimeMessage;
	}

	private Function<MimeMessage, MimeMessage> setSubject() {
		return mimeMessage -> {
			if (!Objects.isNull(emailInfo.getSubject()) && !emailInfo.getSubject().isEmpty()) {
				try {
					mimeMessage.setSubject(emailInfo.getSubject());
				} catch (Exception e) {
					throw new RuntimeException("Could not set subject " + emailInfo.getSubject());
				}
			}
			return mimeMessage;
		};
	}

	private Function<MimeMessage, MimeMessage> setFromAddress() {
		return mimeMessage -> {
			if (!Objects.isNull(emailInfo.getFrom()) && !emailInfo.getFrom().isEmpty()) {
				try {
					mimeMessage.setFrom(new InternetAddress(emailInfo.getFrom().trim()));
				} catch (Exception e) {
					throw new RuntimeException("Could not resolve from address " + emailInfo.getFrom());
				}
			}
			return mimeMessage;
		};
	}

	private Function<MimeMessage, MimeMessage> setToAddress() {
		return mimeMessage -> {
			if (!Objects.isNull(emailInfo.getToList()) && !emailInfo.getToList().isEmpty()) {
				try {
					mimeMessage.setRecipients(Message.RecipientType.TO, emailInfo.getToList().stream().map(to -> {
						try {
							return new InternetAddress(to);
						} catch (AddressException e) {
							throw new RuntimeException("Could not resolve to address");
						}
					}).toArray(InternetAddress[]::new));
				} catch (MessagingException e) {
					throw new RuntimeException(
							"Could not set to address in message " + emailInfo.getToList().toString());
				}
			}
			return mimeMessage;
		};
	}

	private Function<MimeMessage, MimeMessage> setCcAddress() {
		return mimeMessage -> {
			if (!Objects.isNull(emailInfo.getToList()) && !emailInfo.getCcList().isEmpty()) {
				try {
					mimeMessage.setRecipients(Message.RecipientType.CC, emailInfo.getCcList().stream().map(to -> {
						try {
							return new InternetAddress(to);
						} catch (AddressException e) {
							throw new RuntimeException("Could not resolve cc address");
						}
					}).toArray(InternetAddress[]::new));
				} catch (MessagingException e) {
					throw new RuntimeException(
							"Could not set cc address in message " + emailInfo.getCcList().toString());
				}
			}
			return mimeMessage;
		};
	}

}
