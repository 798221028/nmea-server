package dataguru.java.server.nmea.aam;

import dataguru.java.server.nmea.AbstractNmeaCodec;
import dataguru.java.server.nmea.AbstractNmeaObject;
import dataguru.java.server.nmea.util.ThreadPool;

import java.util.List;
import java.util.Observable;

public class AamNmeaCodec extends AbstractNmeaCodec {

	@Override
	public void decode(String content) {

	}

	@Override
	public List<String> encode(AbstractNmeaObject obj) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public AbstractNmeaObject getNmeaObj() {
		return nmeaObj;
	}
	
	
}
