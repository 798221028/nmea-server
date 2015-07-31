package dataguru.java.server.nmea.rmc;

import java.util.List;

import dataguru.java.server.nmea.AbstractNmeaCodec;
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

public class RmcNmeaCodec extends AbstractNmeaCodec {

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
