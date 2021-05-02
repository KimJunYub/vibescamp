package com.gamsungcamp.vibes.common.util;

public class StringUtil {
	
	private StringUtil() {
		
	}

	public static boolean isEmpty(String input) {
		if(input == null || input.trim().equals("")) {
			return true;
		}else {
			return false;
		}
	}
	
}
