package com.example.SpringEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailApplication {

	@Autowired
	private EmailService emailService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//		emailService.sendSimpleEmail("merryjoseph369@gmail.com",
//				"This is email body",
//				"This is email subject");

		emailService.sendEmailWithAttachment("merryjoseph369@gmail.com",
				"This is message body with attachement",
				"This is message Subject with attachment",
				"/home/merry/Desktop/note");
	}

}
