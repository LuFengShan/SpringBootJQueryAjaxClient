package com.javasampleapproach.jqueryajax.monitor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

/**
 * @author sgx
 * @version V1.1.0
 * @date 2019/6/26 16:03
 * @since V1.1.0
 */
@Slf4j
@Aspect
@Component
public class ControllerMonitor {
	@AfterReturning("execution(* com..*Controller.*(..))")
	public void logServiceAccess(JoinPoint joinPoint) {
		Stream.of(joinPoint.getArgs())
				.forEach(p -> log.info(p.toString()));
		log.info("Completed: " + joinPoint);
	}
}
