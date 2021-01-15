package com.rising.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RisingRedis implements BeanPostProcessor {


 /*   @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof RedisTemplate) {
            log.info("开始执行Redis后置处理器bean:{},beanName:{}", bean, beanName);
            RedisTemplate redisTemplate = (RedisTemplate) bean;
            redisTemplate.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
            return redisTemplate;
        }

        return bean;
    }*/


}
