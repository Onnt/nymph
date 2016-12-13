package cn.blacard.nymph.net.tool;

import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.net.tool.GeocodingTool;
import cn.blacard.nymph.net.tool.HighPrecisionIpPositioningTool;

public class IPTool{
	
	private static HighPrecisionIpPositioningTool ipPositionTool = new HighPrecisionIpPositioningTool();
	
	/**
	 * 通过IP获取地理位置信息
	 * @author Blacard
	 * @create 2016年12月13日 下午5:24:14
	 * @param ip
	 * @return
	 */
	public static String getAddressByIp(String ip){
		LocationEntity location = ipPositionTool.getLocationByIp(ip);
		return GeocodingTool.locationToAddress(location);
	}
	
}
