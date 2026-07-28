import jakarta.mail.*;

import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;



import java.util.Properties;

public class Operation {
    public static void sendMail(String to,String subject,String message) throws MessagingException {

        final String from = "palankushn@gmail.com";
        final String password = "cnyn zhfi vdnr yosr";

        Properties props = new Properties();
        //Set SMTP server properties.
        props.put("mail.smtp.auth","true");//This means the mail server requires a username and the password before sending the mail.
        //TLS --command for the SMTPs [added for secure connection] transport layer security
        props.put("mail.smtp.starttls.enable","true");//StartTTLS. Upgrade the connection from plaintext to an encrypted connection.

        props.put("mail.smtp.host","smtp.gmail.com");

        props.put("mail.smtp.port","587");


        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });
        Message messages = new MimeMessage(session);//Multi-Purpose Internet Mail Sender

        messages.setFrom(new InternetAddress(from));
        messages.setRecipients(
                Message.RecipientType.TO,InternetAddress.parse(to)//Converts String to Internet Address
        );
        messages.setSubject(subject);
        messages.setText(message);

        Transport.send(messages);

        System.out.println("Email sent successfully");
    }

}
