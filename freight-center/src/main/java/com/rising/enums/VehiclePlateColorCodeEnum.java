package com.rising.enums;



/**
 * 描述：车牌颜色代码枚举
 *
 * @see Enum
 * 作者：李启云
 * 日期：2021-01-27
 */

public enum VehiclePlateColorCodeEnum {


    /* 成功状态码 */
    BLUE("1", "蓝色"),
    YELLOW("2", "黄色"),
    BLACK("3", "黑色"),
    WHITE("4", "白色"),
    GREEN("5", "绿色"),
    OTHER("9", "其他"),
    AGRICULTURAL_YELLOW("91", "农黄色"),
    AGRICULTURAL_GREEN("92", "农绿色"),
    YELLOW_GREEN("93", "黄绿色"),
    GRADIENT_GREEN("94", "渐变绿"),


    ;


    private final String code;

    private final String name;

    VehiclePlateColorCodeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(String name) {
        for (VehiclePlateColorCodeEnum item : VehiclePlateColorCodeEnum.values()) {
            if (item.name().equals(name)) {
                return item.name;
            }
        }
        return name;
    }

    public static String getCode(String name) {
        for (VehiclePlateColorCodeEnum item : VehiclePlateColorCodeEnum.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String code = VehiclePlateColorCodeEnum.getCode(VehiclePlateColorCodeEnum.BLACK.toString());
        String name = VehiclePlateColorCodeEnum.getName(VehiclePlateColorCodeEnum.BLACK.toString());
        System.out.println("code = " + code);
    }
}
