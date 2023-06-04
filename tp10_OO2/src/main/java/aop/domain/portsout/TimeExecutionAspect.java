package main.java.aop.domain.portsout;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeExecutionAspect {

	@Around("execution(main.java.aop.domain)")
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
