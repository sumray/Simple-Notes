package com.simplenotes.user.login;

import com.simplenotes.mvc.ResultMessage;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi{

	@Override
	public ResultMessage submitMsg(LoginCondition condition) {
		System.out.println("哈哈啊");
		return ResultMessage.success("123");
	}
}
