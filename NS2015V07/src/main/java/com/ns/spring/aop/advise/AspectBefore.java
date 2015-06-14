package com.ns.spring.aop.advise;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectBefore {

	private static final Logger log = LoggerFactory.getLogger(AspectBefore.class);

	@Before("execution(* com.ns.spring.RmaController.*(..))")
	public void beforeAllRmaCtrl(JoinPoint pt){
		log.info("\n:::::::::::::::: Controller :::::::::::::::: " +pt.getSignature().getName() + " called!");
		Object[] arr = pt.getArgs();
		logMsg(arr);
	}
	
	@Before("execution(* com.ns.spring.RmaController.goTo*(..))")
	public void beforeAllRmaCtrlGoTo(JoinPoint pt){
		log.info("\n................ Controller (Screen Transition) ................ " +pt.getSignature().getName() + " called!");
		Object[] arr = pt.getArgs();
		logMsg(arr);
	}
	
	@Before("execution(* com.ns.spring.RmaController.initList(..))")
	public void beforeRmaCtrl_initList(JoinPoint pt){
		log.info("\n***************** Controller (Specified Method) ***************** " +pt.getSignature().getName() + " called!");
		Object[] arr = pt.getArgs();
		logMsg(arr);
	}
	
	/** ------------------------------------------------------------------------------------ */
	/** Any public method in this package starting with "set" and return void */
	/** takes single parameter of any type */
	/** ------------------------------------------------------------------------------------ */
	@Before("execution(public void com.ns.spring.aop.test.*.set*(*))")
	//@Before("execution(* com.ns.spring.aop.test.*.get*())")
//	@Before("execution(public @ResponseBody com.ns.spring.*(..))")
	public void responseBodyAdvice(JoinPoint pt){
		log.info("\n***************** Controller (Specified Return Type) ***************** " +pt.getSignature().getName() + " called!");
		Object[] arr = pt.getArgs();
		logMsg(arr);
	}
	
	private void logMsg(Object[] arr) {
		if( arr != null && arr.length > 0 ) {
			for( Object obj: arr) {
				log.info("Parameter value -> "+obj.toString());
			}
		}
	}	
}
