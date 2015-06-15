package bucketlist.controller;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 * Klasa służąca do wysyłania automatycznie maili Wykorzystywana jest biblioteka
 * Javamail
 *
 * @author lukasz
 */
public class BucketlistMail {

    private String from = "lukozar@gmail.com";  //when sending mail change this line
    private String host = "smtp.gmail.com";

    final String user = "lukozar@gmail.com";      //when sending mail change this line
    final String password = "password_to_write";  //when sending mail change this line

    /**
     * Kostruktor obiektu służącego do wysyłania maili
     *
     */
    public BucketlistMail() {
    }

    /**
     * Metoda wysyłająca maila o podanej treści, temacie do danego użytkownika
     *
     * @param to adresat wiadomości
     * @param email_message treść maila
     * @param topic temat maila
     *
     */
    public void sendMail(String to, String email_message, String topic) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user, password);
                    }
                });
    //session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(topic);
            message.setText(email_message);

            Transport transport = session.getTransport("smtps");
            transport.connect(host, 465, user, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException emailError) {
            emailError.printStackTrace();
        }

    }
}
