package cn.virde.nymph.net.tool;

import java.io.IOException;

import cn.virde.nymph.entity.base.LocationEntity;
import cn.virde.nymph.exception.LocationException;

public class PositionTool {
	
	/**
	 * 获取指定IP的经纬度
	 * @param ip ip地址
	 * @return 返回
	 * @throws LocationException  异常
	 * @throws IOException  异常
	 */
	public LocationEntity getLocationByIp(String ip) throws LocationException, IOException{
		return new Position(ip).getLocation() ;
	}
	/**
	 * 获取程序IP的所在地址的经纬度
	 * @return 返回
	 * @throws LocationException  异常
	 * @throws IOException  异常
	 */
	public LocationEntity getLocation() throws LocationException, IOException{
		return new Position().getLocation() ;
	}
	/**
	 * 获取指定IP的地址
	 * @param ip IP地址
	 * @return 返回
	 * @throws LocationException  异常
	 * @throws IOException  异常
	 */
	public String getAddressByIp(String ip) throws LocationException, IOException{
		return new Position(ip).getAddress() ;
	}
	/**
	 * 获取程序IP所在的地址
	 * @return 返回
	 * @throws LocationException  异常
	 * @throws IOException  异常
	 */
	public String getAddress() throws LocationException, IOException{
		return new Position().getAddress() ;
	}
	
	/**
	 * 经纬度转地址
	 * @param location 经纬度
	 * @return 返回
	 * @throws LocationException  异常
	 * @throws IOException  异常
	 */
	public String locationToAddress(LocationEntity location) throws LocationException, IOException{
		return new GeocodingTool().locationToAddress(location);
	}
	/**
	 * 地址转经纬度
	 * @param address 地理位置
	 * @return 返回
	 * @throws LocationException  异常
	 * @throws IOException  异常
	 */
	public LocationEntity addressToLocation(String address) throws LocationException, IOException{
		return new GeocodingTool().addressToLocation(address);
	}
}
