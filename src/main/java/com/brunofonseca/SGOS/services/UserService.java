package com.brunofonseca.SGOS.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.brunofonseca.SGOS.security.UserSS;

public class UserService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}