package com.app;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

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
			sendEmail();
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

}//class
