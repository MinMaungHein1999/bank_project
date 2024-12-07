package mailer;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    private String smtpHost;
    private String smtpPort;
    private String username;
    private String password;
    private Properties props;

    public EmailSender(){

        this.smtpHost = "smtp.gmail.com";
        this.smtpPort = "587";
        this.username = "minmaunghein1999@gmail.com";
        this.password = "wpxraqytddxjrohl";

        props = new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable", true);
        props.put("mail.smtp.starttls.required", true);
        props.put("mail.smtp.host", this.smtpHost);
        props.put("mail.smtp.port", this.smtpPort);
        props.put("mail.smtp.ssl.protocols","TLSv1.2");
    }

    public void sentEmailAction(String subject, String body, String toEmail){
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(this.username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setContent(body, "text/html; charset=utf-8");
            Transport.send(message);
            System.out.println("Email sent successfully to "+ toEmail);
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }

}
