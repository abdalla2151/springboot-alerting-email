package com.emailsender.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.emailsender.dto.EmailDto;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	JavaMailSender emailSender;

	@Value("${from_mail}")
	private String fromMail;

	public void sendSimpleMessage(EmailDto emailDto) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(fromMail);
		message.setTo(emailDto.getToEmail());
		message.setSubject(emailDto.getMailSubject());
		message.setText(emailDto.getMailText());
		emailSender.send(message);

	}

	public void sendHtmlMessage(EmailDto emailDto) throws MessagingException {

		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setFrom(fromMail);
		helper.setTo(emailDto.getToEmail());
		helper.setSubject(emailDto.getMailSubject());
		helper.setText(emailDto.getMailText(), true);
		emailSender.send(message);
	}

}
