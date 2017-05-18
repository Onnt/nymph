package cn.virde.db.sql;

import java.sql.SQLException;
import java.util.List;

import cn.blacard.dbopera.connect.Connect;


public class SqlDbUtil<T> {
	
	private SqlDbCurdResultAsListList listListUtil ;
	private SqlDbCurdResultAsObject objectUtil ;
	
	public SqlDbUtil(SqlDbConnectInfo info){
		listListUtil = new SqlDbCurdResultAsListList(info);
		objectUtil = new SqlDbCurdResultAsObject(info);
		
	}
	public List<List<String>> query(String querySql) throws SQLException, ClassNotFoundException{
		return listListUtil.query(querySql);
	}
//	public int executeSql(String excuteSql) throws SQLException{
//		int count = 0;
//		open();
//		count = sta.executeUpdate(excuteSql);
//		close();
//		return count;
//	}
//
//	public Object queryOne(String sql, Object[] args, Class clazz) {
//		return null;
//	}
//	public int executeSQL(String sql, Object[] args) {
//		return -1;
//	}
//	
//	public List<String> getAllTableNames(){
//		return null;
//	}
//	public List<List<String>> getTableColumns(String tableName){
//		return null;
//	}
//
//	private void open() {
//		try {
//			Class.forName(info.getDRIVER());
//			conn = DriverManager.getConnection(info.getURL(), info.getUser(), info.getPass());
//			sta = conn.createStatement();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
