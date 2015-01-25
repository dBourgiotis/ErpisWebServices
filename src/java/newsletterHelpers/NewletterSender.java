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




public class NewletterSender {

  private static final String SMTP_SERVER =
      "smtp.javaspecialists.eu";
  private static final String USERNAME =
      "heinz@javaspecialists.eu";
  private static final String PASSWORD = "some_password";
  private static final String FROM =
      "Dr Heinz M. Kabutz <heinz@javaspecialists.eu>";
  private static final String mailer = "TJSNMailer";

  private final Transport transport;
  private final Session session;
  private final MessageProvider provider;

  public NewletterSender(MessageProvider provider)
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
    
}
