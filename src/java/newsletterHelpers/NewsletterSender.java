/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsletterHelpers;

/**
 *
 * @author GREG
 */
import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;




public class NewsletterSender {

  private static final String SMTP_SERVER =
      "smtp.gmail.com";
  private static final String USERNAME =
      "gregtmpkatsyst@gmail.com";
  private static final String PASSWORD = "qwerfdsazxcv";
  private static final String FROM =
      "Erpis Clinic <gregtmpkatsyst@gmail.com>";
  private static final String mailer = "TJSNMailer";

  private final Transport transport;
  private final Session session;
  private final MessageProvider provider;

  public NewsletterSender(MessageProvider provider)
      throws MessagingException {
    this.provider = provider;
    Properties props = System.getProperties();
    props.put("mail.smtp.host", SMTP_SERVER);
    props.put("mail.smtp.auth", "true");
    // Get a Session object
    session = Session.getInstance(props, null);
    transport = session.getTransport("smtp");
    transport.connect(SMTP_SERVER, USERNAME, PASSWORD);
  }    
  
  public void sendMessageTo(String to) throws MessagingException {
    Message msg = new MimeMessage(session);
    // set headers
    msg.setFrom(InternetAddress.parse(FROM, false)[0]);
    msg.setHeader("X-Mailer", mailer);
    msg.setSentDate(new Date());
    msg.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(to, false));

    // set title and body
    msg.setSubject(provider.getSubject());
    msg.setText(provider.getContent());

    // off goes the message...
    transport.sendMessage(msg, msg.getAllRecipients());
  }
    
}
