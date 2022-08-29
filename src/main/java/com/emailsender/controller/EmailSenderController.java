package com.emailsender.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.emailsender.dto.EmailDto;
import com.emailsender.service.EmailService;

@RestController
@CrossOrigin(origins = { "${settings.cors_origin.public}", "${settings.cors_origin.business}" })
public class EmailSenderController {

	@Autowired
	EmailService emailService;

	@RequestMapping(value = "/sendSimpleEMail", method = RequestMethod.POST)
	public ResponseEntity sendEmail(@RequestBody EmailDto emailDto) {

		if (emailDto != null) {
			emailService.sendSimpleMessage(emailDto);
		} else {
			return ResponseEntity.internalServerError().body("The Mail DTO is null");
		}

		return ResponseEntity.ok().build();

	}

	@RequestMapping(value = "/sendMail", method = RequestMethod.POST)
	public ResponseEntity sendHtmlMessage(@RequestBody EmailDto emailDto) throws MessagingException {

		if (emailDto != null) {
			emailService.sendHtmlMessage(emailDto);
		} else {
			return ResponseEntity.internalServerError().body("The Mail DTO is null");
		}

		return ResponseEntity.ok().build();

	}

}
