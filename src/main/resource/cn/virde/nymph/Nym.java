package cn.virde.nymph;


import cn.virde.nymph.String.NymFormat;
import cn.virde.nymph.String.StringTool;
import cn.virde.nymph.clazz.ClazzUtil;
import cn.virde.nymph.code.NymCode;
import cn.virde.nymph.date.LunarCalendarUtil;
import cn.virde.nymph.date.NymTime;
import cn.virde.nymph.file.NymFileOpera;
import cn.virde.nymph.json.JsonUtil;
import cn.virde.nymph.net.down.DownFromUrl;
import cn.virde.nymph.net.http.NymHttp;
import cn.virde.nymph.net.tool.GeocodingTool;
import cn.virde.nymph.net.tool.PositionTool;
import cn.virde.nymph.net.v2.NymHttp;
import cn.virde.nymph.number.NumberTool;
import cn.virde.nymph.random.Random;
import cn.virde.nymph.system.SystemInfo;
import cn.virde.nymph.text.TextRead;

/**
 * Nymph项目中的工具类集合。
 */
public class Nym{
	
	// 农历工具
	public final static LunarCalendarUtil lunar = new LunarCalendarUtil();
	
	// 时间 日期工具
	public final static NymTime time = new NymTime();
	
	// 随机数工具
	public final static Random random = new Random();
	
	/**
	 * 格式化 各种数据形式
	 */
	public final static NymFormat format = new NymFormat();
	
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
	
	
	/**
	 * 
	 */
	public final static DownFromUrl down = new DownFromUrl();
	
	public final static NymFileOpera file = new NymFileOpera();
	
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
	
	public final static NymHttp http = new NymHttp();
	
	public final static NymCode code = new NymCode();
	
	public final static PositionTool position = new PositionTool();
	
	public final static SystemInfo system = new SystemInfo();
	
	public final static ClazzUtil clazz = new ClazzUtil();

}
