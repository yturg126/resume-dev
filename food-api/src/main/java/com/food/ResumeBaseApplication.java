package com.food;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.food.mapper")
@ComponentScan(basePackages = {"com.food", "org.n3r.idworker"})
public class ResumeBaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResumeBaseApplication.class, args);
    }
}
