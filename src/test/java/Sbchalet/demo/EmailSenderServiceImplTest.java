package Sbchalet.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import Sbchalet.demo.repository.UserRepository;
import Sbchalet.demo.resource.EmailMessage;

class EmailSenderServiceImplTest {

	@Autowired
	UserRepository userRep ;
	@Autowired
	//@Test
	public void testsendEmail () {
		EmailMessage email = new EmailMessage();
		email.setTo("dihekmissaoui23@gmail.com");
		email.setSubject("helooooo");
		email.setMessage("message");
		Assertions.assertNotNull(email.getSubject());
		
	}
}
