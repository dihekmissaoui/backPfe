package Sbchalet.demo.services;

import org.apache.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderServiceImpl implements IEmailSenderService{

    private final JavaMailSender mailSender;


    public EmailSenderServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
	private static final Logger logger = Logger.getLogger(EmailSenderServiceImpl.class);

	@Override
	
	public void sendEmail(String to, String subject, String message) {
		try {
			logger.info("je vais envoyer un Email ");
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	        simpleMailMessage.setFrom("dihekmissaoui23@gmail.com");
	        logger.debug("je veux envoyer A :"+to);
	        simpleMailMessage.setTo(to);
	        logger.debug("Mon objet  :"+subject);
	        simpleMailMessage.setSubject(subject);
	        logger.debug("Mon Message  :"+message);
	        simpleMailMessage.setText(message);
	        this.mailSender.send(simpleMailMessage);
	        logger.info("Email envoyer avec succes ");
			
		} catch (Exception e) {
			logger.error("Error avec  sendEmail() :", e);
		}
		
		
	}

}
