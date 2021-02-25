package com.rising;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 描述：货运中心服务器
 * <p>
 * 作者：李启云
 * 日期：2020-12-31
 */
@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
@EnableJpaAuditing
@EnableSwagger2
public class FreightCenterServer {
    public static void main(String[] args) {
        SpringApplication.run(FreightCenterServer.class, args);
    }
}
