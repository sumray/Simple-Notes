package com.simplenotes.common;

import java.util.Random;

public class ActiveCodeUtils {
	public static String getActiveCode(){
		return String.valueOf(new Random().nextInt(999999));
	}
}
