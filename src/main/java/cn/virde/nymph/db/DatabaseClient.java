package cn.virde.nymph.db;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import cn.virde.nymph.db.exception.NymDBException;
import cn.virde.nymph.db.mysql.ConnPool;

/**
 * 
 * @author Virde
 * 2018年4月23日 下午3:59:20
 */
public abstract class DatabaseClient {

	protected Connection conn ;
	
	protected ResultSet rs ; 
	protected Statement sta ;
	protected PreparedStatement ppsta ;

	protected ConnInfo info ;
	
	// 是否使用链接池,多数据源场景下不能使用链接池
	protected boolean usePool = true ;

	protected void open() throws NymDBException{
		if(usePool) {
			openUsePool();
		}else {
			openUseJDBC();
		}
	}
	protected void openUsePool() throws NymDBException{
		try {
			if(conn != null && !conn.isClosed()) return;
			if(ConnPool.needInit()) {
				ConnPool.init(info);
			}
			conn = ConnPool.getConnection() ;
		} catch (SQLException e) {
			throw new NymDBException("加载JDBC时出现SqlException:"+e.getMessage()+"。JDBC DRIVER:"+info.getDRIVER());
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	protected void openUseJDBC() throws NymDBException{
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
