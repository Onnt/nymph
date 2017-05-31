package cn.virde.nymph.db.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.virde.nymph.util.Log;

public class SqlDbCurdResultAsListList extends SqlDbCurd{

	private Connection conn;
	private ResultSet rs ;
	private Statement sta ;
	
	public SqlDbCurdResultAsListList(DBConnInfo info) {
		super(info);
	}
	
	public List<List<String>> query(String querySql){
		if(!open()) return null;
		
		rs = executeQuery(querySql);
		if(rs == null) return null;
		
		List<List<String>> list_list = new ArrayList<List<String>>();
		while(rsNext()){
			list_list.add(getOneRowData());
		}
		close();
		return list_list;
	}
	private ResultSet executeQuery(String querySql){
		try {
			return sta.executeQuery(querySql);
		} catch (SQLException e) {
			Log.info("执行Sql时出现错误，操作已经终止，sql："+querySql, e);
		}
		return null;
	}
	private boolean rsNext(){
		try {
			return rs.next();
		} catch (SQLException e) {
			Log.info("rs.next()时出现异常，操作已经终止，（PS:讲真的，这个错误我不能理解）", e);
		}
		return false;
	}
	private List<String> getOneRowData(){
		int colCount = getColumnCount();
		List<String> list = new ArrayList<String>();
		for(int i = 1 ; i <= colCount ; i++){
			list.add(getRsStringByColumnIndex(i));
		}
		return list;
	}
	private int getColumnCount(){
		try {
			return rs.getMetaData().getColumnCount();
		} catch (SQLException e) {
			Log.info("获取查询结果总数时出现异常", e);
			return 0 ;
		}
	}
	private String getRsStringByColumnIndex(int index){
		try {
			return rs.getString(index);
		} catch (SQLException e) {
			Log.info("根据columnIndex从ResultSet取值时发生异常，columnIndex:"+index, e);
			return "";
		}
	}
	
	
	public int executeSql(String excuteSql){
		if(!open()) return -1;
		int count = executeUpdate(excuteSql);
		close();
		return count;
	}
	private int executeUpdate(String sql){
		try {
			return sta.executeUpdate(sql);
		} catch (SQLException e) {
			Log.info("执行Statement.executeUpdate()时出现异常，sql:"+sql, e);
			return -1 ;
		}
	}
	
	private boolean open(){
		try {
			conn = getConn();
		} catch (ClassNotFoundException | SQLException e) {
			Log.info("打开链接时出现异常，操作已经终止", e);
			return false;
		}
		try {
			sta = conn.createStatement();
		} catch (SQLException e) {
			Log.info("创建Statement时出现异常，操作已经终止", e);
			return false;
		}
		return true;
	}
	private void close(){
		closeConn(conn); conn = null ;
		closeSta(sta); sta = null;
		closeRs(rs); rs = null;
	}
}
