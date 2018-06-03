package com.eko;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PersonService {
	public List<Person> personList(){
		List<Person> personList = new ArrayList<Person>();
		personList.add(new Person("eko1",10));
		personList.add(new Person("eko1",20));
		personList.add(new Person("eko2",30));
		personList.add(new Person("eko3",20));
		personList.add(new Person("eko4",30));
		personList.add(new Person("eko4",40));
		personList.add(new Person("eko5",50));
		personList.add(new Person("eko6",50));
		personList.add(new Person("eko7",10));
		return personList;
	}
	public List<Person> getPersonByName(String name){
		  return find(p -> name.equals(p.getName()));
	}
	  public List<Person> find(final Predicate<Person> predicate){
	        return personList().stream().filter(p -> predicate.test(p)).collect(Collectors.toList());
	    }
}
