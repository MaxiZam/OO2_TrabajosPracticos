package main.java.aop.domain.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeExecutionAspect {

	@Around("execution(public void loginUser(..))")
	public void tiempo(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.nanoTime();

		joinPoint.proceed();

		long endTime = System.nanoTime();
		long executionTime = endTime - startTime;

		double seconds = executionTime / 1_000_000_000.0;

		System.out.println(
				"Tiempo de ejecución de la función: " + executionTime + " nanosegundos o " + seconds + " segundos");
	}
}
