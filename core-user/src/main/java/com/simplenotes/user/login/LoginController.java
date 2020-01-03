package com.simplenotes.user.login;

import com.simplenotes.cache.CacheProvider;
import com.simplenotes.mvc.ResultMessage;
import com.simplenotes.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginApi{
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CacheProvider cacheProvider;

	@Override
	public ResultMessage submitMsg() {
		logger.info("哈哈哈哈");
		cacheProvider.set("123", "456", "789");
		Object obj = cacheProvider.get("123", "456");
		System.out.println(obj);
		System.out.println("哈哈啊");
		return ResultMessage.success("123");
	}
}
