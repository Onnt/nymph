package cn.blacard.nymph.net.tool.deal;

import cn.blacard.nymph.entity.ConverseGeocodingEntity;
import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.net.html.HtmlGet;
import net.sf.json.JSONObject;

public class GeocodingToolDeal {
	public ConverseGeocodingEntity getConverseGeocoding(LocationEntity location){
		String requestUrl = createRequestUrl(location);
		JSONObject jsonObj =JSONObject.fromObject(new HtmlGet().getPage(requestUrl));
		return (ConverseGeocodingEntity) JSONObject.toBean(
						jsonObj,
						ConverseGeocodingEntity.class);
	}
	
	
	
	
	private String createRequestUrl(LocationEntity location){
		return createRequestUrl(
				"json",
				"yMOZ0v2ANY6UF0l6CNfVnVae",
				location.toString());
	}
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
