package com.eko.utils;

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

/**
 * ��������ʱ�䴦��Ĺ�����
 *
 */
public final class TimeUtil {
	private TimeUtil() {

	}
	
	/**
	 * ȡ�õ�ǰ����ʱ��
	 */
	public static String getShortCurrDateTime() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		return formatter.format(date);
	}
	
	/**
	 * ȡ�õ�ǰ����ʱ��
	 */
	public static String getCurrDateTime() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

	public static Date stringToDate(String dateStr){
		DateFormat formatter = new SimpleDateFormat("YY-MM-dd");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Date stringToFullDate(String dateStr){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Date stringToDateOne(String dateStr){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Date stringToDateTwo(String dateStr){
		DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Date stringToDateThr(String dateStr){
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
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
	/**
	 * ȡ�õ�ǰ����
	 */
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
	
	
	/**
	 * ȡ�õ�ǰ���+�·�
	 */
	public static String getCurrentYearMonth() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM");
		return formatter.format(date);
	}
	
	/**
	 * ȡ�õ�ǰ����
	 */
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
	/**
	 * ȡ�õ�ǰʱ��
	 */
	public static String getCurrTime() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("HH-mm-ss");
		return formatter.format(date);
	}

	/**
	 * ȡ�õ�ǰ����
	 */
	public static String getCurrMonth() {
		Date date = new Date();
		Format formatter = new SimpleDateFormat("yyyy-MM");
		return formatter.format(date);
	}

	/**
	 * �����µĻ��ϼ��ϻ��ȥ�·ݵõ�������
	 */
	@SuppressWarnings("deprecation")
	public static String getChangedDate(String strMonth,int monthCount) {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM");

		try {
			java.util.Date date = myFormatter.parse(strMonth);
			date.setMonth(date.getMonth()+monthCount);
						
			Format formatter = new SimpleDateFormat("yyyy-MM");
			return formatter.format(date);
		} catch (Exception ex) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
//		    //long days = diff / (1000 * 60 * 60 * 24);
//		    SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		  //前面的lSysTime是秒数，先乘1000得到毫秒数，再转为java.util.Date类型
//		  Date dt = new Date(diff); 
//		  Date dt2 = new Date(d1.getTime()); 
//		  String sDateTime = sdf.format(dt); 
//		  String sDateTime2 = sdf.format(dt2);//得到精确到秒的表示：08/31/2006 21:08:00
//		  System.out.println(sDateTime);
//		  System.out.println(sDateTime2);
		   
		   // System.out.print(d1.getTime());
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
	public static Long convDateToLong(String nowdatetime){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 final TimeZone tz = TimeZone.getTimeZone("GMT+0");
		  sdf.setTimeZone(tz);
	     try {
			Date d1 = sdf.parse(nowdatetime);
			long diff = d1.getTime();
			return diff;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
	/**
	 * ȡ��һ�������ж�����
	 * 
	 * @param strMonth
	 * @return
	 */
	public static int getDaysInAMonth(String strMonth) {
		String[] arr=strMonth.split("[-]");
		Calendar cal = new GregorianCalendar(Integer.parseInt(arr[0]),Integer.parseInt(arr[1])-1, 1);
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH); 
		return days;
	}
	
	/**
	 * ȡ��ÿ���µĵ�һ�����ܼ�
	 * @param strMonth
	 * @return
	 */
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
	/**
	 * 取得两个日期之间的天数
	 * 
	 * @param date
	 * @throws ParseException 
	 * @resin-ejb
	 * @return String
	 */
	
	  public static String getDateDiff(String startDay, String endDay) {
	        long diff = 0;
	        try {
	            Date date1 = new SimpleDateFormat("yyyyMMdd").parse(startDay); 
	            Date date2 = new SimpleDateFormat("yyyyMMdd").parse(endDay); 

	            diff = (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000) > 0 ? (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000) : (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000); 
	        } catch (ParseException e) {
	        }
	        return Long.toString(diff);
	    }
	  /**
		 * 取得两个日期之间的日期
		 * 
		 * @param String
		 * @throws ParseException 
		 * @return GregorianCalendar[]
		 */
	  public static GregorianCalendar[]  getBetweenDate(String d1,String d2) throws ParseException  
	    {  
	        Vector<GregorianCalendar> v=new Vector<GregorianCalendar>();  
	        SimpleDateFormat  sdf=new SimpleDateFormat("yyyy-MM-dd");  
	        GregorianCalendar gc1=new GregorianCalendar(),gc2=new GregorianCalendar();  
	        gc1.setTime(sdf.parse(d1));  
	        gc2.setTime(sdf.parse(d2));  
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
		  try {
			  GregorianCalendar[] a=getBetweenDate(d1,d2);
			  List<String> dateStr = new ArrayList<String>();
			for(int i=0;i<a.length;i++){
				dateStr.add(getVOSDate(a[i].getTime()));
			}
			return dateStr;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	  }
	  public static List<String> getBetweenMonthStr(String d1,String d2){
		  try {
			  GregorianCalendar[] a=getBetweenMonth(d1,d2);
			  List<String> dateStr = new ArrayList<String>();
			for(int i=0;i<a.length;i++){
				dateStr.add(getYearMonth(a[i].getTime()));
			}
			return dateStr;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	  }
	  public static List<String> getBetweenDateStrWithTimeZone(String d1,String d2,String segTimezone){
		  try {
			  d1= TimeUtil.convLtoStrForTimezone(d1,segTimezone);
			  d2 = TimeUtil.convLtoStrForTimezone(d2,segTimezone);
			  GregorianCalendar[] a=getBetweenDate(d1,d2);
			  List<String> dateStr = new ArrayList<String>();
			for(int i=0;i<a.length;i++){
				dateStr.add(getVOSDate(a[i].getTime()));
			}
			return dateStr;
		} catch (ParseException e) {
			 
			e.printStackTrace();
		}
		return null;
	  }
	  public static Integer getBetweenDateNum(String d1,String d2){
		  try {
			  GregorianCalendar[] a=getBetweenDate(d1,d2);
			  return a.length;
			  
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	  }
	 
	  public static void main(String[] args) throws ParseException{
//		  try {
//			  GregorianCalendar[] a=getBetweenDate("2012年10月05日","2012年10月25日");
//			for(int i=0;i<a.length;i++){
//				System.out.println(getCurrDate(a[i].getTime()));
//			}
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		  //System.out.println(getDateJiaJian("2012-01-16",20));
		  
		  //String  value=TimeUtil.getDateYMD(TimeUtil.stringToDateTwo("1/7/12"));
		 // System.out.println(value);
		  //stringToDate("2012-11-25");
		//Date date =   stringToDateTwo("25-11-2012");
		 //String  s =  getDateYMD(TimeUtil.stringToDateTwo("12-28-12"));
//		//Date date2 =  stringToDate("2012-11-25");
//	  SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
//      String str="20110823";
//      Date dt=sdf.parse(str);
//      Calendar rightNow = Calendar.getInstance();
//      rightNow.setTime(dt);
//      //rightNow.add(Calendar.YEAR,-1);//日期减1年
//      //rightNow.add(Calendar.MONTH,3);//日期加3个月
//      rightNow.add(Calendar.DAY_OF_YEAR,10);//日期加10天
//      Date dt1=rightNow.getTime();
//      String reStr = sdf.format(dt1);
//      System.out.println(reStr);
		 //System.out.println(s);
		// System.out.println("1111");
		//System.out.println(date2);
//		  try {
//			  List<String> ss = getBetweenDateStr("20130405","20130425");
//			  for(String temp:ss){ 
//				  System.out.println("e_cdr_"+temp);
//			  }
//		   
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		  int a=20*60*1000;
//		 System.out.print(a);							
//		  short pdd = (short)(1476331171 & 0xFFFF);
//		double s =  pdd > 30000 ? (pdd - 30000.0) : pdd / 1000.0;
//		System.out.println(  s);
//		  System.out.println(  convLtoStrDate(Long.parseLong("1412121600000")));
//		 System.out.println(  convLtoStrDate(Long.parseLong("1412538413000")));
 
 		//System.out.println( convLtoStrZero(Long.parseLong( "1324378227000")));
//		System.out.println( convLtoStrZero(Long.parseLong("1414454412771")));
		System.out.println( convLtoStrZero(Long.parseLong("1431648000000")));
		System.out.println( convLtoStrZero(Long.parseLong("1431619200000")));
//		  
		  
//		System.out.println(convDStrToLStr("2015-02-28 11:00:00","GMT-8"));
//		System.out.println(convDStrToLStr("2015-02-28 12:00:00","GMT-8"));
//		System.out.println(convDStrToL("2015-05-15 00:00:00"));
//		System.out.println(convDStrToL("2015-05-15 09:00:00"));
//		
//		System.out.println(convLtoStrForTimezoneCdr(convDStrToL("2015-02-27 01:00:00"),"GMT+0"));
//		System.out.println(convLtoStrForTimezoneCdr(convDStrToL("2015-02-27 02:00:00"),"GMT+0"));
////		
//		   System.out.println(convDStrToL("2014-09-25 14:04:37"));
		 // System.out.println(  convLtoStrForTimezone(convDStrToL(convDStrToLStr("2014-05-20 07:00:00","GMT+0")),"GMT-8") );
		 //System.out.println(  getMinuteJiaJian("2014-05-20 07:05:00" ,5) );
//		  List<String> list = getBetweenDateStr("2015-01-01 00:00:00","2015-02-28 23:59:59");
//		  for(int i=0;i<list.size();i++){
//			  System.out.println(" select * into outfile '/var/tmp/241"+list.get(i)+".txt' fields terminated by ',' from ( select calleee164 from e_cdr_" + list.get(i) +" where holdtime >= 120 and calleee164 like '53%' group by calleee164 ) aa; ");
//		  }
		//1411655134000
		  //System.out.println(  convDStrToLStr("2014-09-25 14:25:34")) ;
		//  System.out.println(  convDStrToLStr("2014-06-02 24:00:00")) ;
//			String theNowDateTime = TimeUtil.getCurrDateTime();
//			long theStartTime =  TimeUtil.delaytime(theNowDateTime, 1200000);
//			long theEndTime = TimeUtil.convDStrToL(theNowDateTime);
			//System.out.println(convLtoStr(  delaytime("2013-08-27 08:00:12.752",Long.parseLong("3600000"))));
	   }

 
}