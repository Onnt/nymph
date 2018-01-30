package cn.virde.nymph.common.info;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Virde
 * @time 2018年1月17日 下午4:10:51
 */
public class ValidInfo implements Serializable{
	
	private static final long serialVersionUID = 940281963976920102L;
	
	private boolean _isValid ;
	private String info;
	
	private List<ValidInfo> result = new ArrayList<ValidInfo>();
	
	public boolean is_isValid() {
		if(this.result != null &&  this.result.size() > 0) {
			this._isValid = false ;
		}else {
			this._isValid = true ;
		}
		return _isValid;
	}
	public void set_isValid(boolean _isValid) {
		this._isValid = _isValid;
	}
	public String getInfo() {
		if(this.info == null) {
			if(this.result.size() > 0) {
				this._isValid = false ;
				this.info = "参数验证未通过";
			}else {
				this._isValid = true ;
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
		respInfo.set_isValid(false);
		respInfo.setInfo(info);
		return respInfo;
	}
	
	public void add(String info) {
		this.result.add(ValidInfo.un(info));
	}
}
