package com.multi.aop.service;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    // 정상 실행 케이스 1
    public String greet(String name) {
        System.out.println("==> greet() 핵심 로직 실행");
        return "Hello " + name;
    }

    // 정상 실행 케이스 2
    public int calc(int a, int b) {
        System.out.println("==> calc() 핵심 로직 실행");
        return a + b;
    }

    // 예외 발생 케이스
    public void fail() {
        System.out.println("==> fail() 핵심 로직 실행");
        throw new IllegalStateException("boom");
    }
}