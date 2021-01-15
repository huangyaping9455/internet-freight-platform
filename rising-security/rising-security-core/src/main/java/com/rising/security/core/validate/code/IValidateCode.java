package com.rising.security.core.validate.code;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * 描述：存放到redis里的对象必须是序列化的，所以这里要实现Serializable接口
 * 创建时间：2020-01-31 11:59:29
 * 创建作者：李启云
 * @author liqiyun
 */
@Data
public class IValidateCode implements Serializable {

    private static final long serialVersionUID = -5882129757498488074L;
    /**随机验证码*/
    private String code;
    /**本地当前时间*/
    private LocalDateTime expireTime;

    public IValidateCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public IValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }

    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
