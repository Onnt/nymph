package cn.blacard.dbopera.opera;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import cn.blacard.dbopera.connect.Connect;
import cn.blacard.dbopera.para.DBConnectPara;

public class OperaBase {

	protected Logger log = Logger.getLogger(Query.class.getName());
	
	protected ResultSet rs = null;
	protected Statement sta = null;
	protected Connection conn = null;
	
	protected void openConnect(){
		conn = Connect.getConn();
		try {
			sta = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void openConnect(DBConnectPara para){
		conn =new Connect().getConn(para);
		try {
			sta = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void closeConnect(){
		Connect.closeAll(rs, sta, conn);
	}
}
