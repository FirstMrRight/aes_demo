package com.ltx.aes_demo;

import cn.licoy.encryptbody.annotation.EnableEncryptBody;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptBody
@SpringBootApplication
public class AesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AesDemoApplication.class, args);
    }

}
