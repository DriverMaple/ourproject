package com.mooc.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MyDateUtils {
	private static final String patterndef = "yyyy-MM-dd HH:mm:ss";
	public static final String END_DAY="yyyy-MM-dd";
	
	public static final String END_MONTH="yyyy-MM";

	public static final String YYMM="yyyy年MM月";
	public static final String MMDD="MM月dd日";
	public static final String YYMMDDHHMMSS="yyyy年MM月dd日 HH点mm分ss秒";
	
	public static final Integer NOW=0;//当前月
	public static final Integer ONE_MONTH_AGO=1;//当前月的一个月前
	public static final Integer TWO_MONTH_AGO=2;//当前月的2个月前
	public static final Integer YEAR = 12;//一年时间段
	public static final Integer TWO_YEAR = 24;//两年时间段
	public static final Integer THREE_TIME = 36;//三年时间段

	/**
	 * 将时间转换字符串
	 * 
	 * param date时间
	 * param pattern格式
	 * return
	 */
	public static String fromat(Date date, String pattern) {
		DateFormat dateFormat = null;
		if (date == null)
			return "";
		if (pattern == null || "".equals(pattern))
			dateFormat = new SimpleDateFormat(patterndef);
		else
			dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	/**
	 * 将时间转换字符串重载
	 * 
	 * param date时间
	 * param pattern格式
	 * return
	 */
	public static String fromat(Date date) {
		DateFormat dateFormat = null;
		if (date == null)
			return "";
		dateFormat = new SimpleDateFormat(patterndef);
		return dateFormat.format(date);
	}

	/**
	 * 将字符串解析为时间格式
	 * 
	 * param date
	 * param pattern
	 * return
	 */
	public static Date parse(String date, String pattern) {
		DateFormat dateFormat = null;
		if (date == null || "".equals(date))
			return null;
		if (pattern == null || "".equals(pattern))
			dateFormat = new SimpleDateFormat(patterndef);
		else
			dateFormat = new SimpleDateFormat(pattern);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将字符串解析为时间格式重载
	 * 
	 * param date
	 * param pattern
	 * return
	 */
	public static Date parse(String date) {
		DateFormat dateFormat = null;
		if (date == null || "".equals(date))
			return null;
		dateFormat = new SimpleDateFormat(patterndef);
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 计算两个时间的天数差
	 * 
	 * param fDate
	 * param oDate
	 * return
	 */
	public static int daysOfTwo(Date fDate, Date oDate) {
		
		return  (int)Math.abs(((fDate.getTime() - oDate.getTime())/ (1000*3600*24)));
	}

	/**
	 * 日期加上天数得到新日期
	 * 
	 * param date
	 * param days
	 * return
	 */
	public static Date getNewDate(Date date, int days) {

		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		aCalendar.add(Calendar.DAY_OF_YEAR, days);
		return aCalendar.getTime();

	}

	/**
	 * 日期加上月数获得新的时间
	 * 
	 * @return
	 */
	public static Date getNewDateMonth(Date date, int months) {
		Calendar aCalendar = Calendar.getInstance();
		aCalendar.setTime(date);
		aCalendar.add(Calendar.MONTH, months);
		return aCalendar.getTime();
	}

	/**
	 * 比较两个时间的年月日 是否为同一天
	 * 
	 * param date1
	 * param date2
	 * return
	 */
	public static boolean isSameDate(Date date1, Date date2) {
		if(date1==null||date2==null){
			return false;
		}
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);

		boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
		boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
		boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);

		return isSameDate;
	}

	/**
	 * 加上一个amount（分）之后的时间
	 * 
	 * param date
	 * param amount
	 * return
	 */
	public static Date getNewDateMinute(Date date, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, amount);
		return calendar.getTime();
	}

	/**
	 * 获取date前month个月的初始时间
	 * 
	 * param date
	 * param month
	 * return
	 */
	public static Date getDateBeforeMonth(Date date, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 0 - month);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), 1, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取date后day天的初始时间
	 * 
	 * param date
	 * param month
	 * return
	 */
	public static Date getDateAfterDay(Date date, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0,
				0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 设置年月得到时间
	 * 
	 * param year
	 * param month
	 * return
	 */
	public static Date setYearOrMonth(Integer year, Integer month) {
		Calendar calendar = Calendar.getInstance();
		if (year != null)
			calendar.set(Calendar.YEAR, year);
		if (month != null)
			calendar.set(calendar.MONTH, month - 2);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取天
	 * 
	 * param date
	 * return
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	/**
	 * 获取月
	 * param date
	 * return
	 */
	public static int getMonth(Date date){
		if(date==null)
			return 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH)+1;
	}
	/**
	 * 根据月份获取一个前12个月内 第month月的时间
	 * 限定时间在一年之内
	 * param month
	 * return
	 */
	public static Date getOneYearDate(Integer month) {
		Calendar calendar = Calendar.getInstance();
		int cMonth = calendar.get(Calendar.MONTH) + 1;
		int cyear = calendar.get(Calendar.YEAR);
		if (month == null) {
			month = cMonth;
		} else {
			if (cMonth < month)
				cyear -= 1;
		}
		Date date = setYearOrMonth(cyear, month+1);
		return date;
	}
	/**
	 * 得到礼券活动无限的时间
	 */
	public static Date getLateDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(2100, 12, 12);
		return new Date(calendar.getTimeInMillis());
	}
	/**
	 * 得到截止到天的最开始的时间
	 * param date
	 * return
	 */
	public static Date parseA(String date){
		if(date==null)
			return null;
		return parse(date,END_DAY);
	}
	
	/**
	 * 得到截止到天的最开始的时间
	 * param date
	 * return
	 */
	public static Date parseA(Date date){
		if(date==null)
			return null;
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	/**
	 * 得到截止到天的最后的时间
	 * param date
	 * return
	 */
	public static Date parseB(String date){
		if(date==null)
			return null;
		Date dat=parse(date,END_DAY);
		return getDateAfterDay(dat,1);
	}
	/**
	 * 得到截止到天的最后的时间
	 * param date
	 * return
	 */
	public static Date parseB(Date date){
		if(date==null)
			return null;
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)+1, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
	
	/**
	 * 得到当天的最后时间
	 */
	public static Date getDayLastTime(Date date){
		if(date==null)
			date = new Date();
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 23);  
		calendar.set(Calendar.MINUTE, 59); 
		calendar.set(Calendar.SECOND, 59);  
		calendar.set(Calendar.MILLISECOND, 999); 
		return calendar.getTime();
	}
	
	/**
	 * 得到当天的最后时间
	 */
	public static Date getDayLastTime(String dateStr){
		Date date = new Date();
		date = parse(dateStr,"yyyy-MM-dd");
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR, 23);  
		calendar.set(Calendar.MINUTE, 59); 
		calendar.set(Calendar.SECOND, 59);  
		calendar.set(Calendar.MILLISECOND, 999); 
		return calendar.getTime();
	}
