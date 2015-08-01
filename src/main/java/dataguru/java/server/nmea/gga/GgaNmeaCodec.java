package dataguru.java.server.nmea.gga;

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

public class GgaNmeaCodec extends AbstractNmeaCodec {
	
	private GgaNmeaObject ggaNmeaObject;
	
	@Override
	public void decode(String content) {
		
		if (content == null) {
			
			throw new BusinessException(ErrorType.errorNULLParamter);
		}
		
		int pos = 0;
		int i = 0;
		String ss[] = content.split(",");

		if (ss == null || ss.length == 0) {
			throw new BusinessException(ErrorType.errorProtocolData);
		}
		
		byte data[] = ss[i++].getBytes();
		
		// 应该判断 GGA 协议头数据是否是: "$**GGA"
		if (data.length < 6 || data[0] != '$' || data[3] != 'G' 
				|| data[4] != 'G' || data[5] != 'A') {
					
			throw new BusinessException(ErrorType.errorProtocolHead);
		}
		
		if (ggaNmeaObject == null) {
			ggaNmeaObject = new GgaNmeaObject();
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setGgaID(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setTimeUTC(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setLatitudeData(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setLatitude(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setLongitudeData(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setLongitude(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setGpsStatus(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setSatelliteNum(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setHdop(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setAltitude(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setAltitudeUnit(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setWgs(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setWgsUnit(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setDiffTime(ss[i++]);
		}
		
		if (i <= ss.length) {
			ggaNmeaObject.setDiffID(ss[i++]);
		}
		
		int padding = 0;
		if (i <= ss.length) {
			
			byte[] value = ss[i].getBytes();
			padding = value[0];
			ggaNmeaObject.setCheckValue(new String(value, 2, 2));
		}
		
		int len = content.length() - 6 - 2 - 6;
		checkValue(new String(content.getBytes(), 6, len), ggaNmeaObject.getCheckValue());
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

	public GgaNmeaObject getGgaNmeaObject() {
		return ggaNmeaObject;
	}

	public void setGgaNmeaObject(GgaNmeaObject ggaNmeaObject) {
		this.ggaNmeaObject = ggaNmeaObject;
	}

}
