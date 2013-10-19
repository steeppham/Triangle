package edu.unsw.triangle.service;

public class MailMessage 
{
	private String from;
	private String recipient;
	private String subject;
	private String body;
	
	public String getFrom() {
		return from;
	}
	public String getRecipient() {
		return recipient;
	}
	public String getSubject() {
		return subject;
	}
	public String getBody() {
		return body;
	}
	public MailMessage setFrom(String from) {
		this.from = from;
		return this;
	}
	public MailMessage setRecipient(String recipient) {
		this.recipient = recipient;
		return this;
	}
	public MailMessage setSubject(String subject) {
		this.subject = subject;
		return this;
	}
	public MailMessage setBody(String body) {
		this.body = body;
		return this;
	}
	
}
