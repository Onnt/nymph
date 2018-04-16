package cn.virde.nymph.exception;

public class NotExistFieldException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2302395711350983243L;
	
    public NotExistFieldException(String message) {
        super(message);
    }

    public NotExistFieldException() {
    	
    }
    
}
