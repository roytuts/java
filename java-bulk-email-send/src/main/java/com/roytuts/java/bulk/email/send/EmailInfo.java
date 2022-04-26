package com.roytuts.java.bulk.email.send;

import java.util.Arrays;
import java.util.List;

public class EmailInfo {

	private String from;
	private List<String> toList;
	private List<String> ccList;
	private String subject;
	private String bodyTemplate;

	public EmailInfo(String from, String[] toList, String[] ccList, String subject) {
		this.from = from;
		this.toList = Arrays.asList(toList);
		this.ccList = Arrays.asList(ccList);
		this.subject = subject;
	}

	public EmailInfo(String from, List<String> toList, List<String> ccList, String subject) {
		this.from = from;
		this.toList = toList;
		this.ccList = ccList;
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public List<String> getToList() {
		return toList;
	}

	public void setToList(List<String> toList) {
		this.toList = toList;
	}

	public List<String> getCcList() {
		return ccList;
	}

	public void setCcList(List<String> ccList) {
		this.ccList = ccList;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBodyTemplate() {
		return bodyTemplate;
	}

	public void setBodyTemplate(String bodyTemplate) {
		this.bodyTemplate = bodyTemplate;
	}

}
