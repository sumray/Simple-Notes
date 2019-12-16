package com.simplenotes.user.login;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi{

	@Override
	public LoginResult submitMsg(LoginCondition condition) {
		System.out.println("哈哈啊");
		return null;
	}
}
