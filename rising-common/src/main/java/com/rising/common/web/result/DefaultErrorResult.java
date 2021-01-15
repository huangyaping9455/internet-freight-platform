package com.rising.common.web.result;


import com.rising.common.core.RequestContextUtil;
import com.rising.common.web.exception.RisingException;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 描述：默认的错误结果
 *
 * @see Result
 * 作者：李启云
 * 日期：2020-12-30
 */
@NoArgsConstructor
@Data
public class DefaultErrorResult implements Result {

    private static final long serialVersionUID = 1899083570489722793L;

    /**
     * 异常堆栈的精简信息
     */
    private String message;

    /**
     * 我们系统内部自定义的返回值编码，{@link IResultCode} 它是对错误更加详细的编码
     * <p>
     * 备注：spring boot默认返回异常时，该字段为null
     */
    private Integer code;

    /**
     * 调用接口路径
     */
    private String path;

    /**
     * 异常的名字
     */
    private String exception;

    /**
     * 异常的错误传递的数据2
     */
    private Object errors;

    /**
     * 时间戳
     */
    private Date timestamp;

    public DefaultErrorResult(IResultCode iResultCode) {
        this.code = iResultCode.code();
        this.message = iResultCode.message();
    }

    public static DefaultErrorResult failure(IResultCode resultCode, Throwable e, Object errors) {
        DefaultErrorResult result = DefaultErrorResult.failure(resultCode, e);
        result.setErrors(errors);
        return result;
    }

    public static DefaultErrorResult failure(IResultCode resultCode, Throwable e) {
        DefaultErrorResult result = new DefaultErrorResult();
        result.setCode(resultCode.code());
        result.setMessage(resultCode.message());
        result.setException(e.getClass().getName());
        String path =  RequestContextUtil.getRequest().getRequestURI();
        result.setPath(path);
        result.setTimestamp(new Date());
        return result;
    }

    public static DefaultErrorResult failure(RisingException e) {
        return DefaultErrorResult.failure(e.getResultCode(), e, e.getMessage());
    }

}
