package com.rising.security.core.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 描述：图片大小配置
 * 创建时间：2020-01-31 10:59:46
 * 创建作者：李启云
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ImageCodeProperties extends SmsCodeProperties {

    /**
     * 验证码的宽度
     */
    private int width = 67;

    /**
     * 验证码的高度
     */
    private int height = 17;

    /**
     * 保证初始化ImageCodeProperties时length的默认值为4
     */
    public ImageCodeProperties() {
        setLength(4);
    }
}
