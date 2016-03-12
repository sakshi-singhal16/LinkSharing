package com.tothenew.linksharing

/**
 * Created by sakshi on 7/3/16.
 */
class Person {
	String firstName
	int age

	Person() {}

	Person(String fn) {
//		println "--------------------------------------------called firstName constructor"
		firstName = fn
	}

	String getFirstName() {
		return firstName
	}

	void setFirstName(String firstName) {
		this.firstName = firstName
//		println "name set---------------------------------${firstName}"
	}

	int getAge() {
		return age
	}

	void setAge(int age) {
		this.age = age
//		println "age set----------------------------------${age}"
	}
}
