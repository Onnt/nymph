package cn.blacard.dbopera.para;

import java.util.logging.Logger;

import cn.blacard.dbopera.constant.DBStyle;

/**
 * 数据库连接参数实体
 * @author Blacard
 * @changeTime 2016年8月30日15:48:59
 * @since 2016年8月30日15:48:48
 */
public class DBConnectPara {
	
	private Logger log = Logger.getLogger(DBConnectPara.class.getName());
	
	//数据库类型
	private String style;
	//数据库IP
	private String ip;
	//数据库 库名
	private String dbName;
	//数据库登陆账号
	private String user;
	//数据库登陆密码
	private String pass;

	//数据库驱动，会根据上面的属性自动生成
	private String DRIVER;
	//数据库连接URL，会根据上面的属性自动生成
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
	/**
	 * 根据已有的参数
	 * 自动生成DRIVE 和 URL
	 */
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
	
	/**
	 * 如果传入IP时加了端口，
	 * 就用传入的端口。
	 * 如果没有传入端口，就用默认的端口连接
	 * @param ip
	 * @param defaultPort
	 * @return
	 */
	private String getDealIP(String ip,int defaultPort){
		return ip.contains(":")?ip:ip+":"+defaultPort;
	}
}
