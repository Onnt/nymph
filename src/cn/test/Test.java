package cn.test;

import java.util.List;

import cn.blacard.dbopera.opera.Query;
import cn.blacard.dbopera.para.DBConnectPara;


/**
 * description 
 * author SunAo
 * create time 2016年8月30日 下午4:12:42
 * e-mail : blacard@163.com
 */
public class Test {
	public static void main(String[] args) {
		DBConnectPara dbp = new DBConnectPara("mysql","blacard.cn","BLACARD","root","yunbin");
		Query q = new Query(dbp);
		for(List<String> list :q.query("select * from person"))
			for(String s : list)
				System.out.println(s);
	}
}
