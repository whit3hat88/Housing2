package com.Housing2.utility;

import com.sun.mail.smtp.SMTPMessage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.util.Properties;

// TODO: Auto-generated Javadoc

/**
 * The Class SendEMail.
 *
 * @author MWI Wohungsb�rse 2014
 * @version 1.0
 * @see javax.mail.*
 */
public class SendEMail {

    /**
     * Properties.
     */
    static Properties properties = new Properties();

    //Methode wird nur zum Testen verwendet!!!

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String args[]) {
        String to = "wohnungsboerse_dh@web.de";
        String from = "wohnungsboerse_dh@web.de";
        String subject = "Test";
        String text = "123";
        String cc = "julia.agricola@web.de";
        sendCC(to, from, cc, subject, text);
    }

    /**
     * Sends an E-Mail.
     *
     * @param to      String, who recives the e-mail?
     * @param from    String, who sends the e-mail?
     * @param subject String, subject of the e-mail
     * @param text    String, text of the e-mail
     * @see javax.mail.*
     * @see com.sun.mail.smtp.SMTPMessage
     */
    public static void send(String to, String from, String subject, String text) {

        // Properties setzen
        properties.put("mail.smtp.host", "smtp.web.de");// SMTP-Server von web.de
        properties.put("mail.smtp.auth", "true");// Authentifikation erforderlich
        properties.put("mail.smtp.port", "587");// Port des SMTP-Servers
        properties.put("mail.smtp.starttls.enable", "true");// SSLv3/TLSv1

        // Authentifizierung
        Authenticator auth = new javax.mail.Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("wohnungsboerse_dh@web.de", "wohnungsboerse");// Unsere E-Mail-Adresse und unser Passwort
            }
        };

        // Session erstellen mit den oben gesetzten Properties und der Authentifikation
        Session session = Session.getDefaultInstance(properties, auth);

        // neue Message erzeugen
        SMTPMessage message = (SMTPMessage) new SMTPMessage(session);
        try {
            message.setEnvelopeFrom("wohnungsboerse_dh@web.de");// tats�chlicher Absender (E-Mail wird von uns an uns selbst geschickt, unter dem Namen bzw. der E-Mail-Adresse des Nutzers)
            message.setFrom(new InternetAddress(from));// E-Mail-Adresse des Benutzers
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));// E-Mail-Adresse des Empf�ngers
            message.setSubject(subject);// Betreff
            message.setContent(text, "text/html");// Text der E-Mail (mit html Code f�r den Style)

            // E-Mail senden
            Transport.send(message);

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    /**
     * Send cc.
     *
     * @param to      the to
     * @param from    the from
     * @param cc      the cc
     * @param subject the subject
     * @param text    the text
     */
    public static void sendCC(String to, String from, String cc, String subject, String text) {

        // Properties setzen
        properties.put("mail.smtp.host", "smtp.web.de");// SMTP-Server von web.de
        properties.put("mail.smtp.auth", "true");// Authentifikation erforderlich
        properties.put("mail.smtp.port", "587");// Port des SMTP-Servers
        properties.put("mail.smtp.starttls.enable", "true");// SSLv3/TLSv1

        // Authentifizierung
        Authenticator auth = new javax.mail.Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("wohnungsboerse_dh@web.de", "wohnungsboerse");// Unsere E-Mail-Adresse und unser Passwort
            }
        };

        // Session erstellen mit den oben gesetzten Properties und der Authentifikation
        Session session = Session.getDefaultInstance(properties, auth);

        // neue Message erzeugen
        SMTPMessage message = (SMTPMessage) new SMTPMessage(session);
        try {
            message.setEnvelopeFrom("wohnungsboerse_dh@web.de");// tats�chlicher Absender (E-Mail wird von uns an uns selbst geschickt, unter dem Namen bzw. der E-Mail-Adresse des Nutzers)
            message.setFrom(new InternetAddress(from));// E-Mail-Adresse des Benutzers
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));// E-Mail-Adresse des Empf�ngers
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
            message.setSubject(subject);// Betreff
            message.setContent(text, "text/html");// Text der E-Mail (mit html Code f�r den Style)

            // E-Mail senden
            Transport.send(message);

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
