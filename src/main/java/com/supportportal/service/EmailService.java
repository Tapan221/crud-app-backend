package com.supportportal.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;
import static com.supportportal.constant.EmailConstant.*;

@Service
public class EmailService {
	
	public void sendNewPasswordEmail(String firstName, String password, String email) throws  MessagingException {
		Message message = createMail(firstName,password,email);
		Transport transport = (Transport) getEmailSession().getTransport(SIMPLE_MAIL_TRANSFER_PROTOCOL);
		transport.connect(GMAIL_SMTP_SERVER,USERNAME,PASSWORD);
		transport.sendMessage(message, message.getAllRecipients());
		transport.close();

	}
	
	private Session getEmailSession() {
		Properties properties = System.getProperties();
		//import static com.supportportal.constant.EmailConstant.*;
		properties.put(SMTP_HOST, GMAIL_SMTP_SERVER);
		properties.put(SMTP_AUTH, true);
		properties.put(SMTP_PORT, DEFAULT_PORT);
		properties.put(SMTP_STARTTLS_ENABLE, true);
		properties.put(SMTP_STARTTLS_REQUIRED, true);
		
		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", 587);
        
      
		return Session.getInstance(properties,null);
	}
	
	private Message createMail(String firstName, String password, String email) throws AddressException, MessagingException {
		Message message = new MimeMessage(getEmailSession());
		message.setFrom(new InternetAddress(FROM_EMAIL));
		message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(email,false));
		message.addRecipients(Message.RecipientType.CC, InternetAddress.parse(CC_EMAIL,false));
		message.setSubject(EMAIL_SUBJECT);
		message.setText("Hello "+ firstName +"\n \n Your new Account password is "+password+ "\n \n The support team");
		message.setSentDate(new Date());
		return message;
		
	}

}
