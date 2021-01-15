/**
 *
 */
package com.rising.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 网关服务器
 *
 * @author liqiyun
 * @date 2020/08/19
 */
@EnableEurekaClient
@SpringBootApplication
@EnableZuulProxy
@EnableSwagger2
@RestController
@EnableFeignClients
public class GatewayServer {
    public static void main(String[] args) {
        SpringApplication.run(GatewayServer.class, args);
    }


}
