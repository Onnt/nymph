package cn.blacard.nymph.net.tool;

import cn.blacard.nymph.entity.ConverseGeocodingEntity;
import cn.blacard.nymph.entity.base.LocationEntity;
import cn.blacard.nymph.net.tool.deal.GeocodingToolDeal;

public class GeocodingTool {
	
	private static GeocodingToolDeal deal = new GeocodingToolDeal();
	
	public static String locationToAddress(LocationEntity location){
		ConverseGeocodingEntity entity = deal.getConverseGeocoding(location);
		return entity.getResult().getFormatted_address();
	}
}
