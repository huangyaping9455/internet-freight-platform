package com.rising.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 描述:注册发现服务中心
 *
 * @author 李启云
 * @ProjectName meet
 * @ClassName: ApplicationEureka
 * @date 2020/5/8 11:40
 */

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServer {

    public static void main(String[] args) {
        SpringApplication.run(DiscoveryServer.class, args);
    }
}
