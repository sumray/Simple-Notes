package com.simplenotes.user.login;

import com.simplenotes.mvc.ResultMessage;
import com.simplenotes.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("core-user")
public interface LoginApi {
	@PostMapping("/submit")
	ResultMessage submitMsg(User user);
}
