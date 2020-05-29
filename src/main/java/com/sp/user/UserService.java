package com.sp.user;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
	public String message(User dto);
}
