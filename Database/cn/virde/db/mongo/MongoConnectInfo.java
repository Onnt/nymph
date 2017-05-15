package cn.virde.db.mongo;

import com.mongodb.MongoClientURI;


public class MongoConnectInfo {

	private String ip;
	private int port;
	private String user;
	private String pass;
	private String dbName;
	public String getIp() {
		return ip;
	}
	public MongoConnectInfo setIp(String ip) {
		this.ip = ip;
		return this;
	}
	public int getPort() {
		return port;
	}
	public MongoConnectInfo setPort(int port) {
		this.port = port;
		return this;
	}
	public String getUser() {
		return user;
	}
	public MongoConnectInfo setUser(String user) {
		this.user = user;
		return this;
	}
	public String getPass() {
		return pass;
	}
	public MongoConnectInfo setPass(String pass) {
		this.pass = pass;
		return this;
	}
	public String getDbName() {
		return dbName;
	}
	public MongoConnectInfo setDbName(String dbName) {
		this.dbName = dbName;
		return this;
	}
	
	public String getURI(){
		return "mongodb://"+user+":"+pass+"@"+ip+":"+port+"/"+dbName;
	}
	
	public MongoClientURI getMongoClientURI(){
		return new MongoClientURI(getURI());
	}
}
