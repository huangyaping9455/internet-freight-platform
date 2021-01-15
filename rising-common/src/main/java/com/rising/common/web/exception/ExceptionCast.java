package com.rising.common.web.exception;


import com.rising.common.web.result.IResultCode;

/**
 * 描述：异常投
 * 自定义异常
 * 作者：李启云
 * 日期：2020-11-24
 */
public class ExceptionCast {

    public static void cast(IResultCode resultCode) {
        throw new RisingException(resultCode);
    }
}
