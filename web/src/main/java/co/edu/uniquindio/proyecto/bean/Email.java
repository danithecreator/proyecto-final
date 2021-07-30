package co.edu.uniquindio.proyecto.bean;

import lombok.Getter;
import lombok.Setter;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.Serializable;
import java.util.Properties;

public class Email implements Serializable {

    @Getter
    @Setter
    private static String correoPassword;


    public static void sendEmailPassword(String usuario, String subject, String to, String from) {

        //Variable for gmail
        String host = "smtp.gmail.com";

        //get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);

        //setting important information to properties object

        //host set
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        //Step 1: to get the session object..
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("unilocal2021@gmail.com", "AngyDaniel2021");
            }


        });

        session.setDebug(true);

        //Step 2 : compose the message [text,multi media]
        MimeMessage m = new MimeMessage(session);

        try {

            //from email
            m.setFrom(from);

            //adding recipient to message
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            //adding subject to message
            m.setSubject(subject);

            correoPassword = correoPaswordUsuario(usuario);

            //adding text to message
            m.setContent(correoPassword, "text/html");

            //send

            //Step 3 : send the message using Transport class
            Transport.send(m);

            System.out.println("Sent success...................");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String correoPaswordUsuario(String usuario) {
        return "<!DOCTYPE html>\n" + "<html lang=\"en\">\n" + "<head>\n" + "    <meta charset=\"UTF-8\">\n" + "    <title>Email</title>\n" + "</head>\n" + "<body>\n" + "<h1>\n" + "    " + "<strong>Unilocal</strong>\n" + "</h1>\n" + "\n" + "<h2>\n" + "    Hola, <strong>" + usuario + "!</strong>\n" + "</h2>\n" + "<div>\n" + "    <p>Has olvidado tu contraseña. <br>No te " + "preocupes puedes restablecer tu contraseña<br>\n" + "        ingresando la contraseña temporal que esta mas abajo la proxima vez que inicies sesion<br>\n" + "        recuerda cambiarla en la pestaña Mi perfil</p>\n" + "\n" + "    <p>Contraseña temporal: 123456789</p>\n" + "</div>\n" + "</body>\n" + "</html>";
    }


}
