package com.leone.pay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * spring-boot 支付 demo
 * nohup java -jar spring-boot-pay.jar 1>web.log 2>&1 &
 */
@EnableSwagger2
@SpringBootApplication
@MapperScan(basePackages = "com.andy.pay.mapper")
public class PayApplication {
    public static void main(String[] args) {
        SpringApplication.run(PayApplication.class, args);
    }
}