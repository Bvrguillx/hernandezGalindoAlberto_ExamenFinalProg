package exceptions;

@SuppressWarnings("serial")
public class ListSizeOverflownException extends Exception {

	public ListSizeOverflownException(String msg)  {
		super("[Tu Excepcion]: " + msg);
	}
	
}
