package cn.blacard.nymph.net.tool;

import cn.blacard.nymph.entity.HighPrecisionIpPositioningEntity;
import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.net.html.HtmlGet;
import net.sf.json.JSONObject;

public class HighPrecisionIpPositioningTool {
	
	public LocationEntity getLocationByIp(String ip){
		HighPrecisionIpPositioningEntity entity = getHighPrecisionIpPositionByIp(ip);
		if(entity.getResult().getError()==161){
			return entity.getContent().getLocation();
		}else{
			System.out.println(this.getClass().getName()+":通过IP获取经纬度是发生错误，错误码："+entity.getResult().getError());
			return null;
		}
	}
	
	private HighPrecisionIpPositioningEntity getHighPrecisionIpPositionByIp(String ip){
		HtmlGet get = new HtmlGet();
		String result = get.getPage(createRequestUrl(ip));
		HighPrecisionIpPositioningEntity entity = (HighPrecisionIpPositioningEntity)JSONObject.toBean(JSONObject.fromObject(result), HighPrecisionIpPositioningEntity.class);
		return entity;
	}
		
	private String createRequestUrl(String ip){
		return createRequestUrl(
				"http://api.map.baidu.com/highacciploc/v1",
				"pc",
				"yMOZ0v2ANY6UF0l6CNfVnVae",
				"bd09ll",
				ip);
	}
	private String createRequestUrl(String apiUrl,String qterm,String ak,String coord,String qcip){
		StringBuffer sb = new StringBuffer();
		//请求地址
		sb.append(apiUrl);
		//待定位终端类型,mb:移动设备，pc：固定设备
		sb.append("?qterm="+qterm);
		//开发者密钥
		sb.append("&ak="+ak);
		//返回坐标类型 bd09：百度墨卡托坐标，db09ll：百度经纬度坐标，gcj02：国测局经纬度坐标 
		sb.append("&coord="+coord);
		//待定位IP地址
		sb.append("&qcip="+qcip);
		return sb.toString();
	}
}
