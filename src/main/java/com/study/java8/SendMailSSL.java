package com.study.java8;

import java.io.UnsupportedEncodingException;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
/**
 * @author 华志宾
 * @date 2019-07-03
 */
public class SendMailSSL {

    private static final String FROM_MAIL_SMTP = "smtp.qiye.163.com";
    private static final String FROM_MAIL_NAME = "huazhibin@worktrans.cn";
    private static final String FROM_MAIL_PASS = "Woqu0102";


    /**
     * 发送邮件(灵活度高，通用版)
     * @param to 收件人, 多个Email以英文逗号分隔
     * @param cc 抄送, 多个Email以英文逗号分隔
     * @param subject 主题
     * @param content 内容
     * @param fileList 附件列表
     * @return
     */
    public static boolean sendMail(String to, String cc, String subject, String content, String[] fileList){
        try {
            Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
            final Properties p = System.getProperties() ;
            p.setProperty("mail.smtp.host", FROM_MAIL_SMTP);
            p.setProperty("mail.smtp.auth", "true");
            p.setProperty("mail.smtp.user", FROM_MAIL_NAME);
            p.setProperty("mail.smtp.pass", FROM_MAIL_PASS);

            p.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
            p.setProperty("mail.smtp.socketFactory.fallback", "false");
            //邮箱发送服务器端口,这里设置为465端口
            p.setProperty("mail.smtp.port", "465");
            p.setProperty("mail.smtp.socketFactory.port", "465");

            // 根据邮件会话属性和密码验证器构造一个发送邮件的session
            Session session = Session.getInstance(p, new Authenticator(){
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(p.getProperty("mail.smtp.user"),p.getProperty("mail.smtp.pass"));
                }
            });
            session.setDebug(true);
            Message message = new MimeMessage(session);
            //消息发送的主题
            message.setSubject(subject);
            //接受消息的人
            message.setReplyTo(InternetAddress.parse(FROM_MAIL_NAME));
            //消息的发送者
            message.setFrom(new InternetAddress(p.getProperty("mail.smtp.user"),"河马评测"));
            // 创建邮件的接收者地址，并设置到邮件消息中
            String[] split = to.split(",");
            InternetAddress []tos = new InternetAddress[split.length];
            for (int i = 0; i < split.length; i++) {
                tos[i]=new InternetAddress(split[i]);
            }
            // 设置抄送人
            if (cc != null && cc.length() > 0) {
                message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
            }
            message.setRecipients(Message.RecipientType.TO, tos);
            // 消息发送的时间
            message.setSentDate(new Date());
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(content, "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容
            message.setContent(mainPart);
            // 设置附件
            if (fileList != null && fileList.length > 0) {
                for (int i = 0; i < fileList.length; i++) {
                    html = new MimeBodyPart();
                    FileDataSource fds = new FileDataSource(fileList[i]);
                    html.setDataHandler(new DataHandler(fds));
                    html.setFileName(MimeUtility.encodeText(fds.getName(), "UTF-8", "B"));
                    mainPart.addBodyPart(html);
                }
            }
            message.setContent(mainPart);
            message.saveChanges();
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 测试Mian方法
     *
     * @param args
     */
    public static void main(String[] args) {
        String content = "<html><head><style type='text/css'>p{padding-left:50px;font-family:'楷体';font-size:20px;}table{padding-left:50px;border:0;font-family:'楷体';font-size:30px;}</style></head><body>您好：<br/><p>申请编号为"+"测试测试内容"+"的经销商对订单发起放弃签约，具体信息如下：</p><table border='1'  cellpadding='10' cellspacing='0'> <tr align='center'><td width='200'>经销商</td> <td width='300'>"+"无需回复"+"</td> </tr> <tr align='center'><td>申请编号</td><td>"+"测试测试内容"+"</td></tr> <tr align='center'><td>取消时间</td><td>"+"无需回复"+"</td></tr> <tr align='center'><td>加装GPS数量</td><td>"+"测试测试内容"+"</td></tr> <tr align='center'><td>GPS IMEI号</td><td>"+"测试测试内容"+"</td></tr><tr align='center'><td>店铺地址</td><td>"+"测试测试内容"+"</td></tr> <tr align='center'><td>店铺联系人姓名</td><td>"+"测试测试内容"+"</td></tr> <tr align='center'><td>店铺联系人电话</td><td>"+"测试测试内容"+"</td></tr> </table><p>请及时联系GPS相关人员，安排上门拆装，谢谢！</p>------------------------------------------------------------------------------</body></html>";
        content = "<html><head><style type='text/css'>p{padding-left:50px;font-family:'楷体';font-size:20px;}table{padding-left:50px;border:0;font-family:'楷体';font-size:30px;}</style></head><body>Hey：<br/><p>我们发现您的用户评测报告已经出来了，赶紧来看看：</p><p>用户：吕坤     手机号：17697182873    评测进度：3/9 (评测越多，报告越丰富哦)：</p><p>河马小提示：点击链接查看报告</p><p>个人信用报告：<a href='https://axhub.im/pro/dbf03b6626db7bde/' target='_blank'>https://axhub.im/pro/dbf03b6626db7bde/</a></p><p>联系人信息：<a href='https://axhub.im/pro/dbf03b6626db7bde/' target='_blank'>https://axhub.im/pro/dbf03b6626db7bde/</a></p></body></html>";
        System.out.println(content);
//        String[] fileList = new String[1];
       // fileList[0] = "d:/pac.txt";
        sendMail("1109233317@qq.com", "huazhibin@worktrans.cn", "测试测试", content,null);
    }
}
