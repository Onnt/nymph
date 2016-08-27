package cn.blacard.dbopera.para;

import java.util.logging.Logger;

import cn.blacard.dbopera.constant.DBStyle;

public class DBConnectPara {
	
	private Logger log = Logger.getLogger(DBConnectPara.class.getName());
	
	private String style;
	private String ip;
	private String dbName;
	private String user;
	private String pass;
	
	private String DRIVER;
	private String URL;
	
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		
		this.ip = ip;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDRIVER() {
		initPara();
		return DRIVER;
	}
	public void setDRIVER(String dRIVER) {
		DRIVER = dRIVER;
	}
	public String getURL() {
		initPara();
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public DBConnectPara() {
		super();
	}
	
	
	public DBConnectPara(String style, String ip, String dbName, String user, String pass) {
		super();
		this.style = style;
		this.ip = ip;
		this.dbName = dbName;
		this.user = user;
		this.pass = pass;
	}
	private void initPara(){
		switch(style){
		case DBStyle.SQLSERVER :
			//端口
			DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			URL = "jdbc:sqlserver://"+getDealIP(ip,1433)+";DataBaseName="+dbName;
			break;
		case DBStyle.MYSQL:
			DRIVER = "com.mysql.jdbc.Driver";
			URL = "jdbc:mysql://"+getDealIP(ip,3306)+"/"+dbName;
			break;
		case DBStyle.ORACLE:
			DRIVER = "";
			URL = "";
			break;
		default	: log.info("处理 数据库链接参数时出现异常");
		}
	}
	
	private String getDealIP(String ip,int defaultPort){
		return ip.contains(":")?ip:ip+":"+defaultPort;
	}
}
