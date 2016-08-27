package cn.blacard.dbopera.opera;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.blacard.dbopera.connect.Connect;

/**
 * 查询 和 增删改
 * @author Blacard
 *
 */
public class Query extends OperaBase{

	public List<List<String>> query(String querySql){
		List<List<String>> list_list = new ArrayList<List<String>>();
		conn = Connect.getConn();
		
		try {
			sta = conn.createStatement();
			rs = sta.executeQuery(querySql);
			
			// 获取结果集的元数据
			ResultSetMetaData rsmd = rs.getMetaData();//得到元数据集
			// 获取一共有多少列
			int columnCount = rsmd.getColumnCount();//得到sql语句到底查询了多少个字段
			while(rs.next()){
				List<String> list = new ArrayList<String>();
				for(int i = 1 ; i <= columnCount ; i++){
					list.add(rs.getString(i));
				}
				list_list.add(list);
			}
		} catch (SQLException e) {
			log.info("数据查询时出现错误，Master你是不会语句输错了呀。(●'◡'●)");
			e.printStackTrace();
		}finally{
			Connect.closeAll(rs,sta,conn);
		}
		return list_list;
	}
	
	public int executeSql(String excuteSql){
		int count = 0;
		conn = Connect.getConn();
		try {
			sta = conn.createStatement();
			count = sta.executeUpdate(excuteSql);
		} catch (SQLException e) {
			log.info("怎删改时出现错误，Master你是不会语句输错了呀。(●'◡'●)");
		}finally{
			Connect.closeAll(rs, sta, conn);
		}
		
		return count;
	}
	


}
