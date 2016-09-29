/**
 * 
 */
package org.arpit.java2blog.service.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author Owner
 *
 */
@Aspect
public class LoggingAspect {
	
	@Before("getAllLogs()")
	public void loggingAdvice(){
		System.out.println("Aspect logging shuru");
	}

	
	@Before("getAllLogs()")
	public void loggingAdviceClass(){
		System.out.println("Aspect logging shuru");
	}
	
	@Pointcut("execution(* get*(..))*")
	public void getAllLogs(){}
	
	@AfterThrowing("execution(* get*(..))*")
	public void getAfterLogs(){
		System.out.println("Aspect logging shuru");
	}
}
