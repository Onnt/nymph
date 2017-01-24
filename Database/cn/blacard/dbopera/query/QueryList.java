package cn.blacard.dbopera.query;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import cn.blacard.dbopera.connect.Connect;
import cn.blacard.dbopera.para.DBConnectPara;

/**
 *  查询 和 增删改
 *  和 QueryObject 的区别在于 
 *  此类返回的查询结果是以List<List<String>>的形式
 * @changeTime 2016年8月30日16:05:53
 * @since 2016年8月30日16:06:04
 * @author Blacard
 * @e_mail blacard@163.com
 */
public class QueryList extends QueryBase{

	/**
	 * 用构造器传入数据库连接参数
	 * @param para
	 */
	public QueryList(DBConnectPara para){
		Connect.setConnPara(para);
	}
	
	
	/**
	 * 用此构造器之前
	 * 请确认给Connect设置了数据库连接参数
	 */
	public QueryList(){
		super();
	}
	
	public List<List<String>> query(String querySql){
		List<List<String>> list_list = new ArrayList<List<String>>();
		openConnect();
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
		openConnect();
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
