package com.ypeb;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.ypeb.dataClass.front.TradeK;
import com.ypeb.model.trade.pointsTrade.Pointtrade;
import com.ypeb.model.trade.pointsTrade.PointtradeDAO;


public class Test {

	public static void main(String[] args) {
		
		//PointtradeDAO dao = new PointtradeDAO();
//		Date currentDate=new Date();
//		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		GregorianCalendar cal = new GregorianCalendar();  
//			cal.setTime(currentDate);
//		//int sysDate = cal.get(GregorianCalendar.DAY_OF_MONTH);
//		//System.out.println(Calendar.DAY_OF_MONTH);
//		Calendar calendar = Calendar.getInstance();  
//		//calendar.set(Calendar.DAY_OF_MONTH, sysDate);
//
//		calendar.set(Calendar.HOUR_OF_DAY, 0);
//		calendar.set(Calendar.MINUTE, 0);
//		calendar.set(Calendar.SECOND, 0);
//		Date start = calendar.getTime(); 
//		//calendar.set(Calendar.DAY_OF_MONTH, sysDate);
//		calendar.set(Calendar.HOUR_OF_DAY, 23);
//		calendar.set(Calendar.MINUTE, 59);
//		calendar.set(Calendar.SECOND, 59);
//		Date end = calendar.getTime();
//		
//		for(int currentDateDay=1; currentDateDay<new Date().getDate(); currentDateDay++){
//
//			start.setDate(currentDateDay);
//
//			end.setDate(currentDateDay);
//	
//
//			
//		}
	
		
		
		List<TradeK> tradeKList=new ArrayList();
		Calendar calendar = Calendar.getInstance();  
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date start = calendar.getTime(); 
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date end = calendar.getTime();
		
		for(int currentDateDay=1; currentDateDay<new Date().getDate(); currentDateDay++){
			start.setDate(currentDateDay);
			end.setDate(currentDateDay);
			TradeK tradeK = new TradeK();
			tradeK.calcuMonthK(start, end);
			tradeKList.add(tradeK);
		}
		System.out.println(tradeKList.get(0).getMinTrade());
		System.out.println(tradeKList.size());

	}
	
}
