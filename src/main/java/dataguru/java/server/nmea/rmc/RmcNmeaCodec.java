package dataguru.java.server.nmea.rmc;

import java.util.List;

import dataguru.java.server.nmea.AbstractNmeaCodec;
import dataguru.java.server.nmea.AbstractNmeaObject;
import dataguru.java.server.nmea.exception.BusinessException;
import dataguru.java.server.nmea.util.ErrorType;

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

	private int padding;
	private RmcNmeaObject rmcNmeaObject;
	
	@Override
	public void decode(String content) {
		
		if (content == null) {
			throw new BusinessException(ErrorType.errorNULLParamter);
		}
		
		int i = 0;
		String ss[] = content.split(",");
		
		if (ss == null || ss.length == 0) {
			throw new BusinessException(ErrorType.errorProtocolData);
		}
		
		byte[] data = ss[i++].getBytes();
		if (data == null || data.length < 6 || data[0] != '$' 
				|| data[3] != 'R' || data[4] != 'M' || data[5] != 'C') {
		
			throw new BusinessException(ErrorType.errorProtocolHead);
		}
		
		if (rmcNmeaObject == null) {
			rmcNmeaObject = new RmcNmeaObject();
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setRmcID(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setTimeUTC(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setPositionStatus(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setLatitudeData(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setLatitude(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setLongitudeData(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setLongitude(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setSpeed(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setAtimuth(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setUtcDate(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setMagnetic(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setMagneticDirction(ss[i++]);
		}
		
		if (i <= ss.length) {
			rmcNmeaObject.setModel(ss[i++]);
		}
		
		/*
		 * 	最后部分数据格式: "4*44\r\n"
		 */
		if (i <= ss.length) {
			
			byte[] value = ss[i].getBytes();
			padding = value[0];
			rmcNmeaObject.setCheckValue(new String(value, 2, 2));
		}
		
		/*
		 *   content 的长度减去 "$GPRMC," 和 ",4*44\r\n" 的长度
		 */
		int len = content.length() - 6 - 2 - 6;
		checkValue(new String(content.getBytes(), 6, len), rmcNmeaObject.getCheckValue());
	}

	public boolean checkValue() {
		
		return false;
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
