package com.rising.common.web.result;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liqiyun
 * @desc API 统一返回状态码
 * @since 8/31/2017 3:00 PM
 */
public enum ResultCode implements IResultCode {

    /* 成功状态码 */
    SUCCESS(0, "成功"),

    /* 参数错误：10001-19999 */
    PARAM_IS_INVALID(10001, "参数无效"),
    PARAM_IS_BLANK(10002, "参数为空"),
    PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
    PARAM_NOT_COMPLETE(10004, "参数缺失"),
    NULL_POINTER(10004, "空指针"),

    /* 用户错误：20001-29999*/
    USER_NOT_LOGGED_IN(20001, "用户未登录"),
    USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
    USER_NOT_EXIST(20004, "用户不存在"),
    USER_HAS_EXISTED(20005, "用户已存在"),
    LOGIN_CREDENTIAL_EXISTED(20006, "凭证已存在"),
    LOGIN_ORIGINAL_PASSWORD_NOT_MATCH(20007, "输入原始密码不配"),

    /* 业务错误：30001-39999 */
    SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "业务错误"),
    ADD_ERROR(30002, "添加失败"),
    UPDATE_ERROR(30003, "更新失败"),
    DELETE_ERROR(30004, "删除失败"),
    UPLOAD_FAILED(30005, "上传失败"),
    INVALID_FILE_TYPE(3006, "无效的文件类型"),
    CANNOT_DELETE_THE_ROLE_OF_THE_LINKED_USER(3007, "不能删除挂用户的角色"),
    CANNOT_DELETE_COMPANIES_WITH_DEPARTMENTS(3008, "不能删除有部门的公司"),




    /* 系统错误：40001-49999 */
    SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"),

    /* 数据错误：50001-599999 */
    RESULE_DATA_NONE(50001, "数据未找到"),
    DATA_IS_WRONG(50002, "数据有误"),
    DATA_ALREADY_EXISTED(50003, "数据已存在"),
    DATA_DRIVER_EXISTED(50004, "司机已存在"),
    DATA_CAR_EXISTED(50005, "车辆已存在"),

    /* 接口错误：60001-69999 */
    INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
    INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
    INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
    INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
    INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
    INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

    /* 权限错误：70001-79999 */
    PERMISSION_NO_ACCESS(70001, "无访问权限"),
    RESOURCE_EXISTED(70002, "资源已存在"),
    RESOURCE_NOT_EXISTED(70003, "资源不存在");


    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }

    public static String getMessage(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.message;
            }
        }
        return name;
    }

    public static Integer getCode(String name) {
        for (ResultCode item : ResultCode.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name();
    }

    /***
     * 校验重复的code值
     */
   public static void main(String[] args) {

       String message = getMessage("UPDATE_ERROR");
       Integer code = getCode("UPDATE_ERROR");

       ResultCode[] apiResultCodes = ResultCode.values();
        List<Integer> codeList = new ArrayList<Integer>();
        for (ResultCode apiResultCode : apiResultCodes) {
            if (codeList.contains(apiResultCode.code)) {
                System.out.println(apiResultCode.code);
            } else {
                codeList.add(apiResultCode.code());
            }

            System.out.println(apiResultCode.code() + " " + apiResultCode.message());
        }
    }
}
