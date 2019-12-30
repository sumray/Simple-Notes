package com.simplenotes.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class CacheProvider {
	private RedisTemplate<String,Object> template;

	public CacheProvider(RedisTemplate<String, Object> template) {
		this.template = template;
	}

	public void set(String group, String key, String value){
		template.opsForHash().put(group,key,value);
	}

	public Object get(String group, String key) {
		return template.opsForHash().get(group, key);
	}
}
