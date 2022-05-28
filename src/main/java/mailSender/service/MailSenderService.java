package mailSender.service;

import mailSender.model.MailInfo;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSenderService {

    private final MailInfo setting;

    private final Properties properties = System.getProperties();

    private Session session;

    public MailSenderService(MailInfo setting) {
        this.setting = setting;
        setProperties();
        createSession();
    }

    public void setProperties() {
        properties.put("mail.smtp.host", setting.getHost());
        properties.put("mail.smtp.port", setting.getServerPort());
        properties.put("mail.smtp.auth", "true");

        switch (setting.getType()) {
            case TLS:
                properties.put("mail.smtp.starttls.enable", "true");
                break;
            case SSL:
                properties.put("mail.smtp.ssl.enable", "true");
                break;
            case PLAIN:

        }
    }

    private void createSession() {
        //Get the session object
        session = Session.getInstance(properties,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(setting.getUsername(),
                                setting.getPassword());
                    }
                });
    }

    public boolean send(String to, String subject, String body) {

        //compose the message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(setting.getServerAddress());
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(body);

            // Send message
            Transport.send(message);
            System.out.println("message sent successfully...");
            return true;

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

        return false;
    }
}
