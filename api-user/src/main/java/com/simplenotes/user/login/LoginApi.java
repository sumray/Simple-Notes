package com.simplenotes.user.login;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("core-user")
public interface LoginApi {
	@PostMapping("/submit")
	LoginResult submitMsg(LoginCondition condition);
}