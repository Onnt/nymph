package cn.virde.nymph.mail;

import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import com.sun.mail.util.MailSSLSocketFactory;

public class EmailClient {

	private EmailClientInfo clientInfo ;
	
	public EmailClient(String smtpHost,String password,String senderAddress,String senderName) {
		clientInfo = new EmailClientInfo();
		clientInfo.setSmtpHost(smtpHost);
		clientInfo.setPassword(password);
		clientInfo.setSenderAddress(senderAddress);
		clientInfo.setSenderName(senderName);
	}
	public EmailClient(EmailClientInfo info) {
		this.clientInfo = info ;
	}

	/**
	 * 
	 * @author Virde
	 * 2018年4月13日 下午3:55:28
	 * @param info 邮件信息
	 * @return 返回
	 * @throws Exception  异常
	 */
	public boolean send(MailInfo info) throws Exception {

        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", clientInfo.getSmtpHost());   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证

        props.put("mail.smtp.ssl.enable", "true");
        MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        props.put("mail.smtp.ssl.socketFactory", sf);
        
        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        session.setDebug(true);                                 // 设置为debug模式, 可以查看详细的发送 log

        // 3. 创建一封邮件
        MimeMessage message = createMimeMessage(session, info);

        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();

        // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
        // 
        //    PS_01: 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,
        //           仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误
        //           类型到对应邮件服务器的帮助网站上查看具体失败原因。
        //
        //    PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
        //           (1) 邮箱没有开启 SMTP 服务;
        //           (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
        //           (3) 邮箱服务器要求必须要使用 SSL 安全连接;
        //           (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
        //           (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
        //
        //    PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。
        transport.connect(clientInfo.getSenderAddress(), clientInfo.getPassword());

        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());

        // 7. 关闭连接
        transport.close();
		return true ;
	}

    /**
     * 创建一封只包含文本的简单邮件
     *
     * @param session 和服务器交互的会话
     * @param sendMail 发件人邮箱
     * @param receiveMail 收件人邮箱
     * @return 返回
     * @throws Exception 异常
     */
//    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail) throws Exception {
      public MimeMessage createMimeMessage(Session session, MailInfo info) throws Exception {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(clientInfo.getSenderAddress(), clientInfo.getSenderName(), "UTF-8"));

        // 3. To: 收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(info.getRecipientAddress(), info.getRecipientName(), "UTF-8"));

        // 4. Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject(info.getSubject(), "UTF-8");

        // 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent(info.getContent(), "text/html;charset=UTF-8");

        // 6. 设置发件时间
        message.setSentDate(new Date());
        
        if(info.getFile()!=null) {
            Multipart multipart = new MimeMultipart();  
            BodyPart part = new MimeBodyPart();  
            // 根据文件名获取数据源  
            DataSource dataSource = new FileDataSource("test.xls");  
            DataHandler dataHandler = new DataHandler(dataSource);  
            // 得到附件本身并至入BodyPart  
            part.setDataHandler(dataHandler);  
            // 得到文件名同样至入BodyPart  
            part.setFileName(MimeUtility.encodeText(dataSource.getName()));  
            multipart.addBodyPart(part);  
            
            message.setContent(multipart);
        }
        
        // 7. 保存设置
        message.saveChanges();
        
        return message;
        
    }
	
}
