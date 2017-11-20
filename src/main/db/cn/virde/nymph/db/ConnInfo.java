package cn.virde.nymph.db;

import cn.virde.nymph.enums.common.DBStyle;

public class ConnInfo {

	//数据库类型
	private DBStyle style;
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
	
	public DBStyle getStyle() {
		return style;
	}
	public ConnInfo setStyle(DBStyle style) {
		this.style = style;
		return this;
	}
	public String getIp() {
		return ip;
	}
	public ConnInfo setIp(String ip) {
		this.ip = ip;
		return this;
	}
	public String getDbName() {
		return dbName;
	}
	public ConnInfo setDbName(String dbName) {
		this.dbName = dbName;
		return this;
	}
	public String getUser() {
		return user;
	}
	public ConnInfo setUser(String user) {
		this.user = user;
		return this;
	}
	public String getPass() {
		return pass;
	}
	public ConnInfo setPass(String pass) {
		this.pass = pass;
		return this;
	}
	public String getDRIVER() {
		initPara();
		return DRIVER;
	}
	public String getURL() {
		initPara();
		return URL;
	}
	public ConnInfo() {
		super();
	}
	
	
	public ConnInfo(DBStyle style, String ip, String dbName, String user, String pass) {
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
		case SQLSERVER:
			//端口
			DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			URL = "jdbc:sqlserver://"+getDealIP(ip,1433)+";DataBaseName="+dbName;
			break;
		case MYSQL:
			DRIVER = "com.mysql.jdbc.Driver";
			URL = "jdbc:mysql://"+getDealIP(ip,3306)+"/"+dbName+"?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			break;
		case ORACLE:
			DRIVER = "";
			URL = "";
			break;
		case MONGO:
			DRIVER = "";
			URL = createMongoUrl();
			break;
		default	: System.out.println("处理 数据库链接参数时出现异常");
		}
	}
	
	private String createMongoUrl() {
		StringBuffer sb = new StringBuffer();
		sb.append("mongodb://");
		if(user != null && pass != null) {
			sb.append(user+":"+pass+"@");
		}
		sb.append(getDealIP(ip,27017));
		if(dbName!=null) {
			sb.append("/"+dbName);
		}
		return sb.toString();
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
