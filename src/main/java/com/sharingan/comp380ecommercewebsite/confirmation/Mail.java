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
 * The class uses an SMTP server provided by google using a gmail account.
 * An email was created specifically for this website.
 *
 * @author Gerardo Huerta
 * @since 2021-20-11
 */
public class Mail{

	/*
	 * The method below is used to set up an email by attaching and creating all of its components.
	 * This method needs the help of ConfigHandler to extract sensitive information like emails and passwords.
	 * Finally, an email is sent to respective user.
     */

	public void sendEmail(String abc) {
		// ConfigHandler extracts Customer/user email to be sent.
		String to = abc;

		// ConfigHandler extracts website's information.
		String from = ConfigHandler.loadConfigSetting("email");

		// Google's SMTP address used to send the email.
		String host = "smtp.gmail.com";

		// this information is used for authentication when accessing SMTP server.
		final String username = ConfigHandler.loadConfigSetting("email");
		final String password = ConfigHandler.loadConfigSetting("password");

		// setting up properties for proper use of the SMTP server
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.put("mail.smtp.port", ConfigHandler.loadConfigSetting("tlsport"));
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		// creating Session instance referenced to
		// an Authenticator object to pass in
		// Session.getInstance argument
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {

			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		// use of Try/Catch for error handling.
		try {
			// MESSAGE COMPOSITION
			// javax.mail.internet.MimeMessage class is
			// mostly used for abstraction.
			// MimeMessage object is created to form an email
			MimeMessage message = new MimeMessage(session);

			// MimeMessage header field
			assert from != null; //used to avoid a nullpointer exception.
			message.setFrom(new InternetAddress(from));
			assert to != null;
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Thank You For Your Purchase");

			// creating first MimeBodyPart object
			// contains first lines of the email / structure formatting.
			BodyPart messageBodyPart1 = new MimeBodyPart();
			messageBodyPart1                  //First lines of email / structure formatting.
					.setText("We are thankful for your purchase." + System.lineSeparator() + "Hope to see you soon! :D"
							+ System.lineSeparator() + "Below is your receipt. Have a nice day! UwU" + System.lineSeparator());

			// creating second MimeBodyPart object
			// contains an attachment -> purchase receipt
			BodyPart messageBodyPart2 = new MimeBodyPart();
			String filePath = "src/main/java/com/sharingan/comp380ecommercewebsite/confirmation/receipt.txt";
			DataSource source = new FileDataSource(filePath);
			messageBodyPart2.setDataHandler(new DataHandler(source));
			messageBodyPart2.setFileName("receipt");

			// creating third MimeBodyPart object
			// contains ending part of email structure
			BodyPart messageBodyPart3 = new MimeBodyPart();
			messageBodyPart3.setText(System.lineSeparator() + "For customer support contact us via email:" + System.lineSeparator() +
					"naruto.uchih.sharingan@gmail.com." + System.lineSeparator() + "Goodbye.");

			// creating MultiPart object
			// used to put all MimeBodyParts altogether
			Multipart multipartObject = new MimeMultipart();
			multipartObject.addBodyPart(messageBodyPart1);
			multipartObject.addBodyPart(messageBodyPart2);
			multipartObject.addBodyPart(messageBodyPart3);

			// MemeMessage body setup of the email
			// sets Multipart as the body.
			message.setContent(multipartObject);

			// where the magic happens
			// send Message
			Transport.send(message);

			// Confirmation for successful email delivery
			System.out.println("Done");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}