package com.sp.user;

import org.springframework.stereotype.Service;

@Service //  명시하지 않으면 No qualifying bean of type 'com.sp.user.UserService' 오류 발생..
public class UserServiceImpl implements UserService {

	@Override
	public String message(User dto) {
		String s = dto.getName() + "님은 " + (dto.getAge() >= 19 ? "성인입니다." : "미성년자입니다.");
		return s;
	}

}
