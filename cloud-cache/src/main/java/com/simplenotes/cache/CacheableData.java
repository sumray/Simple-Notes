package com.simplenotes.cache;

class CacheableData {

	private String group;
	private String key;
	private Object data;

	CacheableData(String group, String key, Object data) {
		this.group = group;
		this.key = key;
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public String getCacheKey(){
		return CacheKeyStrategy.getCacheKey(key, group);
	}
}
