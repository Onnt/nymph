package cn.virde.nymph;


import java.io.IOException;

import cn.virde.nymph.String.NymFormat;
import cn.virde.nymph.String.StringTool;
import cn.virde.nymph.code.NymCode;
import cn.virde.nymph.date.ChineseCalendar;
import cn.virde.nymph.date.NymTime;
import cn.virde.nymph.db.mongo.MongoUtil;
import cn.virde.nymph.db.sql.DBConnInfo;
import cn.virde.nymph.db.sql.SqlDbUtil;
import cn.virde.nymph.net.NymHttp;
import cn.virde.nymph.net.down.DownFromUrl;
import cn.virde.nymph.net.tool.GeocodingTool;
import cn.virde.nymph.net.tool.IPTool;
import cn.virde.nymph.net.weather.Weather;
import cn.virde.nymph.random.NumberRandom;
import cn.virde.nymph.text.TextRead;
import cn.virde.nymph.util.Log;

/**
 * Nymph项目中的工具类集合。
 */
public class Nym{
	/**
	 * 中国农历 转换工具
	 * <li>将农历转换为日历</li>
	 * <li>日历转换为阳历</li>
	 */
	public final static ChineseCalendar calendar = new ChineseCalendar();
	
	/**
	 * 时间日期工具，
	 * <li>String to Date </li>
	 * <li>Date to String</li>
	 * <li>timestamp to Date </li>
	 * <li>Date to timestamp</li>
	 * <li>时间加减</li>
	 */
	public final static NymTime time = new NymTime();
	
	/**
	 * 随机数工具
	 */
	public final static NumberRandom random = new NumberRandom();
	
	/**
	 * 格式化 各种数据形式
	 */
	public final static NymFormat format = new NymFormat();
	
	/**
	 * 字符串处理工具
	 */
	public final static StringTool string = new StringTool();
	
	/**
	 * 读取文本内容
	 */
	public final static TextRead text = new TextRead();
	
	
	/**
	 * 
	 */
	public final static DownFromUrl down = new DownFromUrl();
	
	// 以上方法不依赖jar包
	
	/**
	 * <h1>地址解析和逆地址解析功能</h1>
	 * <a href="http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding">
	 * 官网API文档:http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding</a><br/>
	 * 提供从地址到经纬度坐标或者从经纬度坐标到地址的转换服务<br>
	 * 依赖JSON包 <br>
	 * 依赖 org.apache.commons.lang3包
	 */
	public final static GeocodingTool geocoding = new GeocodingTool();
	
	/**
	 * <h1>高精度IP定位</h1>
	 * <a href="http://lbsyun.baidu.com/index.php?title=webapi/high-acc-ip">官网API文档:http://lbsyun.baidu.com/index.php?title=webapi/high-acc-ip</a><br/>
	 * 
	 * 	依赖JSON包 <br>
	 * 依赖 org.apache.commons.lang3包
	 * @author Blacard
	 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
	 * @Create 2016年12月13日 下午8:32:44
	 */
	public final static IPTool ip= new IPTool();
	
	public final static NymHttp http = new NymHttp();
	
	public final static NymCode code = new NymCode();
	
	public final static Weather getWeather(String addr){
		try {
			return new Weather(addr);
		} catch (IOException e) {
			Log.info("getWeather时出现异常");
			return null;
		}
	}
	

	public final static <T> SqlDbUtil<T> getSqlDbUtil(DBConnInfo info){
		return new SqlDbUtil<T>(info);
	}
	
	public final static MongoUtil getMongoUtil(DBConnInfo info){
		return new MongoUtil(info);
	}
	
	
}
