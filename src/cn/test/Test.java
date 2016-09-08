package cn.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.blacard.dbopera.opera.Query;
import cn.blacard.dbopera.para.DBConnectPara;
import cn.blacard.nymph.String.NymFormat;
import cn.blacard.nymph.file.NymFile;
import cn.blacard.nymph.net.down.DownFromUrl;
import cn.blacard.nymph.sound.Sound;
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
	 * 根据文件大小 筛选文件
	 * @author Blacard
	 * @create 2016年9月4日 上午8:22:13
	 * @param 
	 */
	public static void main_file_size(String[] args) {
		NymFile nymFile = new NymFile("E://115");
		System.out.println("formar:"+NymFormat.fileLength(nymFile.length()));
	}
	
	/**
	 * 筛选多个后缀名
	 * @author Blacard
	 * @create 2016年9月3日 下午11:45:15
	 * @param args
	 */
	public static void main_mutil_file(String[] args) {
		NymFile file = new NymFile("G://");
		List<String> list = new ArrayList<String>();
		list.add("jpg");list.add("txt");
		List<File> files = file.getFileBySuffixs(list);
		TextOut to  = new TextOut("D://ssa.txt");
		for(File f : files){
			System.out.println(f.getAbsolutePath());
			to.putln(f.getAbsolutePath());
		}
	}
	
	
	/**
	 * 文件夹 改进 测试
	 * @author Blacard
	 * @create 2016年9月2日 上午11:16:52
	 * @param args
	 */
	public static void main_file_test(String[] args) {
		List<File> list = new NymFile("F://").getAllFiles();
		for(File f : list)
			System.out.println(f.getAbsolutePath());
	}
	
	
	
	/**
	 * 声音测试
	 * @author Blacard
	 * @create 2016年9月2日 上午11:16:34
	 * @param args
	 */
	public static void main_sound(String[] args) {
		Sound sound = new Sound();
		sound.speak("早上好");
	}
	
	
	
	/**
	 * 根据后缀名获取文件
	 * @author Blacard
	 * @Create 2016年9月1日 下午4:02:28
	 * @param args
	 */
	public static void main_getFileBySuffix(String[] args) {
		for(File f:new NymFile("F://").getFileBySuffix("jpg"))
			System.out.println(f.getAbsolutePath());
	}
	
	/**
	 * 下载文件测试
	 * @author Blacard
	 * @Create 2016年9月1日 下午3:16:01
	 * @param args
	 */
    public static void main_down(String[] args) {  
        try{  
            new DownFromUrl().downFromUrl("http://images.cnitblog.com/blog2015/126867/201503/310029153575518.png");  
        }catch (Exception e) {  
            // TODO: handle exception  
        }  
    }
	
	/**
	 * 获取所有文件测试
	 * @author Blacard
	 * @Create 2016年8月31日 下午2:50:35
	 * @param args
	 */
	public static void main_nymFile(String[] args) {
		
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
