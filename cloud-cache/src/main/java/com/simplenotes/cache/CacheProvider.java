package com.simplenotes.cache;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

public class CacheProvider {
	private RedisTemplate<String,Object> template;

	public CacheProvider(RedisTemplate<String, Object> template) {
		this.template = template;
	}

	public void set(String group, String key, Object value, int ttl){
		CacheableData data = new CacheableData(group, key, value);
		template.opsForValue().set(data.getCacheKey(),data,ttl, TimeUnit.SECONDS);
	}

	public Object get(String group, String key) {
		return template.opsForValue()
				.get(CacheKeyStrategy.getCacheKey(key, group));
	}
}
