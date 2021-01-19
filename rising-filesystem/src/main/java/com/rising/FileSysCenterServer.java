package com.rising;


import io.github.bluemiaomiao.annotation.EnableFastdfsClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableFastdfsClient
@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
@EnableJpaAuditing
public class FileSysCenterServer {
    public static void main(String[] args) {
        SpringApplication.run(FileSysCenterServer.class, args);
    }
}
