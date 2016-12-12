package cn.blacard.nymph.net.ip;

import cn.blacard.nymph.entity.JingWeiDuEntity;
import cn.blacard.nymph.net.html.HtmlGet;

public class IPToolDeal {
	protected static JingWeiDuEntity getJingWeiDu(){
		HtmlGet get = new HtmlGet();
		System.out.println(get.getPage("http://api.map.baidu.com/highacciploc/v1?qcip=58.34.140.86&qterm=pc&ak=yMOZ0v2ANY6UF0l6CNfVnVae&coord=bd09ll"));
		return null;
	}
	
	public static void main(String[] args) {
		getJingWeiDu();
	}
}
