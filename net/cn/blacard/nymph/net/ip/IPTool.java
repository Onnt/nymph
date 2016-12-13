package cn.blacard.nymph.net.ip;


import cn.blacard.nymph.entity.HighPrecisionIpPositioningEntity;
import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.net.tool.GeocodingTool;

public class IPTool{
	
	private static IPToolDeal deal = new IPToolDeal();
	
	public static String getAddressByIp(String ip){
		LocationEntity entity = getHighPrecisionIpPositioningByIP(ip).getContent().getLocation();
		return GeocodingTool.locationToAddress(entity);
	}
	
	/**
	 * 通过IP地址获取到查询结果
	 * @author Blacard
	 * @create 2016年12月13日 上午11:50:53
	 * @param ip
	 * @return
	 */
	public static HighPrecisionIpPositioningEntity getHighPrecisionIpPositioningByIP(String ip){
		return deal.getHighPrecisionIpPositionByIp(ip);
	}
}
