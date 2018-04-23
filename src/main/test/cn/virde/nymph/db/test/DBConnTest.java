package cn.virde.nymph.db.test;

import java.sql.SQLException;
import java.util.List;

import cn.virde.nymph.Nym;
import cn.virde.nymph.db.ConnInfo;
import cn.virde.nymph.db.exception.NymDBException;
import cn.virde.nymph.db.mysql.MySql;
import cn.virde.nymph.enums.common.DBStyle;

public class DBConnTest {
	public static void main(String[] args) throws NymDBException, SQLException {

		int i = 0 ;
//		while(true) {
		long start = System.currentTimeMillis() ;
		for(int j = 0 ; j < 5000 ; j++) {
			System.out.println("第"+(i++)+"次执行");
			
					ConnInfo connInfo = new ConnInfo(DBStyle.MYSQL,"virde.cn", "db_chun", "blacard", "235_is_Pass");
					MySql mysql = new MySql(connInfo);
					try {
						List<Person> list =  mysql.query("select name,pass from platform_user", null, Person.class);
						System.out.println(list.get(Nym.random.getRandom(0, 6)).getName());
					} catch (NymDBException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		long end = System.currentTimeMillis() ;
		System.out.println((end - start )/1000);
	}
}
