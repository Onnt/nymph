package cn.virde.db.sql;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cn.blacard.dbopera.constant.DBStyle;
import cn.blacard.nymph.Nym;

public class Test {
	
	static SqlDbUtil sqlDB = new SqlDbUtil(new SqlDbConnectInfo(DBStyle.MYSQL,"139.196.50.251","db_chun","blacard","DengZhou_474183"));
	
	public static void main(String[] args) throws SQLException {
		
		for(int i = 0 ; i < 100000 ; i++){
//			sqlDB.query("select * from person");
			System.out.println("当前进度："+i+"/100000");
//			sqlDB.executeSql("insert into test(str) value('"+Nym.time.toString(new Date())+"')");
		}
		
		
		
	}
}
