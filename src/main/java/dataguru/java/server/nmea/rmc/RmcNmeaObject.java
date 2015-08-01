package dataguru.java.server.nmea.rmc;

import dataguru.java.server.nmea.AbstractNmeaObject;

/*
 * 
 * 	例：$GPRMC,024813.640,A,3158.4608,N,11848.3737,E,10.05,324.27,150706,,,A*50
	字段0：$GPRMC，语句ID，表明该语句为Recommended Minimum Specific GPS/TRANSIT Data（RMC）推荐最小定位信息
	字段1：UTC时间，hhmmss.sss格式
	字段2：状态，A=定位，V=未定位
	字段3：纬度ddmm.mmmm，度分格式（前导位数不足则补0）
	字段4：纬度N（北纬）或S（南纬）
	字段5：经度dddmm.mmmm，度分格式（前导位数不足则补0）
	字段6：经度E（东经）或W（西经）
	字段7：速度，节，Knots
	字段8：方位角，度
	字段9：UTC日期，DDMMYY格式
	字段10：磁偏角，（000 - 180）度（前导位数不足则补0）
	字段11：磁偏角方向，E=东W=西
	字段12：模式，A=自动，D=差分，E=估测，N=数据无效（3.0协议内容）
	字段13：校验值
 */

public class RmcNmeaObject extends AbstractNmeaObject {

	private String rmcID;
	private String timeUTC;
	private String positionStatus;
	private String latitudeData;
	private String latitude;
	private String longitudeData;
	private String longitude;
	private String speed;
	private String atimuth;
	private String utcDate;
	private String magnetic;
	private String magneticDirction;
	private String model;
	private String checkValue;
	
	public RmcNmeaObject() {
		
		super.setObjType("RMC");
	}
	
	public String getRmcID() {
		return rmcID;
	}
	
	public void setRmcID(String rmcID) {
		this.rmcID = rmcID;
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
	
	public String getSpeed() {
		return speed;
	}
	
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	public String getAtimuth() {
		return atimuth;
	}
	
	public void setAtimuth(String atimuth) {
		this.atimuth = atimuth;
	}
	
	public String getUtcDate() {
		return utcDate;
	}
	
	public void setUtcDate(String utcDate) {
		this.utcDate = utcDate;
	}
	
	public String getMagnetic() {
		return magnetic;
	}
	
	public void setMagnetic(String magnetic) {
		this.magnetic = magnetic;
	}
	
	public String getMagneticDirction() {
		return magneticDirction;
	}
	
	public void setMagneticDirction(String magneticDirction) {
		this.magneticDirction = magneticDirction;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getCheckValue() {
		return checkValue;
	}
	
	public void setCheckValue(String checkValue) {
		this.checkValue = checkValue;
	}
}
