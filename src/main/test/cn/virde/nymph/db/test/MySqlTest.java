package cn.virde.nymph.db.test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import cn.virde.nymph.db.exception.NymDBException;
import cn.virde.nymph.db.mysql.MySql;

public class MySqlTest {

	private static MySql<Person> mysql = new MySql<Person>("virde.cn","db_chun","blacard","DengZhou_474183");
	public static void main(String[] args) throws NymDBException, SQLException {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					method();
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					method();
					try {
						Thread.sleep(2);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	

		new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					method();
					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	private static void method() {
		List<Person> list = null;
		try {
//			synchronized ("sdf") {
				list = mysql.query("select * from platform_user", null, Person.class);
				System.out.println(new Date() + list.get(0).getName());
//			}

//			for(Person p :list) {
//				System.out.println(p.getName());
//			}
		} catch (NymDBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
