package com.multi.aop;

import com.multi.aop.service.SampleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    // 애플리케이션 시작 시 SampleService의 메서드들을 호출하는 Bean 등록
    @Bean
    public CommandLineRunner runner(SampleService sampleService) {
        return args -> {
            System.out.println("\n--- 1. greet() 호출 ---");
            String greetResult = sampleService.greet("AOP");
            System.out.println("main에서 받은 결과: " + greetResult);

            System.out.println("\n--- 2. calc() 호출 ---");
            int calcResult = sampleService.calc(10, 5);
            System.out.println("main에서 받은 결과: " + calcResult);


            System.out.println("\n--- 3. fail() 호출 ---");
            try {
                sampleService.fail();
            } catch (Exception e) {
                System.out.println("main에서 예외 처리: " + e.getMessage());
            }
        };
    }
}