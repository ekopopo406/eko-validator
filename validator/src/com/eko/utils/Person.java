package com.eko.utils;

public class Person {
	private String name;
	
	public Person(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean equals(Object obj) {
		Person person =	(Person)obj;
		if(person.getName().equals(name)){
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode();
	}
 
	
	
}
