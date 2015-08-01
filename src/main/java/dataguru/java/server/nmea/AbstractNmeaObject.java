package dataguru.java.server.nmea;

public abstract class AbstractNmeaObject {
	
	private String objType;

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}
	
}
