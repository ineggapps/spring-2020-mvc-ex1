package com.sp.hr;

import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service("hr.hrService")
public class HrServiceImpl implements HrService{

	// 띠, 나이, 세금, 실급여
	private final static String zodiac[] = { "원숭이", "닭", "개", "돼지", "쥐", "소", "범", "토끼", "용", "뱀", "말", "양" };
	
	public int getYear(String birth) {
		String str = birth.replaceAll("-", "");
		return  Integer.parseInt(str.substring(0,4));
	}
	
	public int getMonth(String birth) {
		String str = birth.replaceAll("-", "");
		return Integer.parseInt(str.substring(4,6));
	}
	
	public int getDay(String birth) {
		String str = birth.replaceAll("-", "");
		return Integer.parseInt(str.substring(6));
	}
	
	public String calcZodiac(String birth) {
		return zodiac[getYear(birth)%zodiac.length]+"띠";
	}

	public int calcAge(String birth) {
		Calendar now = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		//생일 대입
		cal.set(getYear(birth),getMonth(birth)-1,getDay(birth));
		
		//만 나이 계산하기
		int age = (now.get(Calendar.YEAR)-cal.get(Calendar.YEAR));
		if(cal.get(Calendar.MONTH)>now.get(Calendar.MONTH) || 
				cal.get(Calendar.DATE) > now.get(Calendar.DATE)) {
			age--;
		}
		return age;
	}

	public double calcTax(int salary, int bonus) {
		int sum = salary + bonus;
		if (sum >= 3000000) {
			return sum * 0.03;
		} else if (sum >= 200000) {
			return sum * 0.02;
		} else {
			return 0;
		}
	}
	
	public double calcActualWage(int salary, int bonus, double tax) {
		return (salary + bonus) - tax;
	}
	
	@Override
	public Human calcAutomatically(Human dto) {
		dto.setZodiac(calcZodiac(dto.getBirth()));
		dto.setAge(calcAge(dto.getBirth()));
		dto.setTax(calcTax(dto.getSalary(), dto.getBonus()));
		dto.setActualWage(calcActualWage(dto.getSalary(), dto.getBonus(), dto.getTax()));
		return dto;
	}

}
