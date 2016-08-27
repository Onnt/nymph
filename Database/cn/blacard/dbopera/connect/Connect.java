package cn.blacard.dbopera.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

import cn.blacard.dbopera.para.DBConnectPara;

/**
 * 必须先设置数据库连接参数，然后才能获取到数据库连接
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
	// 获取到数据库连接
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
	

	// 获取到数据库连接
	public Connection getConn(DBConnectPara para) {
		paras = para;
		Connection conn = null;
		try {
			Class.forName(paras.getDRIVER());
			conn = DriverManager.getConnection(paras.getURL(), paras.getUser(), paras.getPass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 关闭连接
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
