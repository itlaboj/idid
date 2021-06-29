package com.example.demo.p04;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPChecker {
	@Autowired
	HttpSession session;

	@Before("execution(* com.example.demo.p04.MyController.result(..))")
	public void aoptest01(JoinPoint jp) {
		Integer total = (Integer)session.getAttribute("TOTAL");

		if (total == null) {
			System.out.println("セッション・オブジェクトがありません。");
		}
	}

}
