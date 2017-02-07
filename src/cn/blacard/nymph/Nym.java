package cn.blacard.nymph;

import cn.blacard.nymph.String.NymFormat;
import cn.blacard.nymph.String.StringTool;
import cn.blacard.nymph.date.ChineseCalendar;
import cn.blacard.nymph.date.NymTime;
import cn.blacard.nymph.random.NumberRandom;
import cn.blacard.nymph.text.TextRead;

/**
 * Nymph项目中的工具类集合。
 * 
 * <br/>
 * 还不是很完善，会一直持续优化。
 * 暂不保证版本的向后兼容性
 * @author Blacard
 * @联系方式 邮箱：blacard@163.com <br/> 手机：18037170703
 * @create 2017年2月7日 下午5:50:49
 */
public class Nym {
	/**
	 * 中国农历 转换工具
	 * <li>将农历转换为日历</li>
	 * <li>日历转换为阳历</li>
	 */
	public final static ChineseCalendar chineseCalendar = new ChineseCalendar();
	
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
	public final static TextRead textRead = new TextRead();
}
