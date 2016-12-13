package cn.test;

import cn.blacard.nymph.date.ChineseCalendar;
import cn.blacard.nymph.entity.HighPrecisionIpPositioningEntity;
import cn.blacard.nymph.net.tool.HighPrecisionIpPositioningTool;
import cn.blacard.nymph.net.tool.IPTool;
import net.sf.json.JSONObject;

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
	 * IP 转 地址
	 * @author Blacard
	 * @create 2016年12月13日 上午11:51:33
	 * @param args
	 */
	public static void main(String[] args) {
//		HighPrecisionIpPositioningEntity entity = IPTool.getHighPrecisionIpPositioningByIP("58.34.140.86");
		System.out.println(IPTool.getAddressByIp("180.162.251.9"));
		
	}
	/**
	 * JSONObject转 Bean测试
	 * @author Blacard
	 * @create 2016年12月13日 上午10:29:00
	 * @param args
	 */
	public static void main_json_to_bean(String[] args) {
		JSONObject hehe = JSONObject.fromObject("{'content':{'location':{'lat':31.225112,'lng':121.443857},'locid':'8a6e357f270e6ef2688ab1a34ef2b89e','radius':30,'confidence':1.0},'result':{'error':161,'loc_time':'2016-12-13 10:07:34'}}");
		HighPrecisionIpPositioningEntity entity = (HighPrecisionIpPositioningEntity)JSONObject.toBean(hehe,HighPrecisionIpPositioningEntity.class);
		System.out.println(entity.getResult().getError());
	}
	/**
	 * 农历，公历转换测试
	 * @author Blacard
	 * @create 2016年12月13日 上午10:28:25
	 * @param args
	 */
	public static void main_nongli(String[] args) {
		String solar = ChineseCalendar.sCalendarLundarToSolar(2016, 10, 11);
		System.out.println(solar);
	}
}