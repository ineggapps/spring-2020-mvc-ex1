package com.sp.insa;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("insa.dateUtil")
public class DateUtilImpl implements DateUtil {
	@Override
	public boolean isDateFormatCheck(String strDate) {
		try {
			if (strDate.length() != 8 && strDate.length() != 10) {
				return false;
			}

			strDate = strDate.replaceAll("(\\-|\\.|/)", "");
			int year = Integer.parseInt(strDate.substring(0, 4));
			int month = Integer.parseInt(strDate.substring(4, 6));
			int day = Integer.parseInt(strDate.substring(6));
			
			if(month<1||month>12)
				return false;
			
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.YEAR, year);
			cal.set(Calendar.MONTH, month - 1);
			
			int lastDay=cal.getActualMaximum(Calendar.DATE);
			if(day<1||day>lastDay)
				return false;

		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public String toTti(String birth) {
		String s=null;
		
		try {
			if(! isDateFormatCheck(birth)) {
				throw new IllegalArgumentException("Invalid date format : " + birth);
			}
			
			// 1 (닭)  2(개)  3(돼지)  4(쥐)  5(소)  6(호랑이)  7(토끼 )  8(용)  9(뱀)  10(말)  11(양)  12(원숭이)
			String []tt={"원숭이", "닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
		
			int y=Integer.parseInt(birth.substring(0, 4));
		
			int idx=y%12;
		
			s =  tt[idx];
		}catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format : " + birth);
		}
		
		return s;
	}

	@Override
	public int toAge(String birth) {
		int n=-1;
		
		try {
			if(! isDateFormatCheck(birth)) {
				throw new IllegalArgumentException("Invalid date format : " + birth);
			}
			
			int y=Integer.parseInt(birth.substring(0, 4));
			int m=Integer.parseInt(birth.substring(4, 6));
			int d=Integer.parseInt(birth.substring(6));

			Calendar cal=Calendar.getInstance();
		    cal.set(Calendar.YEAR, y);
		    cal.set(Calendar.MONTH, m-1);
		    cal.set(Calendar.DATE, d);
		    
		    Calendar now = Calendar.getInstance ();
		    
		    n = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
		    if ( (cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
		            || (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH) 
		              && cal.get(Calendar.DAY_OF_MONTH) > now.get(Calendar.DAY_OF_MONTH))) {
		        n--;
		    }
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid date format : " + birth);
		}
		
		return n;
	}
}
