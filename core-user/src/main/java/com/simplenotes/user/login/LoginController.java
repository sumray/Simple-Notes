package com.simplenotes.user.login;

import com.simplenotes.cache.CacheProvider;
import com.simplenotes.mvc.ResultMessage;
import com.simplenotes.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi{
	@Autowired
	private CacheProvider cacheProvider;

	@Override
	public ResultMessage submitMsg() {
		cacheProvider.set("123", "456", "789");
		Object obj = cacheProvider.get("123", "456");
		System.out.println(obj);
		System.out.println("哈哈啊");
		return ResultMessage.success("123");
	}
}
