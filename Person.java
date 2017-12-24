package edu.albany.person;

//Super class for a person
abstract public class Person {
	
	private String name;
	private String title;
	
	//Constructor to initialize Person with given name
	public Person(String name, String title){
		this.name = name;
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return name + ", " + title;
	}
}
