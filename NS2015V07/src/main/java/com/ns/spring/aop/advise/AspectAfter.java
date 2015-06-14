package com.ns.spring.aop.advise;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAfter {

	private static final Logger log = LoggerFactory.getLogger(AspectAfter.class);

	@AfterThrowing(pointcut = "execution(* com.ns.spring.dao.GenHbDaoImpl.*(..))", throwing = "error")
	public Object afterException(JoinPoint joinPoint, Throwable error) {
		log.info("(At afterException) Method name: " + joinPoint.getSignature().getName());
		log.info("(At afterException) Exception : " + error);
		return error;
	}

	@AfterReturning(pointcut = "execution(* com.ns.spring.dao.GenHbDaoImpl.*(..))", returning = "result")
	public Object afterNormalEnd(JoinPoint joinPoint, Object result) {
		log.info("(At afterNormalEnd) Method name: " + joinPoint.getSignature().getName());
		log.info("(At afterNormalEnd) Result: " + result);
		return result;
	}
	
	@After("execution(* com.ns.spring.RmaController.backTo*(..))")
	public void beforeAllRmaCtrlGoTo(JoinPoint pt){
		log.info("\n++++++++++++++++++++ Controller (Back To screen Transition) ++++++++++++++++++++ " +pt.getSignature().getName() + " called!");
		setLogMsg(pt);
	}
	
	private void setLogMsg(JoinPoint jpt) {

		StringBuffer sb = new StringBuffer();
		sb.append("\n Class: ");
		sb.append(jpt.getTarget().getClass().getName());
		sb.append("\n Method: ");
		sb.append(jpt.getSignature().getName());
		Object[] arr = jpt.getArgs();
		if (arr != null && arr.length > 0) {
			sb.append("\n Param(s): ");
			for (Object element : arr) {
				if (element != null) {
					sb.append(element).append(",");
				}
			}
			// Delete the last comma
			sb.deleteCharAt(sb.length() - 1);
		}
		log.info(sb.toString());
	}
}
