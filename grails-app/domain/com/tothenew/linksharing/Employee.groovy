package com.tothenew.linksharing
//dummy class to test custom beans
class Employee {
	String firstName
	int age

	Employee() {}

	Employee(String fn) {
		println "--------------------------------------------called firstName constructor"
		firstName = fn
	}

	String getFirstName() {
		return firstName
	}

	void setFirstName(String firstName) {
		this.firstName = firstName
		println "name set---------------------------------${firstName}"
	}

	int getAge() {
		return age
	}

	void setAge(int age) {
		this.age = age
		println "age set----------------------------------${age}"
	}


	static constraints = {
	}
}
