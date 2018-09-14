package cn.virde.nymph.net.http;

/**
 * 
 * @author Virde
 * 2018年6月7日 下午2:56:27
 */
public class NymHttpException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3782210555670751811L;


	public NymHttpException(String msg) {
		super(msg);
	}

	public NymHttpException() {
		super();
	}
}
