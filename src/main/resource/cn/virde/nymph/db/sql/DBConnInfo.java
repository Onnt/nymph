package cn.virde.nymph.db.sql;

import cn.virde.nymph.enums.common.DBStyle;

/**
 * <b>数据库连接参数实体</b><br/>
 * 构造器参数列表：<br/>
 * String style, String ip, String dbName, String user, String pass<br/>
 * <b>style</b>：数据库类型，用DBStyle<br/>
 * <b>ip</b>：数据库IP地址，非默认端口需要在IP后面添加端口。
 * DBStyle.MYSQL默认3306，DBStyle.SQLSERVER 默认为1433<br/>
 * <b>dbName</b>：数据库 库名<br/>
 * <b>user</b>：数据库登陆账号<br/>
 * <b>pass</b>：数据库登陆密码<br/>
 * @author Blacard
 * @changeTime 2016年8月30日15:48:59
 * @since 2016年8月30日15:48:48
 */
public class DBConnInfo {
	
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
	public DBConnInfo setStyle(DBStyle style) {
		this.style = style;
		return this;
	}
	public String getIp() {
		return ip;
	}
	public DBConnInfo setIp(String ip) {
		this.ip = ip;
		return this;
	}
	public String getDbName() {
		return dbName;
	}
	public DBConnInfo setDbName(String dbName) {
		this.dbName = dbName;
		return this;
	}
	public String getUser() {
		return user;
	}
	public DBConnInfo setUser(String user) {
		this.user = user;
		return this;
	}
	public String getPass() {
		return pass;
	}
	public DBConnInfo setPass(String pass) {
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
	public DBConnInfo() {
		super();
	}
	
	
	public DBConnInfo(DBStyle style, String ip, String dbName, String user, String pass) {
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
			URL = "mongodb://"+user+":"+pass+"@"+getDealIP(ip,27017)+"/"+dbName;
			break;
		default	: System.out.println("处理 数据库链接参数时出现异常");
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
