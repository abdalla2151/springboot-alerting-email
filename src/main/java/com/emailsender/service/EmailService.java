package com.emailsender.service;

import javax.mail.MessagingException;

import com.emailsender.dto.EmailDto;

public interface EmailService {

	public void sendSimpleMessage(EmailDto emailDto);

	public void sendHtmlMessage(EmailDto emailDto) throws MessagingException;

}
