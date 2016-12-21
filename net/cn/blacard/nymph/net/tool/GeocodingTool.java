package cn.blacard.nymph.net.tool;

import cn.blacard.nymph.entity.ConverseGeocodingEntity;
import cn.blacard.nymph.entity.GeocodingEntity;
import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.net.html.HtmlGet;
import net.sf.json.JSONObject;

/**
 * <h1>地址解析和逆地址解析功能</h1>
 * <a href="http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding">
 * 官网API文档:http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-geocoding</a><br/>
 * 提供从地址到经纬度坐标或者从经纬度坐标到地址的转换服务<br/>
 * 
 * 工具类默认开放方法均为静态类，开放方法相当于service
 * 
 * @author Blacard
 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
 * @Create 2016年12月13日 下午9:48:39
 */
public class GeocodingTool {
	
	//获取本类的静态实例化对象，本工具类只开放静态方法，非静态方法全部私有
	private static GeocodingTool tool = new GeocodingTool();
	
	/**
	 * 经纬度 转 地理位置
	 * @author Blacard
	 * @create 2016年12月13日 下午6:16:02
	 * @param location
	 * @return
	 */
	public static String locationToAddress(LocationEntity location){
		ConverseGeocodingEntity entity = tool.getConverseGeocoding(location);
		if(entity.getStatus()==0){
			return entity.getResult().getFormatted_address();
		}else{
			System.out.println(
					tool.getClass().getName()+
					": 逆向编译地理位置时发生错误，错误码："
					+entity.getStatus());
			return null;
		}
	}

	/**
	 * 地址 转 经纬度
	 * @author Blacard
	 * @create 2016年12月22日 上午5:59:14
	 * @param address
	 * @return
	 */
	public static LocationEntity addressToLocation(String address){
		GeocodingEntity entity = tool.getGeocoding(address);
		if(entity.getStatus()==0){
			return entity.getResult().getLocation();
		}else{
			System.out.println(
					tool.getClass().getName()+
					": 根据地理位置获取经纬度时发生错误，错误码："
					+entity.getStatus());
			return null;
		}
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月22日 上午6:07:37
	 * @param location
	 * @return
	 */
	public static ConverseGeocodingEntity getConverseGeocodingEntity(LocationEntity location){
		return tool.getConverseGeocoding(location);
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月22日 上午6:07:41
	 * @param address
	 * @return
	 */
	public static GeocodingEntity getGeocodingEntity(String address){
		return tool.getGeocoding(address);
	}
	
	
	
	
	
	/* ==========================================
	 * 			以下为私有方法
	 * ==========================================
	 */
	

	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月13日 下午6:15:41
	 * @param location
	 * @return
	 */
	private ConverseGeocodingEntity getConverseGeocoding(LocationEntity location){
		String requestUrl = createRequestUrl(location);
		JSONObject jsonObj =JSONObject.fromObject(new HtmlGet().getPage(requestUrl));
		return (ConverseGeocodingEntity) JSONObject.toBean(
						jsonObj,
						ConverseGeocodingEntity.class);
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月20日 上午7:05:46
	 * @param location
	 * @return
	 */
	private GeocodingEntity getGeocoding(String address){
		String requestUrl = createRequestUrl(address);
		JSONObject jsonObj =JSONObject.fromObject(new HtmlGet().getPage(requestUrl));
		return (GeocodingEntity) JSONObject.toBean(
						jsonObj,
						GeocodingEntity.class);
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月20日 上午6:40:18
	 * @param address
	 * @return
	 */
	private String createRequestUrl(String address){
		return createRequestUrl(
				"json",
				"yMOZ0v2ANY6UF0l6CNfVnVae",
				null,
				address);
	}
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月13日 下午6:15:48
	 * @param location
	 * @return
	 */
	private String createRequestUrl(LocationEntity location){
		return createRequestUrl(
				"json",
				"yMOZ0v2ANY6UF0l6CNfVnVae",
				location.toString(),
				null);
	}
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月13日 下午6:15:53
	 * @param output
	 * @param ak
	 * @param location
	 * @return
	 */
	private String createRequestUrl(String output,String ak,String location,String address){
		StringBuffer sb = new StringBuffer();
		sb.append("http://api.map.baidu.com/geocoder/v2/");
		//格式，json 或者xml
		sb.append("?output="+output);
		sb.append("&ak="+ak);
		
		if(location != null && (!location.equals(""))){
			sb.append("&location="+location);
		}
		if(address != null && (!address.equals(""))){
			sb.append("&address="+address);
		}
		return sb.toString();
	}
}
