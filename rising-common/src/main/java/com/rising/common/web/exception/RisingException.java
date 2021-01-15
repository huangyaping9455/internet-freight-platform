package com.rising.common.web.exception;


import com.rising.common.web.result.IResultCode;

/**
 * 描述：不断上升的例外
 *
 * @see RuntimeException
 * 作者：李启云
 * 日期：2020-11-24
 */
public class RisingException extends RuntimeException {

    /**
     * 错误代码
     */

    private IResultCode resultCode;

    public RisingException(IResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public IResultCode getResultCode() {
        return resultCode;
    }


}
