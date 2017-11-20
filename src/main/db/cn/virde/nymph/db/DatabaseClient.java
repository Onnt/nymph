package cn.virde.nymph.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.virde.nymph.db.exception.NymDBException;
import cn.virde.nymph.util.Log;

public abstract class DatabaseClient {

	protected Connection conn ;
	
	protected ResultSet rs ; 
	protected Statement sta ;
	protected PreparedStatement ppsta ;

	protected ConnInfo info ;
	
	protected void open() throws NymDBException{
		try {
			if(conn != null && !conn.isClosed()) return;
			Class.forName(info.getDRIVER());
			conn = DriverManager.getConnection(info.getURL(), info.getUser(), info.getPass());
		} catch (ClassNotFoundException e) {
			throw new NymDBException("加载JDBC时出现ClassNotFound异常。JDBC DRIVER:"+info.getDRIVER());
		} catch (SQLException e) {
			throw new NymDBException("加载JDBC时出现SqlException:"+e.getMessage()+"。JDBC DRIVER:"+info.getDRIVER());
		}
	}

	protected boolean close() {
		try {
			closeSta();
			closeRs();
			closePpsta();
			closeConn();
		} catch (SQLException e) {
			Log.error("数据库工具在关闭对象时遇到异常:", e.getMessage()+" , "+e.getSQLState());
			e.printStackTrace();
		}
		return true ;
	}

	private void closeSta() throws SQLException {
		if (sta != null) {
			sta.close();
			sta = null ;
		}
	}
	private void closeRs() throws SQLException{
		if (rs != null) {
			rs.close();
			rs = null ;
		}
	}
	private void closePpsta() throws SQLException{
		if(ppsta != null){
			ppsta.close();
			ppsta = null ;
		}
	}

	private void closeConn() throws SQLException{
		if(conn != null){
			conn.close();
			conn = null;
		}
	}
}
