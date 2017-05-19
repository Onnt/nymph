package cn.virde.nymph.db.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlDbCurd {

	public DBConnInfo info = null; 
	public SqlDbCurd(DBConnInfo info){
		this.info = info ;
	}

	public Connection getConn() throws ClassNotFoundException, SQLException{
		Connection conn = null;
		Class.forName(info.getDRIVER());
		conn = DriverManager.getConnection(info.getURL(), info.getUser(), info.getPass());
		return conn;
	}

	public void closeConn(Connection conn) throws SQLException{
		if (conn != null) {
			conn.close();
		}
	}
	public void closeSta(Statement sta) throws SQLException{
		if (sta != null) {
			sta.close();
		}
	}
	public void closeRs(ResultSet rs) throws SQLException{
		if (rs != null) {
			rs.close();
		}
	}
	public void closePpsta(PreparedStatement ppsta) throws SQLException{
		if(ppsta != null){
			ppsta.close();
		}
	}
}
