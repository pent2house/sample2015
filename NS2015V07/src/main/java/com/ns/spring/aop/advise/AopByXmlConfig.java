package com.ns.spring.aop.advise;

import org.aspectj.lang.ProceedingJoinPoint;

public class AopByXmlConfig {

	public Object aopAroundAdvice(ProceedingJoinPoint pjp){
		System.out.println("AopByXmlConfig-xml-xml-xml-xml-xml-xml: Before invoking getName() method");
		Object value = null;
		try {
			value = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("AopByXmlConfig-xml-xml-xml-xml-xml-xml: After invoking getName() method. Return value="+value);
		return value;
	}
}
