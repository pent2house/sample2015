package com.ns.spring.aop.test;

import com.ns.spring.aop.Loggable;

public class AopTest {

	private String name;

	public String getName() {
		return name;
	}

	@Loggable
	public void setName(String nm) {
		this.name = nm;
	}

	public void throwException() {
		throw new RuntimeException("Dummy Exception");
	}

}
