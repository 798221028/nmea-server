package dataguru.java.server.nmea;

import java.util.List;

import dataguru.java.server.nmea.aam.AamNmeaCodec;
import dataguru.java.server.nmea.util.ThreadPool;

public class CodecManager {
	
	private Buffer buffer;
	
//	private AbstractNmeaCodec abstractNmeaCodec;
//	
//	public CodecManager(AbstractNmeaCodec abstractNmeaCodec) {
//		
//		this.abstractNmeaCodec = abstractNmeaCodec;
//	}
	
	public void decode(final String content) {
		
		ThreadPool.get().executeTask(new Runnable(){

			public void run() {
				
				new AamNmeaCodec().decode(content);

			}
			
		});
	}
	
	public List<String> encode(AbstractNmeaObject obj) {
		
		return null;
	}
	
}
