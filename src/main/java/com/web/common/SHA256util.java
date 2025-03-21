package com.web.common;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256util {
	private static final String SALT = "Thfxm828282!@#$r1!r2@r3#p0o9i8";
	
	public static String encode(String str) {
		return DigestUtils.sha256Hex(str + SALT);
	}
}
