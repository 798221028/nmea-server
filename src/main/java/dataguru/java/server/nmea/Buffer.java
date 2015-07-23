package dataguru.java.server.nmea;

import java.util.LinkedList;
import java.util.List;

public class Buffer {
	
	private List<String> buf = new LinkedList<String>();
	
	public List<String> appendContent(String content) {
		buf.add(content);
		return buf;
	}
}
