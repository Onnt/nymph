package cn.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.blacard.dbopera.para.DBConnectPara;
import cn.blacard.dbopera.query.QueryList;
import cn.blacard.nymph.Nym;
import cn.blacard.nymph.entity.ConverseGeocodingEntity;
import cn.blacard.nymph.entity.HighPrecisionIpPositioningEntity;
import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.file.NymFile;
import cn.blacard.nymph.net.down.DownFromUrl;
import cn.blacard.nymph.net.tool.HighPrecisionIpPositioningTool;
import cn.blacard.nymph.net.weather.Weather;
import cn.blacard.nymph.text.TextOut;

public class ClearTest {
	
	
	public static void main_his(String[] args) {
		String str ="sdfsdfsd;sdfsd;df;gdfg;dfhgfd;";
		String[] strs = str.split(";");
		for(String s : strs)
			System.out.println(s);
	}	
	/**
	 * 根据文件大小 筛选文件
	 * @author Blacard
	 * @create 2016年9月4日 上午8:22:13
	 * @param 
	 */
	public static void main_file_size(String[] args) {
		NymFile nymFile = new NymFile("E://115");
		System.out.println("formar:"+Nym.format.fileLength(nymFile.length()));
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
		QueryList q = new QueryList(dbp);
		for(List<String> list :q.query("select * from person"))
			for(String s : list)
				System.out.println(s);
	}

	
	/**
	 * 地理位置 转 经纬度
	 * @author Blacard
	 * @create 2016年12月20日 上午7:08:33
	 * @param args
	 * @throws IOException 
	 */
	public static void main_address_to_location(String[] args) throws IOException {
//	public static void main(String[] args) {
		LocationEntity location = Nym.geocoding.addressToLocation("南翔镇");
		
		ConverseGeocodingEntity entity = Nym.geocoding.getConverseGeocodingEntity(location);
		System.out.println("经纬度 ： "+location.toString());
		System.out.println(entity.getResult().getAddressComponent().getStreet());
	}
	/**
	 * 获取天气预报，测试
	 * @author Blacard
	 * @create 2016年12月20日 上午5:06:11
	 * @param args
	 * @throws IOException 
	 */
//	public static void main_weather(String[] args) {
	public static void main_address_to_weather(String[] args) throws IOException {
		Weather weather = new Weather("洛阳");
	
		System.out.println(weather.getForecastWeather().getResult().getHourly().getDescription());
		System.out.println(weather.getRealtimeWeather().getResult().getSkycon().toString());
		System.out.println("当前温度："+weather.getRealtimeWeather().getResult().getTemperature()+" ℃");
//		System.out.println(weather.getForecastWeather().getResult().getDaily().getSkycon()[0].getValue());
	}
	
	/**
	 * IP 转 地址
	 * @author Blacard
	 * @create 2016年12月13日 上午11:51:33
	 * @param args
	 * @throws IOException 
	 */
	public static void main_ip_to_address(String[] args) throws IOException {
//		HighPrecisionIpPositioningEntity entity = IPTool.getHighPrecisionIpPositioningByIP("58.34.140.86");
//		System.out.println(IPTool.getAddressByIp("115.51.96.159"));
		System.out.println(Nym.ip.getLocationByIp("219.158.100.25").toString());
//		System.out.println(HighPrecisionIpPositioningTool.getLocationByIp("115.51.96as.159").toString());
//		HtmlGet get = new HtmlGet();
//		String str = get.getPage("http://api.map.baidu.com/highacciploc/v1?qterm=pc&ak=yMOZ0v2ANY6UF0l6CNfVnVae&coord=bd09ll&qcip=116.225.64.220");
//		System.out.println(str);
	}

	/**
	 * 农历，公历转换测试
	 * @author Blacard
	 * @create 2016年12月13日 上午10:28:25
	 * @param args
	 */
	public static void main_chinese(String[] args) {
		Date solar = Nym.chineseCalendar.toSunDate(new Date());
		System.out.println(Nym.time.toString(solar));
	}
	
	public static void main_random(String[] args) {
		for(int i = 0 ; i < 100; i++){
			System.out.println(Nym.random.getRandom(0, 9));
		}
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(Nym.ip.getLocationByIp("58.34.141.111"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
