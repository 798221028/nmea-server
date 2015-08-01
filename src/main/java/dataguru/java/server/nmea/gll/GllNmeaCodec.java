package dataguru.java.server.nmea.gll;

import java.util.List;

import dataguru.java.server.nmea.AbstractNmeaCodec;
import dataguru.java.server.nmea.AbstractNmeaObject;
import dataguru.java.server.nmea.exception.BusinessException;
import dataguru.java.server.nmea.util.ErrorType;

/*
 * 	例：$GPGLL,4250.5589,S,14718.5084,E,092204.999,A*2D
	字段0：$GPGLL，语句ID，表明该语句为Geographic Position（GLL）地理定位信息
	字段1：纬度ddmm.mmmm，度分格式（前导位数不足则补0）
	字段2：纬度N（北纬）或S（南纬）
	字段3：经度dddmm.mmmm，度分格式（前导位数不足则补0）
	字段4：经度E（东经）或W（西经）
	字段5：UTC时间，hhmmss.sss格式
	字段6：状态，A=定位，V=未定位
	字段7：校验值
 * 
 */

public class GllNmeaCodec extends AbstractNmeaCodec {

	private GllNmeaObject gllNmeaObject;
	
	@Override
	public void decode(String content) {
		
		if (content == null) {
			throw new BusinessException(ErrorType.errorNULLParamter);
		}
		
		int i = 0;
		int pos = 0;
		String[] ss = content.split(",");
		byte data[] = ss[i++].getBytes();
		if (data[pos] != '$' || data[pos+3] != 'G' 
				|| data[pos+4] != 'L' || data[pos+4] != 'L') {
			throw new BusinessException(ErrorType.errorProtocolHead);
		}
		
		if (gllNmeaObject == null) {
			gllNmeaObject = new GllNmeaObject();
		}
		
		gllNmeaObject.setGllID(ss[i++]);
		gllNmeaObject.setLatitudeData(ss[i++]);
		gllNmeaObject.setLatitude(ss[i++]);
		gllNmeaObject.setLongitudeData(ss[i++]);
		gllNmeaObject.setLongitude(ss[i++]);
		gllNmeaObject.setTimeUTC(ss[i++]);
		gllNmeaObject.setPositionStatus(ss[i++]);
		gllNmeaObject.setCheckValue(ss[i++]);
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

}
