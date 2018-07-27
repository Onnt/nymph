package cn.virde.nymph.entity.weather.realtime;

import cn.virde.nymph.common.base.BaseEntity;

public class PrecipitationEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4594511238712664536L;
	private NearestEntity nearest;
	private LocalEntity local;
	public NearestEntity getNearest() {
		return nearest;
	}
	public void setNearest(NearestEntity nearest) {
		this.nearest = nearest;
	}
	public LocalEntity getLocal() {
		return local;
	}
	public void setLocal(LocalEntity local) {
		this.local = local;
	}
	public PrecipitationEntity(NearestEntity nearest, LocalEntity local) {
		super();
		this.nearest = nearest;
		this.local = local;
	}
	public PrecipitationEntity() {
		super();
	}
	
	

}
