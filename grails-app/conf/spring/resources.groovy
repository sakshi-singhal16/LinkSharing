// Place your Spring DSL code here
beans = {
	newBean(com.tothenew.linksharing.Person) { bean ->
		firstName = "sakshi"
		age = 23
		bean.scope = 'prototype'
	}
	newBeanUsingConst(com.tothenew.linksharing.Person, "sakshi") {

	}
	beanByType(com.tothenew.linksharing.Person, "SAKSHI") {

	}
}
