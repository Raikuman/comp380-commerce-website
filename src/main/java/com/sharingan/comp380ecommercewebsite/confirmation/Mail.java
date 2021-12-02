package com.sharingan.comp380ecommercewebsite.confirmation;

import com.sharingan.comp380ecommercewebsite.config.ConfigHandler;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;


/*
 * This class is used to send a “Thank You” email to a respective client after they had made a purchase.
 * The class uses a SMTP server provided by google using a gmail account.
 * The email used was created for this project specifically and contains its password (Careful X-X)
 *
 * @author Gerardo Huerta
 * @since 2021-20-11
 */
public class Mail{

	/*
	 * This method is used to set up an email, attach and create all of its components and send email to respective user
     * @param products
     */

	public static void sendEmail() {

		//Email that will be used for authentication
		final String username = ConfigHandler.loadConfigSetting("email");

		//int Item1 = products.getPrice();
		//password for the email being used to authenticate
		final String password = ConfigHandler.loadConfigSetting("password");

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
		props.put("mail.smtp.port", ConfigHandler.loadConfigSetting("tlsport"));

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
			String recipient= ConfigHandler.loadConfigSetting("sendmail");;//example email, needs to be
			// implemented to call current user's email address //still not complete

			// header field of the header.
			assert username != null;
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));

			message.setSubject("Thank You For Your Purchase");
			// creating first MimeBodyPart object
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1
					.setText("We are thankful for your purchase." + System.lineSeparator() + "Hope to see you soon! :D" + System.lineSeparator() +
							"Below is receipt. Have a nice day! UwU" + System.lineSeparator());

			// creating second MimeBodyPart object
			BodyPart messageBodyPart2 = new MimeBodyPart();
			String filename = "receipt"; //This part is supposed to take a document and send it as an attachment in the email.
			DataSource source = new FileDataSource(filename);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName(filename);

			//ending part of email structure
			BodyPart messageBodyPart3 = new MimeBodyPart();
			messageBodyPart3.setText(System.lineSeparator() + "For customer support contact us via email:" + System.lineSeparator() +
					"naruto.uchih.sharingan@gmail.com." + System.lineSeparator() + "Goodbye. ༼ つ ◕_◕ ༽つ");

			// creating MultiPart object
			Multipart multipartObject = new MimeMultipart();
			multipartObject.addBodyPart(messageBodyPart1);
			multipartObject.addBodyPart(messageBodyPart2);
			multipartObject.addBodyPart(messageBodyPart3);

			// set body of the email.
			message.setContent(multipartObject);
			Transport.send(message); // send Message

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}