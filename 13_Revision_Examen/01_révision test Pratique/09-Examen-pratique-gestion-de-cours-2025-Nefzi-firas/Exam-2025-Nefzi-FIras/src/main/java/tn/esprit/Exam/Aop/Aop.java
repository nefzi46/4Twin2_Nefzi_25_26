package tn.esprit.Exam.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;

public class Aop {
    @After("execution(* tn.esprit.Exam.services.*.addP(..))")
    public void afterServiceMethods(JoinPoint joinPoint){
        String name= joinPoint.getSignature().getName();

    }
}
