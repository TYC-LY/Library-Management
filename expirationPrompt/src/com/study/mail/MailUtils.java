package com.study.mail;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailUtils {

    public static void sendMail(String email,String subject, String emailMsg)
            throws AddressException, MessagingException {
        // 1.创建一个程序与邮件服务器会话对象 Session
        
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "localhost");//发送邮件的服务器地址
        props.setProperty("mail.smtp.auth", "true");// 指定验证为true
        props.setProperty("mail.host", "smtp.qq.com");
        props.put("mail.smtp.ssl.enable", "true");


        // 创建验证器
        Authenticator auth = new Authenticator() {
         
        };

        Session session = Session.getInstance(props, auth);

        // 2.创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);

        message.setSubject(subject);//设置邮件的主题
        // message.setText("这是一封激活邮件，请<a href='#'>点击</a>");
        //设置邮件的内容
        message.setContent(emailMsg, "text/html;charset=utf-8");
        message.setFrom(new InternetAddress("1327928807@qq.com")); // 设置发送者
        Transport transport = session.getTransport();
        transport.connect("smtp.qq.com","1327928807@qq.com", "oubijglgbaeegaja");
        transport.sendMessage(message, new Address[] { new InternetAddress(email) }); // 设置发送方式与接收者
        transport.close();
        System.out.println("发送成功");
    }
}