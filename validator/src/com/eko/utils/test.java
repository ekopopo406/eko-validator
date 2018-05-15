package com.eko.utils;

import java.util.Collection;
import java.util.HashSet;

public class test {
	public static void main(String[] args){
		//String a="abc";String b="abc"; if(a==b){ System.out.println("capabilities".toUpperCase()); }else{ System.out.println("2"); }
		Collection col = new HashSet<Person>();
		Person p1 = new Person("1");
		Person p2 = new Person("1");
		Person p3 = new Person("1");
		Person p4 = new Person("1");
		
		col.add(p1);
		col.add(p2);
		col.add(p3);
		col.add(p4);
		System.out.println(col.size());
	}
}
