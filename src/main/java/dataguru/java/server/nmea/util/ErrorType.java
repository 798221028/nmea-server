package dataguru.java.server.nmea.util;

public enum ErrorType {
	
	/*
	 * 校验值错误
	 */
	errorValueCheck,
	
	/*
	 * 协议头错误, 即协议头格式 ttlll 错误 
	 */
	errorProtocolHead,
	
	/*
	 * 参数为空
	 */
	errorNULLParamter,
	
	/*
	 * 系统错误
	 */
	errorSystem
}
