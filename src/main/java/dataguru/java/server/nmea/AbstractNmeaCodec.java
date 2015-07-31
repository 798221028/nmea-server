package dataguru.java.server.nmea;

import java.util.List;
import java.util.Observable;

import dataguru.java.server.nmea.util.ErrorType;

public abstract class AbstractNmeaCodec extends Observable{
	
	protected AbstractNmeaObject nmeaObj;
	
	abstract public void decode(String content);
	
	abstract public List<String> encode(AbstractNmeaObject obj);
	
	abstract public AbstractNmeaObject getNmeaObj();
	
}
