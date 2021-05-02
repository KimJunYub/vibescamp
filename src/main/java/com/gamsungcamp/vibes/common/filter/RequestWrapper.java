package com.gamsungcamp.vibes.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RequestWrapper 
	//implements HttpServletRequestWrapper 
	{
	
	protected final Log logger = LogFactory.getLog(getClass());
	private final String[] TARGET_ARRAY = {"<",">","#","'","\""}; 
	private final String[] REPLACE_ARRAY = {"&lt;","&gt;","&#35;","&#39;","&quot;"};
	
//	public RequestWrapper(HttpServletRequest req) {
//		super(req);
//	}
	
//	static RequestWrapper newInstance(final HttpServletRequest req) {
//		return new RequestWrapper(req);
//	}
	
//	public String[] getParamValues(String param) {
//		String[] val = super.getParamValues(param);
//	
//		if(val == null) return null;
//		
//		int valCnt = val.length;
//		
//		String[] encodedValues = new String[valCnt];
//		
//		for (int i = 0; i < valCnt; i++) {
//			encodedValues[i] = cleanXSS(val[i]);
//		}
//		
//		return encodedValues;
//	}
//	
//	public String getParam(String param) {
//		String value = super.getParam(param);
//		
//		if(value == null) return null;
//		
//		return cleanXSS(value);
//	}
	
	public String cleanXSS(String value) {
		value = value.replace("#", "&#35;");
		value = value.replace("&", "&#38;");
		value = value.replace("&#38;#35;", "&#35;");
		value = value.replace("<", "&lt;");
		value = value.replace(">", "&gt;");
		value = value.replace("\\(", "&#40;");
		value = value.replace("\\)", "&#41;");
		value = value.replace("'", "&#39;");
		value = value.replace("\"", "&quot;");
		value = value.replace("eval\\((.*)\\)", "");
		value = value.replace("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");

		return value;
	}
}