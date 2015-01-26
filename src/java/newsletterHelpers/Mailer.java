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

import javax.mail.MessagingException;
import java.io.IOException;

public class Mailer {
  private final FileCollection to;
  private final MessageProvider provider;
  public Mailer(String addressFile, String messageFile)
      throws IOException {
    to = new FileCollection(addressFile);
    provider = new MessageProvider(messageFile);
  }

  public void sendMessages() throws MessagingException {
    NewsletterSender sender = new NewsletterSender(provider);
    for (String email : to) {
      sender.sendMessageTo(email);
      System.out.println("Mail sent to " + email);
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println(
          "Usage: java Mailer address_file message_file");
      System.exit(1);
    }

    long time = -System.currentTimeMillis();
    Mailer sender = new Mailer(args[0], args[1]);
    sender.sendMessages();
    time += System.currentTimeMillis();
    System.out.println(time + "ms");
    System.out.println("Finished");
  }
}
  
