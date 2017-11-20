package cn.virde.nymph.db.exception;

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
