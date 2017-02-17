package com.ypeb.util;

import java.util.Date;
import java.util.GregorianCalendar;

public class ReleaseDateUtil {
	
    public  int getTime(Date releaseDate, int times, int setTime) { 
    		//times 已经返次数/月
    	GregorianCalendar cal = new GregorianCalendar();  
        	cal.setTime(releaseDate);  
        GregorianCalendar time=new GregorianCalendar();
    	int timeYear = time.get(GregorianCalendar.YEAR);
    	int timeMonth = time.get(GregorianCalendar.MONTH+1);
    	int timeDay = time.get(GregorianCalendar.DAY_OF_MONTH);
    	
    	int releaseDateYear = cal.get(GregorianCalendar.YEAR);
    	int releaseDateMonth = cal.get(GregorianCalendar.MONTH+1);
    	int releaseDateDay = cal.get(GregorianCalendar.DAY_OF_MONTH);
    	
    	int year = releaseDateYear-timeYear;
    	int month = Math.abs(timeMonth-releaseDateMonth);
    	int day = timeDay-releaseDateDay;
    	
    	int yMouth = timeMonth+12*year-releaseDateMonth;
    	
    	if(year==0 && month>setTime){
    		int yoTimes = setTime - times;
    		return yoTimes;
    	}else if(year==0 && month<=setTime && day>=0){
    		int ytTimes = month - times;
    		return ytTimes;
    	}else if(year==0 && month==setTime && day<0){
    		int ysTime = month-1-times;
    		return ysTime;
    	}else if(year>0 && yMouth>setTime){
    		int yoMouthTimes = setTime-times;
    		return yoMouthTimes;
    	}else if(year>0 && yMouth<=setTime && day>=0){
    		int ytMouthTimes = yMouth-times;
    		return ytMouthTimes;
    	}else if(year>0 && yMouth==setTime && day<0){
    		int ysMouthTimes = setTime-1-times;
    		return ysMouthTimes;
    	}else{
    		return 0;
    	}
        
    }    

}