/**
 * * 在map中封装一个时间段
 * 主要用于分月取数据的
 * param startTime时间段开始时间
 * param endTime
 * param monthAgo endTime这个月的上monthAgo的最后时间
 * param monthLen monthLen 时间段
 * return
 */
	public static Map<String, Object> timeLenToMap(String startTime,String endTime ,int monthAgo,int monthLen) {
		 Map<String, Object> map=new HashMap<String, Object>();
		Date start_time= MyDateUtils.parse(startTime);
		Date end_time =MyDateUtils.parse(endTime);
	    if(start_time==null&&end_time==null){
	    	end_time=new Date();
	    	end_time=getDateBeforeMonth(end_time, -1+monthAgo);
	    	start_time=getDateBeforeMonth(end_time, monthLen);
	    }else{
	    	if(end_time==null&&start_time!=null){
	    		start_time=getDateBeforeMonth(start_time, -1+monthAgo);
	    		end_time=getDateBeforeMonth(start_time, 0-monthLen);
	    	}else{
	    		if(start_time==null&&end_time!=null){
	    			end_time=getDateBeforeMonth(end_time, -1+monthAgo);
	    			start_time=getDateBeforeMonth(end_time, monthLen);
	    		}
	    	}
	    }
		map.put("start_time",start_time);
		map.put("end_time",end_time);
		return map;
	}
	/**
	 * 计算两个时间相差多少分钟
	 * param req
	 * param map
	 * param monthAgo
	 * param monthLen
	 */
	public static int dateDiffminute(Date date1,Date date2) {
		long nd = 1000*24*60*60;//一天的毫秒数
		long nh = 1000*60*60;//一小时的毫秒数
		long nm = 1000*60;//一分钟的毫秒数
		long ns = 1000;//一秒钟的毫秒数
//		long day = diff/nd;//计算差多少天
//		long hour = diff%nd/nh;//计算差多少小时
		 return (int)Math.abs((date1.getTime()-date2.getTime())%nd%nh/nm);//计算差多少分钟
//		long sec = diff%nd%nh%nm/ns;//计算差多少秒//输出结果
	}
	/**
	 * 获取一个截止月的时间(报表用)
	 * @param month
	 * @return
	 */
	public static Date getMonthDate(Date month){
		if(month==null){
			month=new Date();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(month);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, 1, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}
/**
 * 去两个时间中小的那个
 * param planDueDate
 * param backDate
 * return
 */
	public static Date getMinDate(Date date1, Date date2) {
		Date date=date1;
		if(date1.after(date2))
			date=date2;
		return date;
	}

	public static int getYear(Date date) {
		if(date==null)
			return 0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}
}
