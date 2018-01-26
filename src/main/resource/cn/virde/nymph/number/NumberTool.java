package cn.virde.nymph.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 数字工具
 * @author Virde
 * @time 2018年1月24日 下午3:10:17
 */
public class NumberTool {

	/**
	 * 截取size位小数并返回
	 * @author Virde
	 * @time 2018年1月26日 下午1:57:40
	 * @param size
	 * @param d
	 * @return
	 */
	public double setCale(int size,double d) {
		BigDecimal   b   =   new   BigDecimal(d);  
		return  b.setScale(size,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}
	
	/**
	 * 截取两位小数并返回
	 * @author Virde
	 * @time 2018年1月26日 下午1:57:07
	 * @param d
	 * @return
	 */
	public double set2decimal(double d) {
		return  setCale(2,d); 
	}
	
	/**
	 * 截取两位小数并返回
	 * @author Virde
	 * @time 2018年1月26日 下午1:56:38
	 * @param d
	 * @return
	 */
	public String get2decimal(double d) {
		return format(d,"#.00");
	}
	
	public String format(double d,String format) {
		DecimalFormat df = new DecimalFormat(format);
		return df.format(d);
	}
	
	/**
	 * 将阿拉伯数字转换成中文数字
	 * @author Virde
	 * @time 2018年1月26日 下午1:55:35
	 * @return
	 */
	public int arabToChinese() {
		return 0 ;
	}
	/**
	 * 将中文数字转换成阿拉伯数字
	 * @author Virde
	 * @time 2018年1月26日 下午1:56:02
	 * @return
	 */
	public String chineseToArab() {
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(new NumberTool().get2decimal(23323.3232323));
	}
	
}
