package ma.craft.boomer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Starter {

	@Around(value = "@annotation(Boomer)")
	public <T> T boomer(final ProceedingJoinPoint proceedingJoinPoint, Boomer bommer) throws Throwable {
		
		
		CodeSignature signature = (CodeSignature) proceedingJoinPoint.getSignature();

		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

			T stu = (T) proceedingJoinPoint.proceed();// return method
			return stu;
	}}