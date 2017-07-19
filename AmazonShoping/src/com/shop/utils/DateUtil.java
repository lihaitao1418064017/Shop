package com.shop.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.print.CancelablePrintJob;

public class DateUtil
{

	// �ж����������Ƿ������ն���ͬ
	public static boolean isSameYearMonthDay(Calendar date1, Calendar date2)
	{
		if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR) && date1.get(Calendar.MONTH) == date2.get(Calendar.MONTH) && date1.get(Calendar.DAY_OF_MONTH) == date2.get(Calendar.DAY_OF_MONTH))
			return true;
		else
			return false;
	}

	// �ж����������Ƿ������ն���ͬ
	public static boolean isSameYearMonthDay(Date date1, Date date2)
	{
		return isSameYearMonthDay(toCalendar(date1), toCalendar(date2));
	}

	public static Date toDate(Calendar calendar)
	{
		if (calendar == null)
			return null;
		return calendar.getTime();
	}

	public static Calendar toCalendar(Date date)
	{
		if (date == null)
			return null;
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	public static Calendar toCalendar(String date)
	{
		try
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar formDate = Calendar.getInstance();
			formDate.setTime(dateFormat.parse(date));
			return formDate;
		} catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}


	// ��2016-02-25�������ַ���ת��������
	public static Timestamp toTimestamp(String date)
	{
		if (null == date || "".equals(date))
			return null;
		try
		{
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Calendar formDate = Calendar.getInstance();
			formDate.setTime(dateFormat.parse(date));
			// System.out.println("date:" + formDate);
			Timestamp timestamp = new Timestamp(formDate.getTimeInMillis());
			return timestamp;
		} catch (Exception e)
		{
			throw new RuntimeException("ת���ַ��������ڳ���" + e.getMessage());
		}

	}

	// �жϸ������ڵ�ǰ�Ƿ��Ѿ����ڣ��ѹ��ڷ���true
	public static boolean hasExpiredToday(Date date)
	{
		Calendar expireDate = toCalendar(date);
		Calendar today = toCalendar(new Date());
		if (isSameYearMonthDay(expireDate, today))// ���������������ͬһ��
			return false;
		if (today.compareTo(expireDate) < 0)// ���컹δ����������
			return false;
		else
			return true;
	}

	public static String toYYYYMMDD(Calendar date)
	{
		String result = "";
		result += date.get(Calendar.YEAR) + "-";
		int month = date.get(Calendar.MONTH) + 1;
		result += String.format("%02d", month) + "-";
		int day = date.get(Calendar.DAY_OF_MONTH);
		result += String.format("%02d", day);
		return result;
	}

	public static String toYYYYMMDD(Date date)
	{
		Calendar calendar = toCalendar(date);
		return toYYYYMMDD(calendar);
	}

	public static String genLogTime()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		int millSecond = calendar.get(Calendar.MILLISECOND);
		String result = "";
		result += "(" + hour + "��" + minute + "��" + second + "��" + millSecond + "����)";
		return result;
	}

	// ���ɸ����̱߳�ż���ǰʱ�䴮
	public static String genLogTime(int threadNumber)
	{
		return "�߳�" + threadNumber + genLogTime();
	}

	public static String genLogDate()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		String result = "";
		result += "(" + year + "��" + month + "��" + day + "��)";
		return result;
	}

}
