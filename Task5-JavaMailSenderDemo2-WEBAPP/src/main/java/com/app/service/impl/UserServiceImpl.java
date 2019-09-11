package com.app.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public String saveUser(User u) {
		String message=null;
		try {
			//String message=sendEmail(u);
			 message=sendEmailWithAttachment(u);
		}
		catch(MessagingException me) {
			me.printStackTrace();
		}
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
	
	public String sendEmailWithAttachment(User u) throws MessagingException {
		
		MimeMessage message=javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper=new MimeMessageHelper(message, true);
		String[] to= {"sandiphumbe878@gmail.com","sandipsh321@yahoo.com"};
		helper.setTo(to);
		helper.setFrom("sandipsh321@gmail.com");
		helper.setSubject("JAVA MAIL SENDER WEB APP DEMO WITH ATTACHEMENT");
		helper.setText("<h1>Hi Sandip, This is a demo mail to check JAVA MAIL SENDER WEB APP FUNCTIONALITY.</h1>", true);
	
		helper.addAttachment("dreams.jpg", new ClassPathResource("static/dreams.jpg"));
		
		javaMailSender.send(message);

	    return " Message sent successfully to registered email id..";
		
	}//sendEmailWithAttachement()

}//class