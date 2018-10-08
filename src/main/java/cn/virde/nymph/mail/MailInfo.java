package cn.virde.nymph.mail;

public class MailInfo {
	// 收件人邮箱地址
	private String recipientAddress ;
	// 收件人名字
	private String recipientName ;

	//  Subject: 邮件主题
	private String subject ;
	// 邮件正文
	private String content ;
	// 附件地址
	private String file ;
	
	public String getRecipientAddress() {
		return recipientAddress;
	}
	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	
}
