package dataguru.java.server.nmea.gll;

import java.util.List;

import dataguru.java.server.nmea.AbstractNmeaCodec;
import dataguru.java.server.nmea.AbstractNmeaObject;

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

	@Override
	public void decode(String content) {
		// TODO Auto-generated method stub

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
