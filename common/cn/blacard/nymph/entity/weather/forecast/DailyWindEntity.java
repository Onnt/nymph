package cn.blacard.nymph.entity.weather.forecast;


import cn.blacard.nymph.common.base.BaseEntity;

public class DailyWindEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7376055066006144259L;
	
	private String date;
	
	private DailyWindMaxAvgMinEntity max;
	private DailyWindMaxAvgMinEntity avg;
	private DailyWindMaxAvgMinEntity min;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public DailyWindMaxAvgMinEntity getMax() {
		return max;
	}
	public void setMax(DailyWindMaxAvgMinEntity max) {
		this.max = max;
	}
	public DailyWindMaxAvgMinEntity getAvg() {
		return avg;
	}
	public void setAvg(DailyWindMaxAvgMinEntity avg) {
		this.avg = avg;
	}
	public DailyWindMaxAvgMinEntity getMin() {
		return min;
	}
	public void setMin(DailyWindMaxAvgMinEntity min) {
		this.min = min;
	}
	
	

}
