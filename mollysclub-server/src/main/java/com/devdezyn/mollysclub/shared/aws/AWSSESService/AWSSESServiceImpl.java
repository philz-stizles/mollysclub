package com.devdezyn.mollysclub.shared.aws.AWSSESService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
@RequiredArgsConstructor
public class AWSSESServiceImpl implements AWSSESService {

    @Value("${app.email.from}")
    private String FROM;
    
    @Value("${app.email.from-name}")
    private String FROMNAME;
	
    // Replace recipient@example.com with a "To" address. If your account 
    // is still in the sandbox, this address must be verified.
    // static final String TO = "recipient@example.com";
    
    @Value("${app.mail.aws.ses.username}")
    private String SMTP_USERNAME;
    
    @Value("${app.mail.aws.ses.password}")
    private final String SMTP_PASSWORD = "SMTP password";
    
    // The name of the Configuration Set to use for this message.
    // If you comment out or remove this variable, you will also need to
    // comment out or remove the header below.
    // private final String CONFIGSET = "ConfigSet"; //← Comment out if unnecessary ★
    
    @Value("${app.mail.aws.ses.host}")
    private String HOST;
    
    @Value("${app.mail.aws.ses.port}")
    private int PORT;
    
    // static final String SUBJECT = "Amazon SES test (SMTP interface accessed using Java)";
    
    // static final String BODY = String.join(
    // 	    System.getProperty("line.separator"),
    // 	    "<h1>Amazon SES SMTP Email Test</h1>",
    // 	    "<p>This email was sent with Amazon SES using the ", 
    // 	    "<a href='https://github.com/javaee/javamail'>Javamail Package</a>",
    // 	    " for <a href='https://www.java.com'>Java</a>."
    // 	);

	public void send(String to, String subject, String body) throws Exception {

        // Create a Properties object to contain connection configuration information.
    	Properties props = System.getProperties();
    	props.put("mail.transport.protocol", "smtp");
    	props.put("mail.smtp.port", PORT); 
    	props.put("mail.smtp.starttls.enable", "true");
    	props.put("mail.smtp.auth", "true");

        // Create a Session object to represent a mail session with the specified properties. 
    	Session session = Session.getDefaultInstance(props);

        // Create a message with the specified information. 
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(FROM,FROMNAME));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        msg.setSubject(subject);
        msg.setContent(body,"text/html");
        
        // Add a configuration set header. Comment or delete the 
        // next line if you are not using a configuration set
        // msg.setHeader("X-SES-CONFIGURATION-SET", CONFIGSET);//← Comment out if unnecessary ★
            
        // Create a transport.
        Transport transport = session.getTransport();
                    
        // Send the message.
        try
        {
            System.out.println("Sending...");
            
            // Connect to Amazon SES using the SMTP username and password you specified above.
            transport.connect(HOST, SMTP_USERNAME, SMTP_PASSWORD);
        	
            // Send the email.
            transport.sendMessage(msg, msg.getAllRecipients());
            System.out.println("Email sent!");
        }
        catch (Exception ex) {
            System.out.println("The email was not sent.");
            System.out.println("Error message: " + ex.getMessage());
        }
        finally
        {
            // Close and terminate the connection.
            transport.close();
        }
    }
}
