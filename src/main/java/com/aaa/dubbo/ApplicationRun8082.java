package com.aaa.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName ApplicationRun8082
 * @Author 王宇
 * @Date 2019/9/6 19:33
 * @Version 1.0
 */
@SpringBootApplication
@EnableDubbo
public class ApplicationRun8082 {
    public static void main(String[] args){
        SpringApplication.run(ApplicationRun8082.class,args);
    }
}
