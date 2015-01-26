/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newsletterHelpers;
import java.io.*;
import java.util.*;
/**
 *
 * @author GREG
 */
public class MessageProvider {
    



  private final String subject;
  private final String content;

  public MessageProvider(String filename) throws IOException {
    Iterator<String> lines = new FileCollection(filename).iterator();
    subject = lines.next();
    StringBuilder cb = new StringBuilder();
    while(lines.hasNext()) {
      cb.append(lines.next());
      cb.append('\n');
    }
    content = cb.toString();
  }

  public final String getSubject() {
    return subject;
  }

  public final String getContent() {
    return content;
  }
}
  
  

