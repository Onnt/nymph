package cn.virde.nymph;


import cn.virde.nymph.clazz.ClazzUtil;
import cn.virde.nymph.code.NymCode;
import cn.virde.nymph.datetime.LunarCalendarUtil;
import cn.virde.nymph.exception.LocationException;
import cn.virde.nymph.file.NymFileOpera;
import cn.virde.nymph.json.JsonUtil;
import cn.virde.nymph.net.down.DownFromUrl;
import cn.virde.nymph.net.http.NymHttp;
import cn.virde.nymph.net.tool.GeocodingTool;
import cn.virde.nymph.net.tool.PositionTool;
import cn.virde.nymph.net.weather.Weather;
import cn.virde.nymph.net.weather.WeatherDeal;
import cn.virde.nymph.number.NumberTool;
import cn.virde.nymph.string.StringTool;
import cn.virde.nymph.system.SystemInfo;
import cn.virde.nymph.text.TextRead;

import java.io.IOException;

/**
 * Nymph项目中的工具类集合。
 */
public class Nym{
	
	// 农历工具
	public final static LunarCalendarUtil lunar = new LunarCalendarUtil();
	
	/**
	 * 字符串处理工具
	 */
	public final static StringTool string = new StringTool();
	
	/**
	 * 数字处理工具
	 */
	public final static NumberTool number = new NumberTool();
	
	/**
	 * json 处理工具
	 */
	public final static JsonUtil json = new JsonUtil();
	/**
	 * 读取文本内容
	 */
	public final static TextRead text = new TextRead();
	
	public final static DownFromUrl down = new DownFromUrl();
	
	public final static NymFileOpera file = new NymFileOpera();
	
	// 以上方法不依赖jar包
	
	/**
	 * 地址解析和逆地址解析功能
	 * 官网API文档:http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding
	 * 提供从地址到经纬度坐标或者从经纬度坐标到地址的转换服务
	 * 依赖JSON包
	 * 依赖 org.apache.commons.lang3包
	 */
	public final static GeocodingTool geocoding = new GeocodingTool();
	
	public final static NymHttp http = new NymHttp();
	
	public final static NymCode code = new NymCode();
	
	public final static PositionTool position = new PositionTool();
	
	public final static SystemInfo system = new SystemInfo();
	
	public final static ClazzUtil clazz = new ClazzUtil();

}
