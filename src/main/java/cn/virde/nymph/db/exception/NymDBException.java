package cn.virde.nymph.db.exception;

/**
 * 
 * @author Virde
 * 2018年4月23日 下午3:59:13
 */
public class NymDBException extends Exception{

	public NymDBException(String message) {
		super(message);
	}
	public NymDBException(Exception e) {
		super(e);
	}
	public NymDBException(String string, Exception e) {
		super(e);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 3725857422938543724L;

}
