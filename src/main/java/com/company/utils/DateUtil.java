package com.company.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil{
	public static String DEFAULT_FORMAT = "yyyy-MM-dd";
	/**
	 * @param date
	 * @throws ParseException
	 * return 获取当前时间，并转换当前秒。
	 */
	public static String DateToTime() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String day = df.format(date);
		return day;
	}
	
	/**
	 * @param date
	 * @throws ParseException
	 * return 获取当前时间，转为当前天数
	 */
	public static String DateToDay() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String day = df.format(date);
		return day;
	}
	
	/**
	 * @param date
	 * @throws ParseException
	 * return 获取当前时间，转为当前月
	 */
	public static String DateToMonth() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
		String day = df.format(date);
		return day;
	}
	
	/**
	 * @param date
	 * @throws ParseException
	 * return 获取当前时间，转为当前年
	 */
	public static String DateToYear() {
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy");
		String day = df.format(date);
		return day;
	}
	
	/**
	 * @param date
	 * @throws ParseException
	 * return 将规定格式的字符串转化为日期
	 */
	public static Date DateFormat(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date day = null;
		try {
			day = df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return day;
	}
	
	/**
	 * @param date
	 * @throws ParseException
	 * return 将规定格式的字符串转化为时间戳(毫秒)
	 */
	public static Long DateFormatLong(String date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date day = null;
		try {
			day = df.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return day.getTime();
	}
	
	
	/**
	 * @param date
	 * @throws ParseException
	 * return 将日期转化为规定格式的字符串 yyyy-MM-dd
	 */
	public static String myDateFormat(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String day = df.format(date);
		return day;
	}

	/**
	 * @param String
	 * @throws ParseException
	 * return 计算两个时间的相差天数，含首尾时间
	 */
	public static long getDateDiffDay(String Day1, String Day2) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// 转换时间格式
		Date dt1 = formatter.parse(Day1); // 将得到的日期字符串转换为日期类型
		Date dt2 = formatter.parse(Day2);
		long HM;
		if (dt2.getTime() > dt1.getTime()) // 判断得到的两个日期的毫秒数大小
		{
			HM = dt2.getTime() - dt1.getTime(); // 得到两个日期的毫秒差
		} else {
			HM = dt1.getTime() - dt2.getTime();
		}
		HM = (long) (HM / (1000 * 60 * 60 * 24)) + 1;
		return HM;
	}

	/**
	 * @param String
	 * @throws ParseException
	 * return 计算全年天数(平年闰年)
	 */
	public static int getAllYearDays(int year) {
		int days = 0;
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			days = 366;
		} else {
			days = 365;
		}
		return days;
	}
	
	/**
	 * 格式化日期
	 * 
	 * @param date
	 *            日期对象
	 * @return String 日期字符串
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat f = new SimpleDateFormat(DEFAULT_FORMAT);
		String sDate = f.format(date);
		return sDate;
	}

	/**
	 * 获取当年的第一天
	 * 
	 * @param year
	 * @return
	 */
	public static Date getCurrYearFirst() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearFirst(currentYear);
	}

	/**
	 * 获取当年的最后一天
	 * 
	 * @param year
	 * @return
	 */
	public static Date getCurrYearLast() {
		Calendar currCal = Calendar.getInstance();
		int currentYear = currCal.get(Calendar.YEAR);
		return getYearLast(currentYear);
	}

	/**
	 * 获取某年第一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getYearFirst(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		Date currYearFirst = calendar.getTime();
		return currYearFirst;
	}

	/**
	 * 获取某年最后一天日期
	 * 
	 * @param year
	 *            年份
	 * @return Date
	 */
	public static Date getYearLast(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.roll(Calendar.DAY_OF_YEAR, -1);
		Date currYearLast = calendar.getTime();
		return currYearLast;
	}

	/***
	 * 判断参数日期格式是否正确
	 * 
	 * @param 字符串日期
	 * @return
	 */
	public static boolean dateValid(String date) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			formatter.parse(date);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/***
	 * 获取距离今天i天后、前的日期
	 * @param i
	 * @return
	 */
	public static String getDataLate(int i) {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, i);// 把日期往前减少一天，若想把日期向后推一天则将负数改为正数
		date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}

	
	/*public static void main(String[] args) {
		System.out.println(DateUtil.DateToDay());
		System.out.println(DateUtil.DateToMonth());
		System.out.println(DateUtil.DateToYear());
	}*/
	
}

