package com.food.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

	public static List<String> GetSearchCondition(final String searchStr) {
		List<String> condition = new ArrayList<String>();
		
		String[] parts = searchStr.split(" ");
		for (int i = 0; i < parts.length; ++i) {
			condition.add(parts[i]);
		}
		
		return condition;
	}
	
}
