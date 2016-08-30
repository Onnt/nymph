package cn.blacard.dbopera.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import cn.blacard.dbopera.para.DBConnectPara;

/**
 * 此类主要是为了获取到数据库 Connection 的链接
 * 必须先设置链接参数。
 * 通过 setConnPara(DBConnectPara) 设置连接参数
 * 程序里只需设置一次即可全局使用，然后用getConn() 即可获取Connection
 * 
 * 或者 每次获取Connection时传入参数，getConn(DBConnectPara)
 * @author Blacard
 *
 */
public class Connect {
	
	private static Logger log = Logger.getLogger(Connect.class.getName());
	
	//数据库连接参数
	private static DBConnectPara paras;
	
	public static void setConnPara(DBConnectPara para){
		paras = para;
	}
	/**
	 * 获取数据库连接Connection
	 * 此方法调用之前
	 * 请确认设置了链接参数
	 * 
	 * 	通过调用setConnPara(DBConnectPara)设置连接参数
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(paras.getDRIVER());
			conn = DriverManager.getConnection(paras.getURL(), paras.getUser(), paras.getPass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	/**
	 * 获取数据库连接Connection
	 * 
	 * 此方法调用时需要传入连接参数
	 * @param para
	 * @return
	 */
	public Connection getConn(DBConnectPara para) {
		this.paras = para;
		Connection conn = null;
		try {
			Class.forName(paras.getDRIVER());
			conn = DriverManager.getConnection(para.getURL(), paras.getUser(), paras.getPass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭连接
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
