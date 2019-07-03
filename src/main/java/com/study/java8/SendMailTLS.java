package com.study.java8;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

    public static void main(String[] args) {

        final String username = "huazhibin@worktrans.cn";
        final String password = "Woqu0102";

        //收件箱
        final String to = "1109233317@qq.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        //不做服务器证书校验
        props.put("mail.smtp.ssl.checkserveridentity", "false");

        //添加信任的服务器地址，多个地址之间用空格分开
        props.put("mail.smtp.ssl.trust", "smtp.qiye.163.com");
        props.put("mail.smtp.host", "smtp.qiye.163.com");
        props.put("mail.smtp.port", "994");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            message.setSubject("Email Testing Subject");
            message.setText("hello world！");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}