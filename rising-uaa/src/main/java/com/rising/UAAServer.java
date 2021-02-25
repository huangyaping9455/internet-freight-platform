package com.rising;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 描述:权限和授权认证中心
 *
 * @author 李启云
 * @ProjectName master
 * @ClassName: UAAServer
 * @date 2020/6/4 16:44
 */
@SpringBootApplication
@EnableEurekaClient
@EnableJpaAuditing(auditorAwareRef = "springSecurityAuditorAware")
public class UAAServer {
    public static void main(String[] args) {
        SpringApplication.run(UAAServer.class, args);
    }


}
