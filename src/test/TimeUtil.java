package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class TimeUtil {
	/**
	 * 获取当前日期
	 * @return 当前日期字符串
	 */
	public static String getNowDate(){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd ");
		return format.format(date);
	}
	
	/**
	 * 获取当前时间
	 * @return 当前时间字符串
	 */
	public static String getNowTime(){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	
	/**
	 * 生成规定范围内随机日期
	 * @param startYear 起始年
	 * @param startMonth 起始月
	 * @param startDay 起始日
	 * @param endYear 结束年
	 * @param endMonth 结束月
	 * @param endDay 结束日
	 * @return 随机日期
	 * @throws DateFormatErrorException 如果输入年月日格式错误
	 */
	public static Date getRandomDate(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) throws DateFormatErrorException {
		//检测日期格式
		if(!checkDate(startYear,startMonth,startDay)) {
			throw new DateFormatErrorException(startYear, startMonth , startDay);
		}
		if(!checkDate(endYear,endMonth,endDay)) {
			throw new DateFormatErrorException(endYear, endMonth , endDay);
		}
		Calendar calender = Calendar.getInstance();
		calender.set(startYear, startMonth - 1, startDay);
		long startTime = calender.getTime().getTime();
		calender.set(endYear, endMonth - 1, endDay);
		long endTime = calender.getTime().getTime();
		double randomDate = Math.random() * (endTime - startTime) + startTime;
		calender.setTimeInMillis(Math.round(randomDate));
		return calender.getTime();
	}
	
	/**
	 * 时间戳转化为日期字符串
	 * @param stamp 时间戳
	 * @return String 日期字符串
	 */
	public static String stampToDate(Date stamp) {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		return format.format(stamp);
	}
	
	/**
	 * 时间戳转化为时间字符串
	 * @param stamp 时间戳
	 * @return String 时间字符串
	 */
	public static String stampToTime(Date stamp) {
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(stamp);
	}
	
	/**
	 * 检测月份是否超过范围
	 * @param month 要检测的日期
	 * @return true如果未超出正常范围
	 */
	public static boolean checkMonth(int month) {
		return month >= 1 && month <= 12 ? true : false;
	}
	
	/**
	 * 检测年月日格式是否正确
	 * @param month 要检测的年月日
	 * @return true如果未超出正常范围
	 */
	public static boolean checkDate(int year,int month, int day) {
		if(!checkMonth(month)) {
			return false;
		}
		if(month == 4 || month == 6 || month == 9 || month == 11) {
			return day >= 1 && day <= 30 ? true : false;
		} if(month == 2) {
			if(year % 100 == 0) {
				return day >= 1 && day <= 28 ? true : false;
			} else {
				if(year % 4 == 0) {
					return day >= 1 && day <= 29 ? true : false;
				} else {
					return day >= 1 && day <= 28 ? true : false;
				}
			}
		} else {
			return day >= 1 && day <= 31 ? true : false;
		}
	}
	
	public static boolean checkUserActive(String logTime, String todayDate) throws ParseException {
		SimpleDateFormat sdfd= new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdft= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dLogTime = sdft.parse(logTime);
		Date dTodayDate = sdfd.parse(todayDate);
		System.out.println(dLogTime.getTime());
		System.out.println(dTodayDate.getTime());
		return dLogTime.getTime() > dTodayDate.getTime() ? true : false;
	}
}
