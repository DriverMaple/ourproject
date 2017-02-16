package com.mooc.common;



import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



public class RequestUtil{
	public static void checkAgain(HttpServletRequest request){
		Boolean b = (Boolean)request.getAttribute("reqMark");
		if(b!=null&&b)
			throw new MyBizException("当前操作已执行，请不要重复点击");
	}
	/**
	 * 获取客户端的ip地址
	 * param request
	 * return
	 */
	  public static String getIpAddress(HttpServletRequest request) { 
		    String ip = request.getHeader("x-forwarded-for"); 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("Proxy-Client-IP"); 
		    } 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("WL-Proxy-Client-IP"); 
		    } 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("HTTP_CLIENT_IP"); 
		    } 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
		    } 
		    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) { 
		      ip = request.getRemoteAddr(); 
		    } 
		    return ip; 
		  } 

	public static Date getDateValue(HttpServletRequest request, String name,Date ... defaultValue){
		checkAgain(request);
		String value = request.getParameter(name);
        if(StringUtils.isNotBlank(value)){
            try {
                return MyDateUtils.parse(value,MyDateUtils.END_DAY);
            } 
            catch(ClassCastException e) {
                return null;
            }
        }
        	if(defaultValue !=null&&defaultValue.length>0)
        		return defaultValue[0];
        
        return null;
    }
	public static Date getDateValue(HttpServletRequest request, String name,String pattern,Date ... defaultValue){
		checkAgain(request);
		String value = request.getParameter(name);        
        if(StringUtils.isNotBlank(value)){
            try {
                return MyDateUtils.parse(value,pattern);
            } 
            catch(ClassCastException e) {
                return null;
            }
        } 
        if(defaultValue !=null&&defaultValue.length>0)
    		return defaultValue[0];
        return null;
    }
	public static Date getDateValue(HttpServletRequest request, String name){
		checkAgain(request);
		String value = request.getParameter(name);
        if(StringUtils.isNotBlank(value)){
            try {
                return MyDateUtils.parse(value,MyDateUtils.END_DAY);
            } 
            catch(ClassCastException e) {
                return null;
            }
        }
        
        return null;
    }
	public static Date getDateValue(HttpServletRequest request, String name,String pattern){
		checkAgain(request);
		String value = request.getParameter(name);        
        if(StringUtils.isNotBlank(value)){
            try {
                return MyDateUtils.parse(value,pattern);
            } 
            catch(ClassCastException e) {
                return null;
            }
        } 
        return null;
    }
	public static Date getDateValueMust(HttpServletRequest request, String name){
		checkAgain(request);
		String value = request.getParameter(name);        
        if(StringUtils.isNotBlank(value)){
            try {
                return MyDateUtils.parse(value,MyDateUtils.END_DAY);
            } 
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }       
        throwError(name);
        return null;
    }
	public static Date getDateValueMust(HttpServletRequest request, String name,String pattern){
		checkAgain(request);
		String value = request.getParameter(name);        
        if(StringUtils.isNotBlank(value)){
            try {
                return MyDateUtils.parse(value,pattern);
            } 
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }       
        throwError(name);
        return null;
    }
	
	public static String[] getStringArray(HttpServletRequest request,String name){
		checkAgain(request);
		String[] value = request.getParameterValues(name);
		return value;
	}
	
	public static List<Long> getLongArray(HttpServletRequest request,String name){
		checkAgain(request);
		String[] value = request.getParameterValues(name);
		if(value!=null&&value.length>0){
			List<Long> values = new ArrayList<Long>();
			for(int i = 0; i < value.length; i++){
				long parseLong = Long.parseLong(value[i].trim());
				values.add(parseLong);
			}
			return values;
		}
		return null;
	}

	/**
	 * 获取长整形值，若没有按默认值返回
	 * param request
	 * param name
	 * param defaultValue
	 * return
	 * author zhangyz created on 2014-4-26
	 */
	public static Long getLongValue(HttpServletRequest request,String name, Long... defaultValue){
		checkAgain(request);
		String value = request.getParameter(name);
		
		Long factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];
        
		if(StringUtils.isNotBlank(value)){
			try {
		        return Long.parseLong(value.trim());
		    } 
			catch(ClassCastException e) {
		        return factValue;
		    }
		}		
		return factValue;
	}
	
	public static Long getLongValue(Map<String, ?> request, String name, Long... defaultValue){
		String value = (String)request.get(name);
        
        Long factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];
        
        if(StringUtils.isNotBlank(value)){
            try {
                return Long.parseLong(value.trim());
            } 
            catch(ClassCastException e) {
                return factValue;
            }
        }       
        return factValue;
    }
	
	/**
	 * 获取整形值，若没有则抛出异常
	 * param request
	 * param name
	 * return
	 * author zhangyz created on 2014-4-26
	 */
	public static Long getLongValueMust(HttpServletRequest request, String name){
		checkAgain(request);
		String value = request.getParameter(name);        
        if(StringUtils.isNotBlank(value)){
            try {
                return Long.parseLong(value.trim());
            } 
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }       
        throwError(name);
        return null;
    }
	
	public static Long getLongValueMust(Map<String, ?> map, String name){
		String value = (String)map.get(name);        
        if(StringUtils.isNotBlank(value)){
            try {
                return Long.parseLong(value.trim());
            } 
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }       
        throwError(name);
        return null;
    }

    /**
     * 获取byte值，若没有按默认值返回
     * param request
     * param name
     * param defaultValue
     * return
     * author zhangyz created on 2014-4-26
     */
    public static Byte getByteValue(HttpServletRequest request,String name, Byte... defaultValue){
        checkAgain(request);
        String value = request.getParameter(name);

        Byte factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];

        if(StringUtils.isNotBlank(value)){
            try {
                return Byte.parseByte(value.trim());
            }
            catch(ClassCastException e) {
                return factValue;
            }
        }
        return factValue;
    }

    public static Byte getByteValue(Map<String, ?> request, String name, Byte... defaultValue){
        String value = (String)request.get(name);

        Byte factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];

        if(StringUtils.isNotBlank(value)){
            try {
                return Byte.parseByte(value.trim());
            }
            catch(ClassCastException e) {
                return factValue;
            }
        }
        return factValue;
    }

    /**
     * 获取整形值，若没有则抛出异常
     * param request
     * param name
     * return
     * author zhangyz created on 2014-4-26
     */
    public static Byte getByteValueMust(HttpServletRequest request, String name){
        checkAgain(request);
        String value = request.getParameter(name);
        if(StringUtils.isNotBlank(value)){
            try {
                return Byte.parseByte(value.trim());
            }
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }
        throwError(name);
        return null;
    }

    public static Byte getByteValueMust(Map<String, ?> map, String name){
        String value = (String)map.get(name);
        if(StringUtils.isNotBlank(value)){
            try {
                return Byte.parseByte(value.trim());
            }
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }
        throwError(name);
        return null;
    }
	
	private static Integer getIntValue(String value ,Integer... defaultValue) {
		Integer factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];
        
        if(StringUtils.isNotBlank(value)){
            try {
                return Integer.valueOf(value.trim());
            }
            catch(ClassCastException e) {
                return factValue;
            }
        }       
        return factValue;
	}
    
    private static Integer getIntValueMust(String value, String name) {
    	if(StringUtils.isNotBlank(value)){
            try {
                return Integer.valueOf(value.trim());
            }
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }       
        throwError(name);
        return null;
    }
	
	private static Boolean getBooleanValue(String value, boolean... defaultValue) {
		Boolean factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];
        
        if(StringUtils.isNotBlank(value)){
            try {
                return Boolean.valueOf(value.trim());
            }
            catch(ClassCastException e) {
                return factValue;
            }
        }       
        return factValue;
    }
    
    private static Boolean getBooleanValueMust(String value, String name) {
        if(StringUtils.isNotBlank(value)){
            try {
                return Boolean.valueOf(value.trim());
            }
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }       
        throwError(name);
        return null;
    }
	
	/**
	 * 获取整形值，若没有按默认值返回
	 * param request
	 * param name
	 * param defaultValue
	 * return
	 * author zhangyz created on 2014-4-26
	 */
	public static Integer getIntValue(HttpServletRequest request,String name,Integer... defaultValue){
		checkAgain(request);
		String value = request.getParameter(name);
        return getIntValue(value, defaultValue);
	}
	
	public static Integer getIntValue(Map<String, ?> map, String name,Integer... defaultValue){
		String value = (String)map.get(name);
        return getIntValue(value, defaultValue);
    }
	
	/**
	 * 返回整形值，若没有则抛出异常
	 * param request
	 * param name
	 * return
	 * author zhangyz created on 2014-4-26
	 */
	public static Integer getIntValueMust(HttpServletRequest request,String name){
		checkAgain(request);
		String value = request.getParameter(name);        
        return getIntValueMust(value, name);
    }
	
	public static Integer getIntValueMust(Map<String, ?> map,String name){
        String value = (String)map.get(name);     
        return getIntValueMust(value, name);
    }
	
	public static Boolean getBooleanValue(HttpServletRequest request,
	        String name, boolean... defaultValue){
		checkAgain(request);
		String value = request.getParameter(name);
        return getBooleanValue(value, defaultValue);
    }
    
    public static Boolean getBooleanValue(Map<String, ?> map, 
            String name, boolean... defaultValue){
        String value = (String)map.get(name);
        return getBooleanValue(value, defaultValue);
    }
    
    public static Boolean getBooleanValueMust(HttpServletRequest request, String name){
    	checkAgain(request);
    	String value = request.getParameter(name);        
        return getBooleanValueMust(value, name);
    }
    
    public static Boolean getBooleanValueMust(Map<String, String> map, String name){
        String value = map.get(name);     
        return getBooleanValueMust(value, name);
    }
	
	/**
	 * 获取字符值，若没有按默认值返回
	 * param request
	 * param name
	 * param defaultValue
	 * return
	 * author zhangyz created on 2014-4-26
	 */
	public static String getStringValue(HttpServletRequest request,String name,String... defaultValue){
		checkAgain(request);
		String value = request.getParameter(name);		
        String factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];
        
		if(StringUtils.isNotBlank(value)){
		     return value.trim();
		}
		
		return factValue;
	}
	
	public static String getStringValue(Map<String, ?> map ,String name,String... defaultValue){
        String value = (String)map.get(name);      
        String factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];
        
        if(StringUtils.isNotBlank(value)){
             return value.trim();
        }
        
        return factValue;
    }
	
	/**
	 * 获取字符值，若没有则返回异常json串
	 * param request
	 * param name
	 * return
	 * author zhangyz created on 2014-4-26
	 */
	public static String getStringValueMust(HttpServletRequest request, String name){
		checkAgain(request);
		String value = request.getParameter(name);
		if(StringUtils.isNotBlank(value)){
		     return value.trim();
		}else{
		    throwError(name);
			return null;//reponseError();
		}
	}
	
	public static String getStringValueMust(Map<String, String> map, String name){
        String value = map.get(name);
        if(StringUtils.isNotBlank(value)){
             return value.trim();
        }else{
        	throwError(name);
            return JacksonUtil.toBizJson(ApiContants.ERROR, name+"参数为空", null);
        }
    }
	
    /**
     * 获取双浮点型值，若没有按默认值返回
     * param request
     * param name
     * param defaultValue
     * return
     * Author:zhanggd created on 2014-7-26
     */
    public static Double getDoubleValue(HttpServletRequest request,String name, Double... defaultValue){
    	checkAgain(request);
    	String value = request.getParameter(name);
        
        Double factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];
        
        if(StringUtils.isNotBlank(value)){
            try {
                return Double.parseDouble(value);
            } 
            catch(ClassCastException e) {
                return factValue;
            }
        }       
        return factValue;
    }
    
    public static Double getDoubleValue(Map<String, ?> request, String name, Double... defaultValue){
    	String value = (String)request.get(name);
        
        Double factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];
        
        if(StringUtils.isNotBlank(value)){
            try {
                return Double.parseDouble(value);
            } 
            catch(ClassCastException e) {
                return factValue;
            }
        }       
        return factValue;
    }
    
    /**
     * 获取双浮点型值，若没有则抛出异常
     * param request
     * param name
     * return
     * author zhangyz created on 2014-4-26
     */
    public static Double getDoubleValueMust(HttpServletRequest request, String name){
    	checkAgain(request);
    	String value = request.getParameter(name);        
        if(StringUtils.isNotBlank(value)){
            try {
                return Double.parseDouble(value.trim());
            } 
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }       
        throwError(name);
        return null;
    }
    
    public static Double getDoubleValueMust(Map<String, ?> map, String name){
        String value = (String)map.get(name);        
        if(StringUtils.isNotBlank(value)){
            try {
                return Double.parseDouble(value.trim());
            } 
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }       
        throwError(name);
        return null;
    }
	
	public static String[] getRequestParam(HttpServletRequest request, String name){
		checkAgain(request);
		String value = request.getParameter(name);
		String ids[] = null;
		if(StringUtils.isNotBlank(value)){
			return ids = StringUtils.splitByWholeSeparator(value, ",");
		}
		return ids;
	}
    /**
     * 获取http中的json数据
     * param request
     * return
     */
	public static String getJsonValue(HttpServletRequest request){
		checkAgain(request); 
		StringBuilder stb = new StringBuilder();
			String s = null;
			BufferedReader br;
			try {
				br = new BufferedReader(new InputStreamReader(request.getInputStream()));
				while ((s = br.readLine()) != null) {
					stb.append(s);
				}
				return stb.toString();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s;
			
	}

    /**
     * 获取浮点型值，若没有按默认值返回
     * param request
     * param name
     * param defaultValue
     * return
     * Author:zhanggd created on 2014-7-26
     */
    public static Float getFloatValue(HttpServletRequest request,String name, Float... defaultValue){
        checkAgain(request);
        String value = request.getParameter(name);

        Float factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];

        if(StringUtils.isNotBlank(value)){
            try {
                return Float.parseFloat(value);
            }
            catch(ClassCastException e) {
                return factValue;
            }
        }
        return factValue;
    }

    public static Float getFloatValue(Map<String, ?> request, String name, Float... defaultValue){
        String value = (String)request.get(name);

        Float factValue = null;
        if (defaultValue != null && defaultValue.length > 0)
            factValue = defaultValue[0];

        if(StringUtils.isNotBlank(value)){
            try {
                return Float.parseFloat(value);
            }
            catch(ClassCastException e) {
                return factValue;
            }
        }
        return factValue;
    }

    /**
     * 获取双浮点型值，若没有则抛出异常
     * param request
     * param name
     * return
     * author zhangyz created on 2014-4-26
     */
    public static Float getFloatValueMust(HttpServletRequest request, String name){
        checkAgain(request);
        String value = request.getParameter(name);
        if(StringUtils.isNotBlank(value)){
            try {
                return Float.parseFloat(value.trim());
            }
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }
        throwError(name);
        return null;
    }

    public static Float getFloatValueMust(Map<String, ?> map, String name){
        String value = (String)map.get(name);
        if(StringUtils.isNotBlank(value)){
            try {
                return Float.parseFloat(value.trim());
            }
            catch(ClassCastException e) {
                throwError(name);
                return null;
            }
        }
        throwError(name);
        return null;
    }
	
//    private static String reponseError() {
//        return JsonUtils.transferJsonResponse(Constants.ERROR,
//                Constants.MSG_EMPTY_PARAMS,null, null);
//    }
    
    private static void throwError(String name) {
        throw new MyPreconditionFailedException(name + "参数不能为空!");
    }
}