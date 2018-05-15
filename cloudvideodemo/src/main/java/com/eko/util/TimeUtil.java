/**
* ===============================================================================
*
* IBM Confidential
* 
* OCO Source Materials
*
* 5747-SM3
*
* (C) Copyright IBM Corp. 2015, 2016 All Rights Reserved.
*
* The source code for this program is not published or otherwise divested 
* of its trade secrets, irrespective of what has been deposited with 
* the U.S. Copyright office .
* 
* ===============================================================================
*/   
package com.eko.util;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.Vector;

 
public final class TimeUtil {
	//private static Log //logger = LogFactoryUtil.getLog(TimeUtil.class);
	private TimeUtil() {

	}
	
	 
	public static String getShortCurrDateTime() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(date);
	}
	public static String getAllShortCurrDateTime() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return formatter.format(date);
	}
	 
	public static String getCurrDateTime() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}
	public static String getCurrDateTimeSSS() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		return formatter.format(date);
	}
	public static Date stringToDate(String dateStr){
		DateFormat formatter = new SimpleDateFormat("YY-MM-dd");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			//logger.info("TimeUtil stringToDate"+e);
			return null;
		}
	}
	
	public static Date stringToFullDate(String dateStr){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			//logger.info("TimeUtil stringToFullDate"+e);
			return null;
		}
	}
	public static Date stringToDateNoSec(String dateStr){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			//logger.info("TimeUtil stringToFullDate"+e);
			return null;
		}
	}
 
	public static Date stringToDateOne(String dateStr){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			//logger.info("TimeUtil stringToDateOne"+e);
			return null;
		}
	}
	public static Date getYMDDate(){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatter.format(new Date());
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			//logger.info("TimeUtil getYMDDate"+e);
			return null;
		}
	}
	public static Date stringToDateTwo(String dateStr){
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			//logger.info("TimeUtil stringToDateTwo"+e);
			return null;
		}
	}
	public static Date stringToDateYMDHM(String dateStr){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			//logger.info("TimeUtil stringToDateTwo"+e);
			return null;
		}
	}
	public static Date stringToDateThr(String dateStr){
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			//logger.info("TimeUtil stringToDateThr"+e);
			return null;
		}
	}
	public static String getDateYMD(Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	public static String getDateYMDDHS(Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}
	public static String getDateYMDSec(Date date) {
		Format formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(date);
	}
	public static String getDateYMDHM(Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return formatter.format(date);
	}
	public static Date getDateTypeYMDHM(Date date) {
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			return formatter.parse(getDateYMDHM(date));
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static String getCurrentDate() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	
	public static String getTodayDate() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(date);
	}
	 
	public static String getCurrentYearMonth() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM");
		return formatter.format(date);
	}
 
	public static String getCurrDate() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	
	public static String getCurrDate(Date date) {
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}
	public static String getVOSDate(Date date) {
		Format formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(date);
	}
	public static String getNowDate(Date date) {
		Format formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(date);
	}
	public static String getNowDate() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(date);
	}
	public static String getYearMonth(Date date) {
	 
		Format formatter = new SimpleDateFormat("yyyyMM");
		return formatter.format(date);
	}
 
	public static String getCurrTime() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("HH-mm-ss");
		return formatter.format(date);
	}

	 
	public static String getCurrMonth() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM");
		return formatter.format(date);
	}

	 
	@SuppressWarnings("deprecation")
	public static String getChangedDate(String strMonth,int monthCount) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM");

		try {
			java.util.Date date = myFormatter.parse(strMonth);
			date.setMonth(date.getMonth()+monthCount);
						
			Format formatter = new SimpleDateFormat("yyyy-MM");
			return formatter.format(date);
		} catch (Exception e) {
			//logger.info("TimeUtil getChangedDate"+e);
			return null;
		}
	}
	public static Long convDStrToL(String nowdatetime){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 final TimeZone tz = TimeZone.getTimeZone("GMT+0");
		  sdf.setTimeZone(tz);
	     try {
			Date d1 = sdf.parse(nowdatetime);
			long diff = d1.getTime();
			return diff;
		} catch (ParseException e) {
			//logger.info("TimeUtil convDStrToL"+e);
			return null;
		}
	}
	public static String convDStrToLStr(String nowdatetime,String timezoneStr){
		 
			return convLtoStrForTimezone(nowdatetime,timezoneStr);
		 
	}
	public static String convDStrToLStr(String nowdatetime){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 final TimeZone tz = TimeZone.getTimeZone("GMT+0");
		  sdf.setTimeZone(tz);
	     try {
			Date d1 = sdf.parse(nowdatetime);
			long diff = d1.getTime();
			return String.valueOf(diff);
		} catch (ParseException e) {
			//logger.info("TimeUtil convDStrToLStr"+e);
			return null;
		}
	}
	public static String convDStrToLStrSSS(String nowdatetime){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		 final TimeZone tz = TimeZone.getTimeZone("GMT+0");
		  sdf.setTimeZone(tz);
	     try {
			Date d1 = sdf.parse(nowdatetime);
			long diff = d1.getTime();
			return String.valueOf(diff);
		} catch (ParseException e) {
			//logger.info("TimeUtil convDStrToLStr"+e);
			return null;
		}
	}
	public static long delaytime(String nowdatetime,long switchTime){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
		     try {
				Date d1 = df.parse(nowdatetime);
				long diff = d1.getTime() - switchTime;
				return diff;
			} catch (ParseException e) {
				//logger.info("TimeUtil delaytime"+e);
				return 0;
			}
 
	}
	
	public static String convLtoStrZero(long thelongdatetime){
	  SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	  final TimeZone tz = TimeZone.getTimeZone("GMT+0");
	  sdf.setTimeZone(tz);
	  Date dt = new Date(thelongdatetime); 
	  return sdf.format(dt);
	}
	
	public static Date getZeroDateTime(){
		  SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		  final TimeZone tz = TimeZone.getTimeZone("GMT+0");
		  sdf.setTimeZone(tz);
		  Date dt = new Date(); 
		  return stringToFullDate(sdf.format(dt));
		}
	public static String convLtoStrDate(long thelongdatetime){
		  SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	 
		  Date dt = new Date(thelongdatetime); 
		  return sdf.format(dt);
		}
	public static String convLtoStrForTimezone(String thelongdatetime,String timezone){
		  
			SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
			  final TimeZone tz = TimeZone.getTimeZone(timezone);
			  sdf.setTimeZone(tz);
			  Date dt = new Date(convDateToLong(thelongdatetime)); 
			  return sdf.format(dt);
		 
		  
		}
	public static String convLtoStrForTimezoneCdr(long thelongdatetime,String timezone){
		  
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
		  final TimeZone tz = TimeZone.getTimeZone(timezone);
		  sdf.setTimeZone(tz);
		  Date dt = new Date(thelongdatetime); 
		  return sdf.format(dt);
	 
	  
	}
	public static Long convDateToZeroLong(String nowdatetime){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 final TimeZone tz = TimeZone.getTimeZone("GMT+0");
		  sdf.setTimeZone(tz);
	     try {
			Date d1 = sdf.parse(nowdatetime);
			long diff = d1.getTime();
			return diff;
		} catch (ParseException e) {
			//logger.info("TimeUtil convDateToLong"+e);
			return null;
		}
	}
	public static Long convDateToLong(String nowdatetime){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	     try {
			Date d1 = sdf.parse(nowdatetime);
			long diff = d1.getTime();
			return diff;
		} catch (ParseException e) {
			//logger.info("TimeUtil convDateToLong"+e);
			return null;
		}
	}
	public static String convLtoStrZeroNoDate(long thelongdatetime){
	 
			 SimpleDateFormat sdf= new SimpleDateFormat("HH:mm:ss.SSS");
			  final TimeZone tz = TimeZone.getTimeZone("GMT+0");
			  sdf.setTimeZone(tz);
			  Date dt = new Date(thelongdatetime); 
			  return sdf.format(dt);
		 
		 
		}
	public static String convLtoStrEight(long thelongdatetime){
		  SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		  Date dt = new Date(thelongdatetime); 
		  return sdf.format(dt);
	}
 
	public static int getDaysInAMonth(String strMonth) {
		String[] arr=strMonth.split("[-]");
		Calendar cal = new GregorianCalendar(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])-1, 1);
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
		return days;
	}
	
	 
	public static int getWeekOfFirstDay(String strMonth){
		String[] arr=strMonth.split("[-]");
		
		Calendar xmas = new GregorianCalendar(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])-1, 1);
	    int dayOfWeek = xmas.get(Calendar.DAY_OF_WEEK)-1;    
	    return dayOfWeek;
	}
	public static String getYesterday(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		return new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
		 
	}
 
	  public static String getDateDiff(String startDay, String endDay) {
	        long diff = 0;
	        try {
	            Date date1 = new SimpleDateFormat("yyyyMMdd").parse(startDay); 
	            Date date2 = new SimpleDateFormat("yyyyMMdd").parse(endDay); 

	            diff = (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000) > 0 ? (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000) : (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000); 
	        } catch (ParseException e) {
	        	//logger.info("TimeUtil getDateDiff"+e);
	        }
	        return Long.toString(diff);
	    }
 
	  public static GregorianCalendar[]  getBetweenDate(String d1,String d2) throws ParseException  
	    {  
	        Vector<GregorianCalendar> v=new Vector<GregorianCalendar>();  
	        SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        GregorianCalendar gc1=new GregorianCalendar(),gc2=new GregorianCalendar();  
	        gc1.setTime(sdf.parse(d1));  
	        gc2.setTime(sdf.parse(d2)); 
	        if(!d1.equals(d2))
	        {
	        do{  
	            GregorianCalendar gc3=(GregorianCalendar)gc1.clone();  
	            v.add(gc3);  
	            gc1.add(Calendar.DAY_OF_MONTH, 1);               
	         }while(!gc1.after(gc2)); 
	        }
	        return v.toArray(new GregorianCalendar[v.size()]);  
	    } 
	  public static GregorianCalendar[]  getBetweenDateTime(String d1,String d2) throws ParseException  
	    {  
	        Vector<GregorianCalendar> v=new Vector<GregorianCalendar>();  
	        SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");  
	        GregorianCalendar gc1=new GregorianCalendar(),gc2=new GregorianCalendar();  
	        gc1.setTime(sdf.parse(d1));  
	        gc2.setTime(sdf.parse(d2)); 
	        if(!d1.equals(d2))
	        {
	        do{  
	            GregorianCalendar gc3=(GregorianCalendar)gc1.clone();  
	            v.add(gc3);  
	            gc1.add(Calendar.DAY_OF_MONTH, 1);               
	         }while(!gc1.after(gc2)); 
	        }
	        return v.toArray(new GregorianCalendar[v.size()]);  
	    } 
	  public static GregorianCalendar[]  getBetweenDateWithTimestamp(Date d1,Date d2) throws ParseException  
	    {  
	        Vector<GregorianCalendar> v=new Vector<GregorianCalendar>();  
	       
	        GregorianCalendar gc1=new GregorianCalendar(),gc2=new GregorianCalendar();  
	        gc1.setTime(d1);  
	        gc2.setTime(d2);  
	        do{  
	            GregorianCalendar gc3=(GregorianCalendar)gc1.clone();  
	            v.add(gc3);  
	            gc1.add(Calendar.DAY_OF_MONTH, 1);               
	         }while(!gc1.after(gc2));  
	        return v.toArray(new GregorianCalendar[v.size()]);  
	    } 
	  public static GregorianCalendar[]  getBetweenMonth(String d1,String d2) throws ParseException  
	    {  
	        Vector<GregorianCalendar> v=new Vector<GregorianCalendar>();  
	        SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM");  
	        GregorianCalendar gc1=new GregorianCalendar(),gc2=new GregorianCalendar();  
	        gc1.setTime(sdf.parse(d1));  
	        gc2.setTime(sdf.parse(d2));  
	        do{  
	            GregorianCalendar gc3=(GregorianCalendar)gc1.clone();  
	            v.add(gc3);  
	            gc1.add(Calendar.MONTH, 1);               
	         }while(!gc1.after(gc2));  
	        return v.toArray(new GregorianCalendar[v.size()]);  
	    } 
	  
	  public static List<String> getBetweenDateStr(String d1,String d2){
		  List<String> dateStr = new ArrayList<String>();
		  try {
			  GregorianCalendar[] a=getBetweenDate(d1,d2);
			 
			for(int i=0;i<a.length;i++){
				dateStr.add(getVOSDate(a[i].getTime()));
			}
			return dateStr;
		} catch (ParseException e) {
			//logger.info("TimeUtil getBetweenDateStr"+e);
		}
		return dateStr;
	  }
	 
	  public static List<String> getBetweenMonthStr(String d1,String d2){
		  List<String> dateStr = new ArrayList<String>();
		  try {
			  GregorianCalendar[] a=getBetweenMonth(d1,d2);
			 
			for(int i=0;i<a.length;i++){
				dateStr.add(getYearMonth(a[i].getTime()));
			}
			return dateStr;
		} catch (ParseException e) {
			//logger.info("TimeUtil getBetweenMonthStr"+e);
		}
		return dateStr;
	  }
	  public static List<String> getBetweenDateStrWithTimeZone(String d1,String d2,String segTimezone){
		  List<String> dateStr = new ArrayList<String>();
		  try {
			String d11= TimeUtil.convLtoStrForTimezone(d1,segTimezone);
			String d22 = TimeUtil.convLtoStrForTimezone(d2,segTimezone);
			  GregorianCalendar[] a=getBetweenDate(d11,d22);
			
			for(int i=0;i<a.length;i++){
				dateStr.add(getVOSDate(a[i].getTime()));
			}
			return dateStr;
		} catch (ParseException e) {
			//logger.info("TimeUtil getBetweenDateStrWithTimeZone"+e);
		}
		return dateStr;
	  }
	  public static Integer getBetweenDateNum(String d1,String d2){
		  try {
			  GregorianCalendar[] a=getBetweenDate(d1,d2);
			  return a.length;
			  
		} catch (ParseException e) {
			//logger.info("TimeUtil getBetweenDateNum"+e);
		}
		return null;
	  }
	  public static boolean compare_date(String date1, Date date2) {
	       
	        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	        try {
	            Date dt1 = df.parse(date1);
	          
	            if (dt1.getTime() > date2.getTime()) {
	                
	                return true;
	            } 
	            if (dt1.getTime() < date2.getTime()) {
	                
	                return false;
	            }  
	        } catch (Exception e) {
	        	
	        	//logger.info("TimeUtil compare_date"+e);
	        	
	        }
	        return false;
	    }
	  public static String getDateJiaJian(String dateStr,Integer addDay){
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	 
	       
		try {
			Date dt = sdf.parse(dateStr);
			  Calendar calendar=Calendar.getInstance();  
			  calendar.setTime(dt);
			  calendar.add(Calendar.DAY_OF_YEAR,addDay);
			  Date thedate = calendar.getTime();
			  String thedateStr = sdf.format(thedate);
			  return thedateStr;
		} catch (ParseException e) {
			//logger.info("TimeUtil getDateJiaJian"+e);
		}
		return null;
	  }
	  public static String getMinuteJiaJian(String dateStr,Integer addMinute){
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
	       
		try {
			Date dt = sdf.parse(dateStr);
			  Calendar calendar=Calendar.getInstance();  
			  calendar.setTime(dt);
			  calendar.add(Calendar.MINUTE,addMinute);
			  Date thedate = calendar.getTime();
			  String thedateStr = sdf.format(thedate);
			  return thedateStr;
		} catch (ParseException e) {
			//logger.info("TimeUtil getMinuteJiaJian"+e);
		}
		return null;
	  }
	  public static String getDayjiaJian(String dateStr,Integer changeDay){
		  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	 
	       
		try {
			Date dt = sdf.parse(dateStr);
			  Calendar calendar=Calendar.getInstance();  
			  calendar.setTime(dt);
			  calendar.add(Calendar.DATE,changeDay-1);
			  Date thedate = calendar.getTime();
			  String thedateStr = sdf.format(thedate);
			  return thedateStr;
		} catch (ParseException e) {
			//logger.info("TimeUtil getDayjiaJian"+e);
		}
		return null;
	  }
		public static String convLtoDateStr(long thelongdatetime){
			  SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm");
			  Date dt = new Date(thelongdatetime); 
			  return sdf.format(dt);
			}
		public static String getLiferayDisDateString(Date dateStr,int timeOffset) {
			 
				Calendar now=Calendar.getInstance();
				   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				now.setTime(dateStr);
				now.add(Calendar.HOUR, +timeOffset);
				Date date = now.getTime();
				return sdf.format(date);
			 
			 
	   }
		public static String getLiferayExpDateString(Date dateStr,int timeOffset) {
			 
			Calendar now=Calendar.getInstance();
			   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			now.setTime(dateStr);
			now.add(Calendar.MINUTE, +2);
			now.add(Calendar.HOUR, +timeOffset);
			Date date = now.getTime();
			return sdf.format(date);
		 
		 
		}
		public static String getLiferayReviewDateString(Date dateStr,int timeOffset) {
			 
			Calendar now=Calendar.getInstance();
			   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			now.setTime(dateStr);
			now.add(Calendar.MINUTE, -5);
			now.add(Calendar.HOUR, +timeOffset);
			Date date = now.getTime();
			return sdf.format(date);
		 
		 
		}
		public static String getUserDateString(Date dateStr,int timeOffset) {
			 try {
				TimeZone tz = TimeZone.getTimeZone("GMT");
				Calendar now=Calendar.getInstance();
				   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				   sdf.setTimeZone(tz);
				   Date tempDate = sdf.parse(getDateYMDHM(dateStr));
				now.setTime(tempDate);
				now.add(Calendar.HOUR, +timeOffset);
				Date date = now.getTime();
				return sdf.format(date);
			} catch (ParseException e) {
				return null;
			}
		}
		public static void main(String[] args){
			System.out.println(convLtoDateStr(1498532308958L));
		}
}