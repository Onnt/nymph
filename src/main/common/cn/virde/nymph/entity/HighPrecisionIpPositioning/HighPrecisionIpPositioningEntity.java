package cn.virde.nymph.entity.HighPrecisionIpPositioning;

import cn.virde.nymph.common.base.BaseEntity;
import cn.virde.nymph.entity.HighPrecisionIpPositioning.ContentEntity;
import cn.virde.nymph.entity.HighPrecisionIpPositioning.ResultEntity;

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
