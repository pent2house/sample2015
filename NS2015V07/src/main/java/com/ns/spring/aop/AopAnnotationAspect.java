package com.ns.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class AopAnnotationAspect {

	@Before("@annotation(com.ns.spring.aop.Loggable)")
	public void myAdvice(){
		System.out.println("Executing myAdvice!!");
	}
}
