package cn.blacard.nymph.entity.base;

import cn.blacard.nymph.base.BaseEntity;

/**
 * <h1>经纬度 实体</h1>
 * @lng longitude 经度
 * @lat Latitude 纬度
 * @author Blacard
 * @联系方式  邮箱：blacard@163.com <br/> 手机：18037170703
 * @Create 2016年12月20日 上午6:21:53
 */
public class LocationEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4990061270128175850L;

	//经度
	private double lng;
	//纬度
	private double lat;
	/**
	 * 获取 纬度
	 * @author Blacard
	 * @create 2016年12月20日 上午6:20:21
	 * @return
	 */
	public double getLat() {
		return lat;
	}
	/**
	 * 设置纬度
	 * @author Blacard
	 * @create 2016年12月20日 上午6:21:00
	 * @param lat 纬度
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	/**
	 * 获取经度
	 * @author Blacard
	 * @create 2016年12月20日 上午6:20:45
	 * @return
	 */
	public double getLng() {
		return lng;
	}

	/**
	 * 设置经度
	 * @author Blacard
	 * @create 2016年12月20日 上午6:21:00
	 * @param lat 经度
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}
	/**
	 * 构造器
	 * @param lat 经度
	 * @param lng 纬度
	 */
	public LocationEntity(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	public LocationEntity() {
		super();
	}

	@Override
	/**
	 * 转换成字符串
	 * <br/>
	 * 纬经度，sample:"25.1552,121.654"
	 */
	public String toString() {
		return this.lat+","+this.lng;
	}
	/**
	 * 转成经纬度，sample:"121.6544,25.1552"
	 * @author Blacard
	 * @create 2016年12月18日 下午8:30:25
	 * @return
	 */
	public String toStringLngLat(){
		return this.lng+","+this.lat;
	}
	/**
	 * 转成纬经度.sample:"25.1552,121.654"
	 * @author Blacard
	 * @create 2016年12月18日 下午8:30:30
	 * @return
	 */
	public String toStringLatLng(){
		return toString();
	}
}
