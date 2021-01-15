package com.rising.common.web.result;


/**
 * @author liqiyun
 * @desc API 统一返回状态码
 * <p>
 * 10000-- 通用错误代码
 * 22000-- 媒资错误代码
 * 23000-- 用户中心错误代码
 * 24000-- cms错误代码
 * 25000-- 文件系统
 */
public interface IResultCode {

    /**
     *
     * @return
     */
    Integer code();

    /**
     * 提示信息
     */
    String message();

}
