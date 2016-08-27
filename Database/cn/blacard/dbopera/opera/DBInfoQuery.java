package cn.blacard.dbopera.opera;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.blacard.dbopera.connect.Connect;

public class DBInfoQuery extends OperaBase{
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
	
	public List<List<String>> getTableColumns(String tableName){
		return new Query().query("select * from information_schema.columns where table_name='"+tableName+"'");
	}
}
