package com.rising.security.app.validate.code.impl;

import com.rising.security.core.validate.code.IValidateCode;
import com.rising.security.core.validate.code.ValidateCodeException;
import com.rising.security.core.validate.code.ValidateCodeRepository;
import com.rising.security.core.validate.code.ValidateCodeType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.TimeUnit;


/**
 * 描述：使用redis+deviceId的方式进行验证码的存、取、删
 * 创建时间：2020-02-02 11:29:25
 * 创建作者：李启云
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;


    @Override
    public void save(ServletWebRequest request, IValidateCode code, ValidateCodeType type) {
        redisTemplate.opsForValue().set(buildKey(request, type), code, 10, TimeUnit.MINUTES);
    }

    @Override
    public IValidateCode get(ServletWebRequest request, ValidateCodeType type) {
        Object value = redisTemplate.opsForValue().get(buildKey(request, type));
        if (value == null) {
            return null;
        }
        return (IValidateCode) value;
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType type) {
        redisTemplate.delete(buildKey(request, type));
    }

    /**
     * 构建验证码在redis中的key ---- 该key类似与cookie
     *
     * @param request
     * @param type
     * @return
     */
    private String buildKey(ServletWebRequest request, ValidateCodeType type) {
        String deviceId = request.getHeader("deviceId");
        if (StringUtils.isBlank(deviceId)) {
            throw new ValidateCodeException("请在请求头中携带deviceId参数");
        }
        String result = "code:" + type.toString().toLowerCase() + ":" + deviceId;
        System.out.println(result);

        return result;
    }
}
