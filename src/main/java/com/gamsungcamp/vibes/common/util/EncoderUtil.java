package com.gamsungcamp.vibes.common.util;

import java.security.MessageDigest;

public class EncoderUtil {

	public String encodingToSHA256(String base) {

		StringBuffer hexString = new StringBuffer();
		
		try{
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(base.getBytes("UTF-8"));

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}

			//Ãâ·Â
			//System.out.println(hexString.toString());

		} catch(Exception ex){
			throw new RuntimeException(ex);
		}
		
		return hexString.toString();

	}	
	
}
