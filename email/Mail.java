package com.sharingan.comp380ecommercewebsite.email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class Mail{

	

	public static void sendEmail() {

		//Email that will be used for authentication
		final String username = "naruto.uchih.sharingan@gmail.com";

		//password for the email being used to authenticate
		final String password = "VuPwsFCuX4hP6UX";

		//final String host = "smtp.gmail.com";

		// Get system properties
		Properties props = new Properties();

		// enable authentication the email is using googles smtp server which is free
		props.put("mail.smtp.auth", "true");

		// enable STARTTLS
		props.put("mail.smtp.starttls.enable", "true");

		// Setup mail server
		props.put("mail.smtp.host", "smtp.gmail.com");

		// TLS Port
		props.put("mail.smtp.port", "587");

		// creating Session instance referenced to
		// Authenticator object to pass in
		// Session.getInstance argument
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(username, password);
			}
		});

		try {

			// compose the message
			// javax.mail.internet.MimeMessage class is
			// mostly used for abstraction.
			Message message = new MimeMessage(session);
			String receipient = "gerardo.huerta.655@my.csun.edu";//example email, needs to be implemented to call current user's email address //still not complete

			// header field of the header.
			message.setFrom(new InternetAddress("naruto.uchih.sharingan@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receipient));

			message.setSubject("Thank You For Your Purchase");
			// creating first MimeBodyPart object
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1
					.setText("We are thankful for your purchase! :D" + System.lineSeparator() + "Thank you for shopping with us. Hope to see you soon!" + System.lineSeparator() + "Here is your receipt. Hava a nice day! UwU";

			// creating second MimeBodyPart object
			BodyPart messageBodyPart2 = new MimeBodyPart();
			String filename = "receipt.txt"; //This part is supposed to take a document and send it as an attachment in the email.
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);

			// creating MultiPart object
			Multipart multipartObject = new MimeMultipart();
			multipartObject.addBodyPart(messageBodyPart1);
			multipartObject.addBodyPart(messageBodyPart2);

			// set body of the email.
			message.setContent(multipartObject);
			Transport.send(message); // send Message

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}