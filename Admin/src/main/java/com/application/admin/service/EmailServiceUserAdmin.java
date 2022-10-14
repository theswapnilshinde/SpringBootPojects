package com.application.admin.service;




import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceUserAdmin {


	protected String password;

	public boolean sendEmailUser(String to )
	{

		String subject ="Account is Created on  Our  Application";
		String message ="   ----Welcome -----"
				+ " thank you for resitaration is  Successfull... ";
		String  form = "swapniljava8@gmail.com";
		String host = "smtp.gmail.com";
		
		
		boolean flag = false;

		Properties properties = System.getProperties();
		System.err.println("Properties --->>"+ properties);


		// set host iformation
		properties.put("mail.smtp.host", host);
	//	properties.put("mail.smtp.host", "465");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");


        Session  session   =Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {

			//	return  new PasswordAuthentication("shindeswapnil3097@gmail.com","Swapnil@12");//"nkvucaffekwgcftw");
				
				return  new PasswordAuthentication("swapniljava8@gmail.com","nkvucaffekwgcftw");//"nkvucaffekwgcftw");
				
				
				//userName:"swapniljava8@gmail.com",password:"Swapnil@12") ;
			}


		});

		session.setDebug(true);

		MimeMessage m = new  MimeMessage(session);

		try {
			// from mail
			m.setFrom(form);

			//adding reciption to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);
			m.setText(message);


			Transport.send(m);
			flag= true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}


}
