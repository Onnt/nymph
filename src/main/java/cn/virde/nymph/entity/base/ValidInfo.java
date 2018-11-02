package cn.virde.nymph.entity.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Virde
 * 2018年1月17日 下午4:10:51
 */
public class ValidInfo implements Serializable{
	
	private static final long serialVersionUID = 940281963976920102L;
	
	private boolean isOk ;
	private String info;
	
	private List<ValidInfo> result = new ArrayList<ValidInfo>();
	
	public boolean isOk() {
		if(this.result != null &&  this.result.size() > 0) {
			this.isOk = false ;
		}else {
			this.isOk = true ;
		}
		return isOk;
	}
	public void setIsOk(boolean isOk) {
		this.isOk = isOk;
	}
	public String getInfo() {
		if(this.info == null) {
			if(this.result.size() > 0) {
				this.isOk = false ;
				this.info = "参数验证未通过";
			}else {
				this.isOk = true ;
				this.info = "参数验证通过";
			}
		}
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public List<ValidInfo> getResult() {
		return result;
	}
	
	public static ValidInfo un(String info) {
		ValidInfo respInfo = new ValidInfo();
		respInfo.setIsOk(false);
		respInfo.setInfo(info);
		return respInfo;
	}
	
	public void add(String info) {
		this.result.add(ValidInfo.un(info));
	}
}
