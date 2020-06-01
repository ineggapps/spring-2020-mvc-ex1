package com.sp.insa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("insa.insaService")
public class InsaServiceImpl implements InsaService {
	@Autowired
	private DateUtil util;
	
	@Override
	public void calculator(Insa dto) {
		int age = util.toAge(dto.getBirth());
		String tti = util.toTti(dto.getBirth());
		
		int totPay=dto.getPay()+dto.getSudang();
		int tax=0;
		if(totPay>=3000000) {
			tax=(int)(totPay*0.03);
		}else if(totPay>=2000000) {
			tax=(int)(totPay*0.02);
		} 
		int spay=totPay-tax;
		
		dto.setAge(age);
		dto.setTti(tti);
		dto.setTax(tax);
		dto.setSpay(spay);
	}

}
