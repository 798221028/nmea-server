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
		byte data[] = ss[i++].getBytes();
		
		// 应该判断 GGA 协议头数据是否是: "$**GGA"
		if (data[pos] != '$' || data[pos+3] != 'G' 
				|| data[pos+4] != 'G' || data[pos+5] != 'A') {
					
			throw new BusinessException(ErrorType.errorProtocolHead);
		}
		
		if (ggaNmeaObject == null) {
			ggaNmeaObject = new GgaNmeaObject();
		}
		
		ggaNmeaObject.setGgaID(ss[i++]);
		ggaNmeaObject.setTimeUTC(ss[i++]);
		ggaNmeaObject.setLatitudeData(ss[i++]);
		ggaNmeaObject.setLatitude(ss[i++]);
		ggaNmeaObject.setLongitudeData(ss[i++]);
		ggaNmeaObject.setLongitude(ss[i++]);
		ggaNmeaObject.setGpsStatus(ss[i++]);
		ggaNmeaObject.setSatelliteNum(ss[i++]);
		ggaNmeaObject.setHdop(ss[i++]);
		ggaNmeaObject.setAltitude(ss[i++]);
		ggaNmeaObject.setAltitudeUnit(ss[i++]);
		ggaNmeaObject.setWgs(ss[i++]);
		ggaNmeaObject.setWgsUnit(ss[i++]);
		ggaNmeaObject.setDiffTime(ss[i++]);
		ggaNmeaObject.setDiffID(ss[i++]);
		ggaNmeaObject.setCheckValue(ss[i++]);
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
