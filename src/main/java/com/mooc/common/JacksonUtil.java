package com.mooc.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
  

/**
 * json转换集合类型
 * 
 * @author linwh
 */

public class JacksonUtil {
	
	private static String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	//private static final ObjectMapper mapper = new ObjectMapper();
	private static final ObjectMapper mapper = new ObjectMapper();


//	private static ObjectMapper getInstance() {
//		return mapper;
//	}


	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 * @since 1.0
	 */
	private static JavaType getCollectionType(Class<?> collectionClass,
			Class<?>... elementClasses) {
		return mapper.getTypeFactory().constructParametricType(collectionClass,
				elementClasses);
	}

	/**
	 * 转换集合类型
	 * @param jsonString
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> convertList(String jsonString, Class<T> clazz) {
		if (jsonString != null && !"".equals(jsonString)) {
			JavaType javaType = getCollectionType(ArrayList.class, clazz);
			List<T> list = null;
			try {
				list =  mapper.readValue(jsonString, javaType);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return list;
		}

		return null;
	}
	
	/**
	 * 转换map类型
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Map<String, Object> convertMap(String jsonString){
		
		if (jsonString != null && !"".equals(jsonString)) {
			JavaType javaType = getCollectionType(HashMap.class, String.class, Object.class);
			try {
				return mapper.readValue(jsonString, javaType);
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	
	/**
	 * 对象序列化
	 * 
	 * @param obj 需要序列化的对象
	 * @return 返回json字符串
	 */
	public static String toJson(Object obj){
		try {
			//mapper.configure(Feature.SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
			
//			mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
//				@Override
//				public void serialize(Object value, JsonGenerator jg, SerializerProvider sp) throws IOException, JsonProcessingException {
//				
//					jg.writeString("");
//				}
//			});
			
			mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
			mapper.setDateFormat(new SimpleDateFormat(DATE_PATTERN));
			
			return mapper.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	/**
	 * 将JSON转换成object
	 * 
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> clazz){
		
		try {
			return mapper.readValue(json, clazz);
		} catch (Exception e) {
			
		}
		
		return null;
	}
	
	/**
	 * 
	* <p>Title: 转对象为客户端使用的格式</p>
	* <p>Description:将单个对象或列表对象 不已分页形式返回 </p>
	* @author widthdrawnm
	* @date 2016年4月13日上午10:23:49
	 */
	public static String toBizJson(String code,String msg,Object data){
		
		Data d = new Data(code, msg, data);
		
		return toJson(d);
	}
	/**
	 * 
	* <p>Title: 返回分页对象JSON</p>
	* <p>Description: </p>
	* @author widthdrawnm
	 * @param <T>
	* @date 2016年4月13日上午11:10:55
	 */
	public static <T> String toListBizJson(String code,String msg,Long count,List<T> rows){
		PagenableBean pageBean=new PagenableBean(count, rows);
		
		Data d = new Data(code, msg, pageBean);
		
		return toJson(d);
	}
	
	public static void main(String[] args) {
		String jsonString = "{\"creator.id\":\"\",\"status\":\"\",\"realname\":\"林文豪\",\"username\":\"lwh\",\"mobile\":\"\"}";
		
		Map<String, Object>  result = JacksonUtil.convertMap(jsonString);
		
		System.out.println(result);
	}

	public static <T> List<T> fromJson(String jsonString,
			TypeReference<List<T>> typeReference) {
		try {
			return mapper.readValue(jsonString, new TypeReference<List<T>>() {});
//			return mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, T.class));	
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;   
	}
	
	public static <T> List<T> fromListJson(String jsonString,Class<T> className) {
	
		try {
//			return mapper.readValue(jsonString, new TypeReference<List<T>>() {});
			return mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(List.class, className));	
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;   
	}

	
}