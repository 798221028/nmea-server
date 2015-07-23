package dataguru.java.server.nmea;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class AbstractNmeaCodec extends Observable {
	
	private AbstractNmeaObject nmeaObj;
	
	private Observer observer;
	
	abstract public void decode(String content);
	
	abstract public List<String> encode(AbstractNmeaObject obj);
}
