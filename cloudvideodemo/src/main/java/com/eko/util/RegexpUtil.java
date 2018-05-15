package com.eko.util;

import java.util.regex.Pattern;

public class RegexpUtil {
	public static void main(String[] args){
	 
		StringBuilder a = new StringBuilder("[$BOX_ACCESS_TOKEN$]32okrjfwe vjoi4ut32m45c98fr23d09kjf39nmyv58t329krd8mutjf3o,ke298cu43<><><><><><><//213.4234><24232414><");
			int accessToeknStartIndex =	a.indexOf("[$BOX_ACCESS_TOKEN$]");
			System.out.println(accessToeknStartIndex);
//				System.out.println(accessToeknStartIndex);
//				System.out.println("[$BOX_ACCESS_TOKEN$]".length());
//				String replaceAfter = a.replace(accessToeknStartIndex, accessToeknStartIndex+"[$BOX_ACCESS_TOKEN$]".length(), 
//						"gaoyansong").toString();
//				System.out.println(replaceAfter);
	}
}
