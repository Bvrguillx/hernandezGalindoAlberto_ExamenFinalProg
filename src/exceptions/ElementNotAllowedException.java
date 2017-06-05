package exceptions;

@SuppressWarnings("serial")
public class ElementNotAllowedException extends Exception {

	public ElementNotAllowedException(String msg)  {
		super("[Tu NotAllowedException Bro]: " + msg);
	}
	
}
