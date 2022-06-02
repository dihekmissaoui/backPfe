package Sbchalet.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Sbchalet.demo.resource.EmailMessage;
import Sbchalet.demo.services.IEmailSenderService;

@RestController
public class Emailcontroller {
	@Autowired
	private IEmailSenderService emailSenderService;

	public void EmailController(IEmailSenderService emailSenderService) {
		this.emailSenderService = emailSenderService;
	}

	@PostMapping("/send-email")
	public ResponseEntity<String> sendEmail(@RequestBody EmailMessage emailMessage) {

		this.emailSenderService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
		return ResponseEntity.ok("Success");
	}

}
