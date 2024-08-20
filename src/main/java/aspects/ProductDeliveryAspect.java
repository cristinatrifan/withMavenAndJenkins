package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/*
An aspect is a decoupled piece of code that intercepts methods/beans
with the purpose of adding logic before/after the methods
or even avoiding the run of the methods
Decoupled from the functionality that you intercept

Use for decorating functionality with extra behavior, not change behavior:
  logging, authentication/authorization/security, transactions

Aspects run at runtime, only runtime annotations can work here
Runtime weaving involves applying aspects during the execution of the program.
AOP uses reflection
 */
@Aspect // not stereotype annotation
@Component
public class ProductDeliveryAspect {

    /*
    this method runs before the execution of the method addSomeProducts with any overloading
     */
    @Before("execution(* services.ProductDeliveryService.addSomeProducts(..))")
    public void before() {
        System.out.println("Before");
    }

    //runs regardless of whether method throws exception or not
    @After("execution(* services.ProductDeliveryService.addSomeProducts(..))")
    public void after() {
        System.out.println("After");
    }

    //only if the method runs without exception
    @AfterReturning("execution(* services.ProductDeliveryService.addSomeProducts(..))")
    public void afterReturning() {
        System.out.println("AfterReturning");
    }

    //only if the method runs with exception
    @AfterThrowing("execution(* services.ProductDeliveryService.addSomeProducts(..))")
    public void afterThrowing() {
        System.out.println("AfterThrowing");
    }

    /*
    Can add functionality before and/or after the method execution
    + can change return value of the method

    Better to use simpler aspect method, not around
    Because around changes behavior of the method
    But the Before/After decorates the method (like what happens when we use @Transaction)
     */
    @Around("execution(* services.ProductDeliveryService.addSomeProducts(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Before");
        //joinPoint.proceed(some params); //this even replaces the input parameters of the method
        joinPoint.proceed(); //if proceed is not called, the method does not run at all
        System.out.println("After");
        return "Something else";//this becomes the result of the method
    }
}
