package com.ns.spring.aop.advise;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class AspectAround {

	private static final Logger log = LoggerFactory.getLogger(AspectAround.class);

	/** ----------------------------------------------------------- */
	/** Any method whose parameter is String                        */
	/** ----------------------------------------------------------- */
	@Pointcut("args(java.lang.String)")
	public void pointCutStringId(){}
	
	/** ----------------------------------------------------------- */
	/** Any method whose parameter is RtrnTpModel                   */
	/** ----------------------------------------------------------- */
	@Pointcut("args(com.ns.spring.model.ui.RtrnTpModel)")
	public void pointCutRtrnTpParam(){}

	/** ----------------------------------------------------------- */
	/** Any class under this package                                */
	/** ----------------------------------------------------------- */
	@Pointcut("within(com.ns.spring.dao.template.*)")
	public void pointCutWithinDaoTemplate(){}

	/** ----------------------------------------------------------- */
	/** Any method in RmaController class                           */
	/** ----------------------------------------------------------- */
	@Pointcut("execution(* com.ns.spring.RmaController.*(..))")
	public void pointCutAllRmaController(){}

	/** ----------------------------------------------------------- */
	/** Any method starts with "get" under this package             */
	/** ----------------------------------------------------------- */
	@Pointcut("execution(* com.ns.spring.dao.template.*.get*(..))")
	public void pointCutDaoTemplate(){}

	/** ----------------------------------------------------------- */
	/** Any method in GenHbDaoImpl class                            */
	/** ----------------------------------------------------------- */
	@Pointcut("execution(* com.ns.spring.dao.GenHbDaoImpl.*(..))")
	public void pointCutGenDao(){}

	@Around("pointCutGenDao() || pointCutDaoTemplate()")
	public Object aroundDao(ProceedingJoinPoint jpt) throws Throwable {
		return aroundAdvice(jpt, "aroundDao");
	}

	@Around("pointCutStringId() && pointCutWithinDaoTemplate()")
	public Object aroundDaoTemplWStringParam(ProceedingJoinPoint jpt) throws Throwable {
		return aroundAdvice(jpt, "aroundDaoTemplWStringParam");
	}
	
	private Object aroundAdvice(ProceedingJoinPoint jpt, String methodName) {
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("-------------------------(At "+methodName+") BEFORE-------------------------");		
		Object obj = null;
		try {
			obj = jpt.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.info("-------------------------(At "+methodName+") AFTER-------------------------");
		sw.stop();

		setLogMsg(jpt, sw);
		return obj;
	}
	
	private void setLogMsg(ProceedingJoinPoint jpt, StopWatch sw) {

		StringBuffer sb = new StringBuffer();
		sb.append("\n At " +getCurrTime());
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
		sb.append("\n ================= Time consumed: ");
		sb.append(sw.getTotalTimeMillis());
		sb.append(" Milli Sec =================");
		log.info(sb.toString());
	}
	
	private String getCurrTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss.S");
		return sdf.format(new Date());
	}
}
