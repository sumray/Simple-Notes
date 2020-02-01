package com.simplenotes.cache;

public class CacheKeyStrategy {
	public static String getCacheKey(String key, String group){
		StringBuilder sb = new StringBuilder();
		if (group != null){
			sb.append(group).append(":");
		}
		sb.append(key);
		return sb.toString();
	}
}
