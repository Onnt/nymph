package cn.virde.db.sql;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class SqlDbUtil<T> {
	
	private SqlDbCurdResultAsListList listListUtil ;
	private SqlDbCurdResultAsObject<T> objectUtil ;
	
	public SqlDbUtil(SqlDbConnectInfo info){
		listListUtil = new SqlDbCurdResultAsListList(info);
		objectUtil = new SqlDbCurdResultAsObject<T>(info);
	}
	
	public List<List<String>> query(String querySql) throws SQLException, ClassNotFoundException{
		return listListUtil.query(querySql);
	}
	
	public List<T> query(String sql, Object[] args, Class clazz) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, SQLException{
		return objectUtil.query(sql, args, clazz);
	}

	public int executeSql(String excuteSql) throws SQLException, ClassNotFoundException{
		return listListUtil.executeSql(excuteSql);
	}
	public int executeSQL(String sql, Object[] args) throws ClassNotFoundException, SQLException {
		return objectUtil.executeSQL(sql, args);
	}
	
	
//	public List<String> getAllTableNames(){
//		return null;
//	}
//	public List<List<String>> getTableColumns(String tableName){
//		return null;
//	}
}
