package cn.blacard.nymph.net.tool;

import cn.blacard.nymph.entity.ConverseGeocodingEntity;
import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.net.html.HtmlGet;
import net.sf.json.JSONObject;

public class GeocodingTool {
	
	private static GeocodingTool tool = new GeocodingTool();
	
	/**
	 * 
	 * @author Blacard
	 * @create 2016年12月13日 下午6:16:02
	 * @param location
	 * @return
	 */
	public static String locationToAddress(LocationEntity location){
		ConverseGeocodingEntity entity = tool.getConverseGeocoding(location);
		return entity.getResult().getFormatted_address();
	}
	
	
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
	 * @create 2016年12月13日 下午6:15:48
	 * @param location
	 * @return
	 */
	private String createRequestUrl(LocationEntity location){
		return createRequestUrl(
				"json",
				"yMOZ0v2ANY6UF0l6CNfVnVae",
				location.toString());
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
	private String createRequestUrl(String output,String ak,String location){
		StringBuffer sb = new StringBuffer();
		sb.append("http://api.map.baidu.com/geocoder/v2/");
		//格式，json 或者xml
		sb.append("?output="+output);
		sb.append("&ak="+ak);
		sb.append("&location="+location);
		return sb.toString();
	}
}
