package cn.virde.nymph.number;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 
 * @author Virde
 * @time 2018年1月24日 下午3:10:17
 */
public class NumberTool {
	
	public double setCale(int size,double d) {
		BigDecimal   b   =   new   BigDecimal(d);  
		return  b.setScale(size,   BigDecimal.ROUND_HALF_UP).doubleValue(); 
	}
	public double set2decimal(double d) {
		return  setCale(2,d); 
	}
	
	public String get2decimal(double d) {
		return format(d,"#.00");
	}
	
	public String format(double d,String format) {
		DecimalFormat df = new DecimalFormat(format);
		return df.format(d);
	}
	
	public static void main(String[] args) {
		System.out.println(new NumberTool().get2decimal(23323.3232323));
	}
}
