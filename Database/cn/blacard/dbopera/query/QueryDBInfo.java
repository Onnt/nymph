package cn.blacard.dbopera.query;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.blacard.dbopera.connect.Connect;


/**
 *	获取关于数据库的基本信息
 * @changeTime 2016年8月30日16:05:53
 * @since 2016年8月30日16:06:04
 * @author Blacard
 * @e_mail blacard@163.com
 */
public class QueryDBInfo extends QueryBase{
	
	/**
	 * 获取数据库的所有表 的表名
	 * @return
	 */
	public List<String> getAllTableNames() {
		conn = Connect.getConn();
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
			Connect.closeAll(rs, sta, conn);
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
}
