package com.valid.youtu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@MapperScan("com.valid.youtu.mapper")
@SpringBootApplication
public class YoutuApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoutuApplication.class, args);
    }

}
