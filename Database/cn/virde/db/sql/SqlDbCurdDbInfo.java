package cn.virde.db.sql;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SqlDbCurdDbInfo extends SqlDbCurd{

	
	private Connection conn ;
	private ResultSet rs ; 
	
	public SqlDbCurdDbInfo(SqlDbConnectInfo info) {
		super(info);
	}
	

	/**
	 * 获取数据库的所有表 的表名
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public List<String> getAllTableNames() throws SQLException, ClassNotFoundException {
		open();
		List<String> list = new ArrayList<String>();
		DatabaseMetaData dbmd = null;
		try {
			dbmd = conn.getMetaData();
	
			rs = dbmd.getTables(null, null, null, new String[]{"TABLE"});
	
			while(rs.next()){
				String puffix = rs.getString(2);
				String table = rs.getString(3);
				if(puffix==null)
					list.add(table);
				else
					list.add(rs.getString(2)+"."+rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			close();
		}
		return list;
	}
	
	/**
	 * 获取表所有列的列名
	 * @param tableName
	 * @return
	 */
//	public List<List<String>> getTableColumns(String tableName){
//		return new QueryList().query("select * from information_schema.columns where table_name='"+tableName+"'");
//	}
	
	private void open() throws ClassNotFoundException, SQLException{
		conn = getConn();
	}
	private void close() throws SQLException{
		closeConn(conn) ;  conn = null;
		closeRs(rs) ; rs = null;
	}
	
}
