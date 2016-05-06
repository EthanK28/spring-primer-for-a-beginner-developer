package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExeTimeAspect {
	
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		return joinPoint;
		
	}
}
