package dataguru.java.server.nmea.gll;

import dataguru.java.server.nmea.AbstractNmeaObject;

public class GllNmeaObject extends AbstractNmeaObject {

	private String gllID;
	private String latitudeData;
	private String latitude;
	private String longitudeData;
	private String longitude;
	private String timeUTC;
	private String positionStatus;
	private String checkValue;
	
	public GllNmeaObject() {
		
		super.setObjType("GLL");
	}
	
	public String getGllID() {
		return gllID;
	}
	
	public void setGllID(String gllID) {
		this.gllID = gllID;
	}
	
	public String getLatitudeData() {
		return latitudeData;
	}
	
	public void setLatitudeData(String latitudeData) {
		this.latitudeData = latitudeData;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitudeData() {
		return longitudeData;
	}
	
	public void setLongitudeData(String longitudeData) {
		this.longitudeData = longitudeData;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getTimeUTC() {
		return timeUTC;
	}
	
	public void setTimeUTC(String timeUTC) {
		this.timeUTC = timeUTC;
	}
	
	public String getPositionStatus() {
		return positionStatus;
	}
	
	public void setPositionStatus(String positionStatus) {
		this.positionStatus = positionStatus;
	}
	
	public String getCheckValue() {
		return checkValue;
	}
	
	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}
}
