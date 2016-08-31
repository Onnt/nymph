package cn.test;

import java.io.File;
import java.util.List;

import cn.blacard.dbopera.opera.Query;
import cn.blacard.dbopera.para.DBConnectPara;
import cn.blacard.nymph.file.NymFile;
import cn.blacard.nymph.text.TextOut;


/**
 * 
 * <h3>title:</h3>
 * <p>测试类</p>
 * @author Blacard
 * @createTime 下午2:21:40
 * @e_mail blacard@163.com
 * @phone 18037170703
 */
public class Test {
	
	/**
	 * @author Blacard
	 * @Create 2016年8月31日 下午2:50:35
	 * @param args
	 */
	public static void main(String[] args) {
		
		NymFile nf  = new NymFile(new File("E://"));
		List<File> list = nf.getAllFiles();
		for(File f : list){
			System.out.println(f.getAbsolutePath());
			new TextOut("1.txt").putln(f.getAbsolutePath());
		}
	}
	
	/**
	 * 测试数据库访问接口
	 * @param args
	 */
	public static void main_testDBConnect(String[] args) {
		DBConnectPara dbp = new DBConnectPara("mysql","blacard.cn","BLACARD","root","yunbin");
		Query q = new Query(dbp);
		for(List<String> list :q.query("select * from person"))
			for(String s : list)
				System.out.println(s);
	}
}
