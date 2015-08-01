package dataguru.java.server.nmea.gga;

import dataguru.java.server.nmea.AbstractNmeaObject;

public class GgaNmeaObject extends AbstractNmeaObject {
	
	private String ggaID;
	private String timeUTC;
	private String latitudeData;
	private String latitude;
	private String longitudeData;
	private String longitude;
	private String gpsStatus;
	private String satelliteNum;
	private String hdop;
	private String altitude;
	private String altitudeUnit;
	private String wgs;
	private String wgsUnit;
	private String diffTime;
	private String diffID;
	private String checkValue;
	
	public GgaNmeaObject() {
		
		super.setObjType("GGA");
	}
	
	public String getGgaID() {
		return ggaID;
	}
	
	public void setGgaID(String ggaID) {
		this.ggaID = ggaID;
	}
	
	public String getTimeUTC() {
		return timeUTC;
	}
	
	public void setTimeUTC(String timeUTC) {
		this.timeUTC = timeUTC;
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
	
	public String getGpsStatus() {
		return gpsStatus;
	}
	
	public void setGpsStatus(String gpsStatus) {
		this.gpsStatus = gpsStatus;
	}
	
	public String getSatelliteNum() {
		return satelliteNum;
	}
	
	public void setSatelliteNum(String satelliteNum) {
		this.satelliteNum = satelliteNum;
	}
	
	public String getHdop() {
		return hdop;
	}
	
	public void setHdop(String hdop) {
		this.hdop = hdop;
	}
	
	public String getAltitude() {
		return altitude;
	}
	
	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}
	
	public String getAltitudeUnit() {
		return altitudeUnit;
	}
	
	public void setAltitudeUnit(String altitudeUnit) {
		this.altitudeUnit = altitudeUnit;
	}
	
	public String getWgs() {
		return wgs;
	}
	
	public void setWgs(String wgs) {
		this.wgs = wgs;
	}
	
	public String getWgsUnit() {
		return wgsUnit;
	}
	
	public void setWgsUnit(String wgsUnit) {
		this.wgsUnit = wgsUnit;
	}
	
	public String getDiffTime() {
		return diffTime;
	}
	
	public void setDiffTime(String diffTime) {
		this.diffTime = diffTime;
	}
	
	public String getDiffID() {
		return diffID;
	}
	
	public void setDiffID(String diffID) {
		this.diffID = diffID;
	}
	
	public String getCheckValue() {
		return checkValue;
	}
	
	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}
}
