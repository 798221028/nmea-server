package dataguru.java.server.nmea.exception;

import dataguru.java.server.nmea.util.ErrorType;

public class BusinessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessException(ErrorType msg) {
		
		super(msg.name());
	}

}
