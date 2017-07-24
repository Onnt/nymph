package cn.virde.nymph.net.tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.virde.nymph.Nym;
import cn.virde.nymph.config.Config;
import cn.virde.nymph.entity.base.LocationEntity;
import cn.virde.nymph.util.Log;

public class Position {
	
	private JSONObject position ;

	public Position(){
		setPosition(null);
	}
	
	public Position(String ip){
		setPosition(ip);
	}

	public String getAddress() {
		if(position == null) return null ;
		return position.getJSONObject("content").getString("address");
	}

	public LocationEntity getLocation() {
		if(position == null) return null ;

		LocationEntity location = new LocationEntity();
		location.setLat(position.getJSONObject("content").getJSONObject("point").getDoubleValue("y"));
		location.setLng(position.getJSONObject("content").getJSONObject("point").getDoubleValue("x"));

		return location;
	}

	public void setPosition(String ip) {
		String reqUrl = Config.position.getReqUrl(ip) ;
		String resp = Nym.http.get(reqUrl);
		
		this.position = JSON.parseObject(resp);
		
		if(position.getIntValue("status") != 0){
			Log.info("普通IP定位返回值有误","请求值：" + reqUrl +",返回值：" + resp);
			this.position = null ;
		}
		
	}
	
	
}
