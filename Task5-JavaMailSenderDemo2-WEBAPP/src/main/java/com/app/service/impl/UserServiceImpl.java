package com.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public String saveUser(User u) {
		
		String message=sendEmail(u);
		return message;
	}
	
	public String sendEmail(User u) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		
		message.setTo("sandipsh321@yahoo.com","sandiphumbe878@gmail.com");
		message.setFrom("sandipsh321@gmail.com");
		message.setSubject("JAVA MAIL SENDER WEB APP DEMO");
		message.setText("Hi Sandip, This is a demo mail to check JAVA MAIL SENDER WEB APP FUNCTIONALITY.");
		
		javaMailSender.send(message);
        return "User saved and credential Message sent successfully to registered email id..";
		
	}//sendEmail()

}//class
