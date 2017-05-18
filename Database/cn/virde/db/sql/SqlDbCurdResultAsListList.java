package cn.virde.db.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlDbCurdResultAsListList extends SqlDbCurd{
	
	private Connection conn;
	private ResultSet rs ;
	private Statement sta ;
	
	public SqlDbCurdResultAsListList(SqlDbConnectInfo info) {
		super(info);
	}
	
	public List<List<String>> query(String querySql) throws SQLException, ClassNotFoundException{
		List<List<String>> list_list = new ArrayList<List<String>>();
		open();
		rs = sta.executeQuery(querySql);
		// 获取一共有多少列
		int colCount = rs.getMetaData().getColumnCount();//得到sql语句到底查询了多少个字段
		while(rs.next()){
			list_list.add(getOneRowData(rs,colCount));
		}
		close();
		return list_list;
	}
	private List<String> getOneRowData(ResultSet rs,int colCount) throws SQLException{
		List<String> list = new ArrayList<String>();
		for(int i = 1 ; i <= colCount ; i++){
			list.add(rs.getString(i));
		}
		return list;
	}
	
	private void open() throws ClassNotFoundException, SQLException{
		conn = getConn();
		sta = conn.createStatement();
	}
	private void close() throws SQLException{
		closeConn(conn); conn = null ;
		closeSta(sta); sta = null;
		closeRs(rs); rs = null;
	}
}
