package dataguru.java.server.nmea.gga;

import java.io.IOException;
import java.util.List;

import dataguru.java.server.nmea.AbstractNmeaCodec;
import dataguru.java.server.nmea.AbstractNmeaObject;
import dataguru.java.server.nmea.exception.BusinessException;
import dataguru.java.server.nmea.util.ErrorType;

/*
 * 
 * 例：$GPGGA,092204.999,4250.5589,S,14718.5084,E,1,04,24.4,M,19.7,M,,,0000*1F
	字段0：$GPGGA，语句ID，表明该语句为Global Positioning System Fix Data（GGA）GPS定位信息
	字段1：UTC 时间，hhmmss.sss，时分秒格式
	字段2：纬度ddmm.mmmm，度分格式（前导位数不足则补0）
	字段3：纬度N（北纬）或S（南纬）
	字段4：经度dddmm.mmmm，度分格式（前导位数不足则补0）
	字段5：经度E（东经）或W（西经）
	字段6：GPS状态，0=不可用(FIX NOT valid)，1=单点定位(GPS FIX)，2=差分定位(DGPS)，3=无效PPS，4=实时差分定位（RTK FIX），5=RTK FLOAT，6=正在估算
	字段7：正在使用的卫星数量（00 - 12）（前导位数不足则补0）
	字段8：HDOP水平精度因子（0.5 - 99.9）
	字段9：海拔高度（-9999.9 - 99999.9）
	字段10：单位：M（米）
	字段11：地球椭球面相对大地水准面的高度 WGS84水准面划分
	字段12：WGS84水准面划分单位：M（米）
	字段13：差分时间（从接收到差分信号开始的秒数，如果不是差分定位将为空）
	字段14：差分站ID号0000 - 1023（前导位数不足则补0，如果不是差分定位将为空）
	字段15：校验值
 * 
 */

public class ggaNmeaCodec extends AbstractNmeaCodec {
	
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
	
	@Override
	public void decode(String content) {
		
		if (content == null) {
			
			throw new BusinessException(ErrorType.errorNULLParamter);
		}
		
		int pos = 0;
		int i = 0;
		String ss[] = content.split(",");
		byte data[] = ss[i++].getBytes();
		if (data[pos++] != '$' || data[pos++] != 'G' || data[pos++] != 'P'
				|| data[pos++] != 'G' || data[pos++] != 'G' || data[pos++] != 'G') {
					
			throw new BusinessException(ErrorType.errorProtocolHead);
		}
		
		this.ggaID = ss[i++];
		this.timeUTC = ss[i++];
		this.latitudeData = ss[i++];
		this.latitude = ss[i++];
		this.longitudeData = ss[i++];
		this.longitude = ss[i++];
		this.gpsStatus = ss[i++];
		this.satelliteNum = ss[i++];
		this.hdop = ss[i++];
		this.altitude = ss[i++];
		this.altitudeUnit = ss[i++];
		this.wgs = ss[i++];
		this.wgsUnit = ss[i++];
		this.diffTime = ss[i++];
		this.diffID = ss[i++];
		this.checkValue = ss[i++];
	}
	
	@Override
	public List<String> encode(AbstractNmeaObject obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public AbstractNmeaObject getNmeaObj() {
		// TODO Auto-generated method stub
		return null;
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
