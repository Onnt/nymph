package cn.virde.nymph.db.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.virde.nymph.Nym;
import cn.virde.nymph.NymLog;

public class SqlDbCurd{
	
	private NymLog log = Nym.getLogger(this.getClass().getName());
	
	public DBConnInfo info = null; 
	public SqlDbCurd(DBConnInfo info){
		this.info = info ;
	}

	public Connection getConn() throws ClassNotFoundException, SQLException{
		Connection conn = null;
		try {
			Class.forName(info.getDRIVER());
		} catch (ClassNotFoundException e) {
			log.i("加载JDBC时出现异常。JDBC DRIVER:"+info.getDRIVER(), e);
			throw e;
		}
		try {
			conn = DriverManager.getConnection(info.getURL(), info.getUser(), info.getPass());
		} catch (SQLException e) {
			log.i("获取JDBC Connection时出现异常，", e);
			throw e ;
		}
		return conn;
	}

	public void closeConn(Connection conn){
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				log.i("conn 对象关闭时出现异常", e);
			}
		}
	}
	public void closeSta(Statement sta) {
		if (sta != null) {
			try {
				sta.close();
			} catch (SQLException e) {
				log.i("sta 对象关闭时出现异常",e);
			}
		}
	}
	public void closeRs(ResultSet rs){
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				log.i("rs 对象关闭时出现异常",e);
			}
		}
	}
	public void closePpsta(PreparedStatement ppsta){
		if(ppsta != null){
			try {
				ppsta.close();
			} catch (SQLException e) {
				log.i("ppsta 对象关闭时出现异常",e);
			}
		}
	}
}
