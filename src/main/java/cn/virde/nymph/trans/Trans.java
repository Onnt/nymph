package cn.virde.nymph.trans;

import cn.virde.nymph.Nym;

/**
 * 数据转换工具
 * @author SunAo
 * 2018年4月12日 下午1:46:36
 */
public class Trans {
	
	/**
	 * 万能转换工具
	 * 传入整数则转换为Integer
	 * 传入双精度则转换为Double
	 * 传入日期数据则转换为Date类型
	 * …
	 * 目前的需求是还原以字符串表示的数字类型
	 * 
	 * 2018年4月13日 11:24:02
	 * 额算了，现阶段没有这个需求，
	 * 而且实现貌似有点儿太复杂了。要复习一下数据上下转型才行、
	 * 而且试用者也要对数据上下转型非常熟悉才好。
	 * 麻烦，暂时不写了
	 * @author SunAo
	 * 2018年4月12日 下午1:47:41
	 * @param str 对象
	 * @return 返回
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public <T> T trans(String str) {
//		"^[0-9]+(.[0-9]{2})?$"
		
		//如果是整数 则返回int
		if(Nym.string.isFormat(str, "^[0-9]*$")) {
			Integer i = Integer.parseInt(str) ;
			return (T) i ;
		}
		// 如果是小数，则返回double
		
		Integer i = 0 ;
		Double d = (double) 0 ;
		return (T) i ;
	}
}
