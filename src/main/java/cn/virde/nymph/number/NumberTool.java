package cn.virde.nymph.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import cn.virde.nymph.Nym;

/**
 * 数字工具
 * @author Virde
 * 2018年1月24日 下午3:10:17
 */
public class NumberTool {

	/**
	 * 截取size位小数并返回
	 * @author Virde
	 * 2018年1月26日 下午1:57:40
	 * @param size 位数
	 * @param d 被截取对象
	 * @return 返回
	 */
	public double setCale(int size,double d) {
		BigDecimal   b   =   new   BigDecimal(d);
		return  b.setScale(size,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}
	
	/**
	 * 截取两位小数并返回
	 * @author Virde
	 * 2018年1月26日 下午1:57:07
	 * @param d 被截取对象
	 * @return 返回
	 */
	public double set2decimal(double d) {
		return  setCale(2,d); 
	}
	
	/**
	 * 截取两位小数并返回
	 * @author Virde
	 * 2018年1月26日 下午1:56:38
	 * @param d 被截取对象
	 * @return 返回
	 */
	public String get2decimal(double d) {
		return format(d,"#.00");
	}
	
	private String format(double d,String format) {
		DecimalFormat df = new DecimalFormat(format);
		return df.format(d);
	}
	
	/**
	 * 将阿拉伯数字转换成中文数字
	 * @author Virde
	 * 2018年1月26日 下午1:55:35
	 * @return 返回
	 */
	public int arabToChinese() {
		return 0 ;
	}
	/**
	 * 将中文数字转换成阿拉伯数字
	 * @author Virde
	 * 2018年1月26日 下午1:56:02
	 * @return 返回
	 */
	public String chineseToArab() {
		return null;
	}
	
}
