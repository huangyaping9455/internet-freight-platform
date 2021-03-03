package com.rising.common.web.exception;

import com.google.common.collect.ImmutableMap;
import com.rising.common.web.result.DefaultErrorResult;
import com.rising.common.web.result.IResultCode;
import com.rising.common.web.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常捕获类
 *
 * @author liqiyun
 * @version 1.0
 * @create 2018-09-14 17:32
 **/
@ControllerAdvice
public class ExceptionCatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionCatch.class);

    /**
     * 定义map，配置异常类型所对应的错误代码
     */

    private static ImmutableMap<Class<? extends Throwable>, IResultCode> EXCEPTIONS;
    /**
     *
     * 定义map的builder对象，去构建ImmutableMap
     */

    protected static ImmutableMap.Builder<Class<? extends Throwable>, IResultCode> builder = ImmutableMap.builder();

    /**
     * <p> 方法描述：捕获CustomException此类异常. </p>
     * <p> 创建时间：2020-01-07 09:27:58 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param customException the custom exception
     * @return the response result
     */

    @ExceptionHandler(RisingException.class)
    @ResponseBody
    public DefaultErrorResult risingException(RisingException customException) {
        customException.printStackTrace();
        //记录日志
        LOGGER.error("catch exception:{}", customException.getMessage());
        IResultCode resultCode = customException.getResultCode();
        return new DefaultErrorResult(resultCode);
    }

    /**
     * <p> 方法描述：捕获Exception此类异常. </p>
     * <p> 创建时间：2020-01-07 09:27:34 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param exception the exception
     * @return the response result
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public DefaultErrorResult exception(Exception exception) {
        exception.printStackTrace();
        //记录日志
        LOGGER.error("catch exception:{}", exception.getMessage());
        if (EXCEPTIONS == null) {
            //EXCEPTIONS构建成功
            EXCEPTIONS = builder.build();
        }
        //从EXCEPTIONS中找异常类型所对应的错误代码，如果找到了将错误代码响应给用户，如果找不到给用户响应99999异常
        IResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode != null) {
            return new DefaultErrorResult(resultCode);
        } else {
            //返回40001异常
            return new DefaultErrorResult(ResultCode.SYSTEM_INNER_ERROR);
        }


    }

    static {
        //定义异常类型所对应的错误代码
//        builder.put(HttpMessageNotReadableException.class, ResultCode.PARAM_IS_INVALID);
    }
}
