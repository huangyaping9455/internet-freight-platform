/**
 *
 */
package com.rising.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author liqiyun
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

//	@Autowired
//	private PrometheusMetricsInterceptor prometheusMetricsInterceptor;
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(prometheusMetricsInterceptor)
//				.addPathPatterns("/**");
//	}

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();

    }

}
