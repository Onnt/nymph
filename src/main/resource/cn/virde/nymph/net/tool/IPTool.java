package cn.virde.nymph.net.tool;

import java.io.IOException;

import cn.virde.nymph.Nym;
import cn.virde.nymph.entity.base.LocationEntity;

public class IPTool{
		
	/**
	 * 通过IP获取地理位置信息
	 * @author Blacard
	 * @create 2016年12月13日 下午5:24:14
	 * @param ip
	 * @return 
	 * @throws IOException 
	 */
	public static String getAddressByIp(String ip){
		return Nym.geocoding.locationToAddress(new HighPrecisionIpPositioningTool().getLocationByIp(ip));
	}
	
	/**
	 * 通过IP获取经纬度
	 * @author Blacard
	 * @create 2017年2月8日 上午10:37:07
	 * @param ip
	 * @return
	 * @throws IOException 
	 */
	public  LocationEntity getLocationByIp(String ip){
		return new HighPrecisionIpPositioningTool().getLocationByIp(ip);
	}
}
