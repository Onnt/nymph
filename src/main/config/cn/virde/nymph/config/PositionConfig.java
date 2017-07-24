package cn.virde.nymph.config;

public class PositionConfig {
	
	public String url = "http://api.map.baidu.com/location/ip" ;
	
	public String ak = "yMOZ0v2ANY6UF0l6CNfVnVae" ;
	
	public String getReqUrl(String ip){
		StringBuffer sb = new StringBuffer();
		sb.append(url) ; 
		sb.append("?ak="+ak) ;
		if(ip!=null && !ip.equals("")){
			sb.append("&ip=" + ip ) ;
		}
		return sb.toString();
	}
	
	public String getReqUrl(){
		return getReqUrl(null) ;
	}
	
}
