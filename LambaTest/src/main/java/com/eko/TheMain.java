package com.eko;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class TheMain {
	public static void main(String[] args){
		PersonService personService = new PersonService();
		List<Person> personByName = personService.getPersonByName("eko1");
		for(Person person:personByName){
			System.out.println(person.getName()+"-"+person.getAge());
		}
		HashMap<String,String> hashmap = new HashMap<String,String>();
		
	}
}
