package com.app;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class Task5JavaMailSenderDemo1Application implements CommandLineRunner {

	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public static void main(String[] args) {
		SpringApplication.run(Task5JavaMailSenderDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		
		System.out.println("Sending email....");
		
		try {
			//sendEmail();
			  sendEmailWithAttachment();
		}
		catch(MailException me) {
			me.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendEmail() {
		
		SimpleMailMessage mail=new SimpleMailMessage();
		
		mail.setTo("sandiphumbe878@gmail.com","sandipsh321@yahoo.com");
		mail.setFrom("sandipsh321@gmail.com");
		mail.setSubject("JAVA MAIL SENDER DEMO TEST");
		mail.setText("Hi Sandip, Welcome to JAVA MAIL SERVICE LIBRARY. USE IT TO SEND MAILS.");
		
		javaMailSender.send(mail);
		
		System.out.println("Message Sent Successfully..");
		
	}//sendEmail
	
	public void sendEmailWithAttachment()  throws MessagingException,IOException{
		
		MimeMessage message=javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper=new  MimeMessageHelper(message, true);
		
		helper.setTo("sandiphumbe878@gmail.com");
		helper.setFrom("sandipsh321@gmail.com");
		helper.setSubject("JAVA MAIL SENDER DEMO APP WITH ATTACHMENT");
		helper.setText("<h1>HI Sandip, Welcome to JAVA MAIL LIBRARY..YOU CAN SEND EMAIL TO ANY PERSON BY USING THIS LIBRARY.</h1>",true);
		
		helper.addAttachment("dimple.jpg",new ClassPathResource("dimple.jpg"));
		
		javaMailSender.send(message);
		System.out.println("Message Sent Successfully..");
		
	}

}//class
