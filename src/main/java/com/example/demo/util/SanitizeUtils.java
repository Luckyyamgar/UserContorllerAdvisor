package com.example.demo.util;

import org.springframework.web.util.HtmlUtils;

public class SanitizeUtils {

	private SanitizeUtils() {

	}

	public static String sanitize(String input) {
		return HtmlUtils.htmlEscape(input);
	}
}
