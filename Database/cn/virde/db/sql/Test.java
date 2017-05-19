package cn.virde.db.sql;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cn.blacard.nymph.Nym;
import cn.virde.db.constant.DBStyle;

public class Test {
	
	static SqlDbUtil<PersonEntity> sqlDB = new SqlDbUtil<PersonEntity>(new SqlDbConnectInfo(DBStyle.MYSQL,"139.196.50.251","db_chun","blacard","DengZhou_474183"));
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		
//		testQueryListList();
		for(int i= 0 ; i < 10000 ; i++){

			System.out.println("当前进度："+i+"/10000");
			testObjectQuery();
		}
	}
	
	
	public static void testQueryListList() throws ClassNotFoundException, SQLException{
		List<List<String>> list_list = sqlDB.query("select * from person");
		
		for(List<String> list : list_list){
			for(String str : list){
				System.out.println(str);
			}
		}
	}
	
	public static void testExec() throws ClassNotFoundException, SQLException{

		for(int i = 0 ; i < 100000 ; i++){
			System.out.println("当前进度："+i+"/100000");
			sqlDB.executeSql("insert into test(str) value('"+Nym.time.toString(new Date())+"')");
		}
	}
	
	public static void testObjectQuery() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, SQLException{
		PersonEntity str = sqlDB.query("select * from person where per_name = ?", new Object[]{"sunao"}, PersonEntity.class).get(0);
		System.out.println(str.getPer_pass());
	}
}











class PersonEntity{
	private String per_name;
	private String per_pass;
	public String getPer_name() {
		return per_name;
	}
	public void setPer_name(String per_name) {
		this.per_name = per_name;
	}
	public String getPer_pass() {
		return per_pass;
	}
	public void setPer_pass(String per_pass) {
		this.per_pass = per_pass;
	}
	

	
}