package com.rising.enums;

import com.rising.common.web.result.IResultCode;
import lombok.Getter;

@Getter
public enum FreightCenterEnums implements IResultCode {
    ;

    @Override
    public Integer code() {
        return null;
    }

    @Override
    public String message() {
        return null;
    }
    private Integer code;

    private String message;

    FreightCenterEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
