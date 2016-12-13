package cn.blacard.nymph.entity;

import cn.blacard.nymph.base.BaseEntity;
import cn.blacard.nymph.entity.HighPrecisionIpPositioning.ContentEntity;
import cn.blacard.nymph.entity.HighPrecisionIpPositioning.ResultEntity;

public class HighPrecisionIpPositioningEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1445778072773355523L;
	
	private ContentEntity content;
	
	private ResultEntity result;

	public ContentEntity getContent() {
		return content;
	}

	public void setContent(ContentEntity content) {
		this.content = content;
	}

	public ResultEntity getResult() {
		return result;
	}

	public void setResult(ResultEntity result) {
		this.result = result;
	}

	public HighPrecisionIpPositioningEntity(ContentEntity content, ResultEntity result) {
		super();
		this.content = content;
		this.result = result;
	}

	public HighPrecisionIpPositioningEntity() {
		super();
	}
}
