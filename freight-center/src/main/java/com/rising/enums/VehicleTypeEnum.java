package com.rising.enums;


/**
 * 版本：1.0.0
 * 描述：车辆类型的枚举
 *
 * @see Enum
 * 码农：李齐云
 * 日期：2021-01-27
 */
public enum VehicleTypeEnum {


    H10_HEAVY_TRUCK ("H10"," 重型货车"),
    H11_HEAVY_TRUCK ("H11"," 重型普通货车"),
    H12_HEAVY_VAN ("H12"," 重型厢式货车"),
    H13_HEAVY_CLOSED_TRUCK ("H13"," 重型封闭货车"),
    H14_HEAVY_TANK_TRUCK ("H14"," 重型罐式货车"),
    H15_HEAVY_FLATBED_TRUCK ("H15"," 重型平板货车"),
    H16_HEAVY_CONTAINER_TRUCK ("H16"," 重型集装厢车"),
    H17_HEAVY_DUMP_TRUCK ("H17"," 重型自卸货车"),
    H18_HEAVY_SPECIAL_STRUCTURE_TRUCK ("H18"," 重型特殊结构货车"),
    H19_HEAVY_WAREHOUSE_TRUCK ("H19"," 重型仓栅式货车"),
    H20_MEDIUM_TRUCK ("H20"," 中型货车"),
    H21_MEDIUM_SIZED_ORDINARY_TRUCK ("H21"," 中型普通货车"),
    H22_MEDIUM_VAN ("H22"," 中型厢式货车"),
    H23_MEDIUM_CLOSED_TRUCK ("H23"," 中型封闭货车"),
    H24_MEDIUM_TANK_TRUCK ("H24"," 中型罐式货车"),
    H25_MEDIUM_FLAT_TRUCK ("H25"," 中型平板货车"),
    H26_MEDIUM_CONTAINER_TRUCK ("H26"," 中型集装厢车"),
    H27_MEDIUM_DUMP_TRUCK ("H27"," 中型自卸货车"),
    H28_MEDIUM_SPECIAL_STRUCTURE_TRUCK ("H28"," 中型特殊结构货车"),
    H29_MEDIUM_SILO_TRUCK ("H29"," 中型仓栅式货车"),
    H30_LIGHT_TRUCK ("H30"," 轻型货车"),
    H31_LIGHT_ORDINARY_TRUCK ("H31"," 轻型普通货车"),
    H32_LIGHT_VAN ("H32"," 轻型厢式货车"),
    H33_LIGHT_CLOSED_TRUCK ("H33"," 轻型封闭货车"),
    H34_LIGHT_TANK_TRUCK ("H34"," 轻型罐式货车"),
    H35_LIGHT_FLAT_TRUCK ("H35"," 轻型平板货车"),
    H37_LIGHT_DUMP_TRUCK ("H37"," 轻型自卸货车"),
    H38_LIGHT_SPECIAL_STRUCTURE_TRUCK ("H38"," 轻型特殊结构货车"),
    H39_LIGHT_BARN_TRUCK ("H39"," 轻型仓栅式货车"),
    H40__MINIVAN ("H40"," 微型货车"),
    H41_MINI_TRUCK ("H41"," 微型普通货车"),
    H42_MINIVAN ("H42"," 微型厢式货车"),
    H43_MINI_CLOSED_TRUCK ("H43"," 微型封闭货车"),
    H44_MINI_TANK_TRUCK ("H44"," 微型罐式货车"),
    H45_MINI_DUMP_TRUCK ("H45"," 微型自卸货车"),
    H46_MINI_SPECIAL_STRUCTURE_TRUCK ("H46"," 微型特殊结构货车"),
    H47_MINI_BARRIER_TRUCK ("H47"," 微型仓栅式货车"),
    H50_LOW_SPEED_TRUCK ("H50"," 低速货车"),
    H51_ORDINARY_LOW_SPEED_TRUCK ("H51"," 普通低速货车"),
    H52_LOW_SPEED_VAN ("H52"," 厢式低速货车"),
    H53_TANK_LOW_SPEED_TRUCK ("H53"," 罐式低速货车"),
    H54_LOW_SPEED_DUMP_TRUCK ("H54"," 自卸低速货车"),
    H55_WAREHOUSE_TYPE_LOW_SPEED_TRUCK ("H55"," 仓栅式低速货车"),
    Q10_HEAVY_TRACTOR ("Q10"," 重型牵引车"),
    Q11_HEAVY_SEMI_TRAILER_TRACTOR ("Q11"," 重型半挂牵引车"),
    Q12_HEAVY_TRAILER_TRUCK ("Q12"," 重型全挂牵引车"),
    Q20_MEDIUM_TRACTOR ("Q20"," 中型牵引车"),
    Q21_MEDIUM_SIZED_SEMI_TRAILER_TRACTOR ("Q21"," 中型半挂牵引车"),
    Q22_MEDIUM_TRAILER_TRUCK ("Q22"," 中型全挂牵引车"),
    Q30_LIGHT_TRACTOR ("Q30"," 轻型牵引车"),
    Q31_LIGHT_SEMI_TRAILER_TRACTOR ("Q31"," 轻型半挂牵引车"),
    Q32_LIGHT_TRAILER_TRUCK ("Q32"," 轻型全挂牵引车"),
    Z11_LARGE_SCALE_SPECIAL_OPERATION_VEHICLE ("Z11"," 大型专项作业车"),
    Z21_MEDIUM_SPECIAL_OPERATION_VEHICLE ("Z21"," 中型专项作业车"),
    Z31_SMALL_SPECIAL_OPERATION_VEHICLE ("Z31"," 小型专项作业车"),
    Z41_MINI_SPECIAL_OPERATION_VEHICLE ("Z41"," 微型专项作业车"),
    Z51_HEAVY_SPECIAL_OPERATION_VEHICLE ("Z51"," 重型专项作业车"),
    Z71_LIGHT_SPECIAL_OPERATION_VEHICLE ("Z71"," 轻型专项作业车"),
    D11_TROLLEYBUS ("D11"," 无轨电车"),
    D12_TRAM ("D12"," 有轨电车"),
    M10_THREE_WHEELED_MOTORCYCLE ("M10"," 三轮摩托车"),
    M11_ORDINARY_REGULAR_THREE_WHEELED_MOTORCYCLE ("M11"," 普通正三轮摩托车"),
    M12_LIGHTWEIGHT_TRICYCLE ("M12"," 轻便正三轮摩托车"),
    M13_THREE_WHEELED_PASSENGER_MOTORCYCLE ("M13"," 正三轮载客摩托车"),
    M14_THREE_WHEELED_CARGO_MOTORCYCLE ("M14"," 正三轮载货摩托车"),
    M15_SIDE_TRICYCLE ("M15"," 侧三轮摩托车"),
    M20_TWO_WHEELED_MOTORCYCLE ("M20"," 二轮摩托车"),
    M21_  ordinary_two_wheeled_motorcycle ("M21"," 普通二轮摩托车"),
    M22_  Moped ("M22"," 轻便二轮摩托车"),
    N11_  Tricycle ("N11"," 三轮汽车"),
    T11_  large_wheeled_tractor ("T11"," 大型轮式拖拉机"),
    T20_  small_tractor ("T20"," 小型拖拉机"),
    T21_  small_wheeled_tractor ("T21"," 小型轮式拖拉机"),
    T22_  walking_tractor ("T22"," 手扶拖拉机"),
    T23_  walking_deformation_conveyor ("T23"," 手扶变形运输机"),
    J11_  wheel_loader ("J11"," 轮式装载机械"),
    J12_  wheel_excavator ("J12"," 轮式挖掘机械"),
    J13_  wheeled_grader ("J13"," 轮式平地机械"),
    G10_  heavy_duty_full_trailer ("G10"," 重型全挂车"),
    G11_  heavy_duty_ordinary_full_trailer ("G11"," 重型普通全挂车"),
    G12_  heavy_van_trailer ("G12"," 重型厢式全挂车"),
    G13_  heavy_tank_trailer ("G13"," 重型罐式全挂车"),
    G14_  heavy_flat_trailer ("G14"," 重型平板全挂车"),
    G15_  heavy_container_trailer ("G15"," 重型集装箱全挂车"),
    G16_  heavy_duty_dump_truck ("G16"," 重型自卸全挂车"),
    G17_  heavy_rack_trailer ("G17"," 重型仓栅式全挂车"),
    G18_  heavy_caravan_trailer ("G18"," 重型旅居全挂车"),
    G19_  重型专项作业全挂车 ("G19"," 重型专项作业全挂车"),
    G20_  中型全挂车 ("G20"," 中型全挂车"),
    G21_  中型普通全挂车 ("G21"," 中型普通全挂车"),
    G22_  中型厢式全挂车 ("G22"," 中型厢式全挂车"),
    G23_  中型罐式全挂车 ("G23"," 中型罐式全挂车"),
    G24_  中型平板全挂车 ("G24"," 中型平板全挂车"),
    G25_  中型集装箱全挂车 ("G25"," 中型集装箱全挂车"),
    G26_  中型自卸全挂车 ("G26"," 中型自卸全挂车"),
    G27_  中型仓栅式全挂车 ("G27"," 中型仓栅式全挂车"),
    G28_  中型旅居全挂车 ("G28"," 中型旅居全挂车"),
    G29_  中型专项作业全挂车 ("G29"," 中型专项作业全挂车"),
    G30_  轻型全挂车 ("G30"," 轻型全挂车"),
    G31_  轻型普通全挂车 ("G31"," 轻型普通全挂车"),
    G32_  轻型厢式全挂车 ("G32"," 轻型厢式全挂车"),
    G33_  轻型罐式全挂车 ("G33"," 轻型罐式全挂车"),
    G34_  轻型平板全挂车 ("G34"," 轻型平板全挂车"),
    G35_  轻型自卸全挂车 ("G35"," 轻型自卸全挂车"),
    G36_  轻型仓栅式全挂车 ("G36"," 轻型仓栅式全挂车"),
    G37_  轻型旅居全挂车 ("G37"," 轻型旅居全挂车"),
    G38_  轻型专项作业全挂车 ("G38"," 轻型专项作业全挂车"),
    B10_  重型半挂车 ("B10"," 重型半挂车"),
    B11_  重型普通半挂车 ("B11"," 重型普通半挂车"),
    B12_  重型厢式半挂车 ("B12"," 重型厢式半挂车"),
    B13_  重型罐式半挂车 ("B13"," 重型罐式半挂车"),
    B14_  重型平板半挂车 ("B14"," 重型平板半挂车"),
    B15_  重型集装箱半挂车 ("B15"," 重型集装箱半挂车"),
    B16_  重型自卸半挂车 ("B16"," 重型自卸半挂车"),
    B17_  重型特殊结构半挂车 ("B17"," 重型特殊结构半挂车"),
    B18_  重型仓栅式半挂车 ("B18"," 重型仓栅式半挂车"),
    B19_  重型旅居半挂车 ("B19"," 重型旅居半挂车"),
    B1A_  重型专项作业半挂车 ("B1A"," 重型专项作业半挂车"),
    B1B_  重型低平板半挂车 ("B1B"," 重型低平板半挂车"),
    B20_  中型半挂车 ("B20"," 中型半挂车"),
    B21_  中型普通半挂车 ("B21"," 中型普通半挂车"),
    B22_  中型厢式半挂车 ("B22"," 中型厢式半挂车"),
    B23_  中型罐式半挂车 ("B23"," 中型罐式半挂车"),
    B24_  中型平板半挂车 ("B24"," 中型平板半挂车"),
    B25_  中型集装箱半挂车 ("B25"," 中型集装箱半挂车"),
    B26_  中型自卸半挂车 ("B26"," 中型自卸半挂车"),
    B27_  中型特殊结构半挂车 ("B27"," 中型特殊结构半挂车"),
    B28_  中型仓栅式半挂车 ("B28"," 中型仓栅式半挂车"),
    B29_  中型旅居半挂车 ("B29"," 中型旅居半挂车"),
    B2A_  中型专项作业半挂车 ("B2A"," 中型专项作业半挂车"),
    B2B_  中型低平板半挂车 ("B2B"," 中型低平板半挂车"),
    B30_  轻型半挂车 ("B30"," 轻型半挂车"),
    B31_  轻型普通半挂车 ("B31"," 轻型普通半挂车"),
    B32_  轻型厢式半挂车 ("B32"," 轻型厢式半挂车"),
    B33_  轻型罐式半挂车 ("B33"," 轻型罐式半挂车"),
    B34_  轻型平板半挂车 ("B34"," 轻型平板半挂车"),
    B35_  轻型自卸半挂车 ("B35"," 轻型自卸半挂车"),
    B36_  轻型仓栅式半挂车 ("B36"," 轻型仓栅式半挂车"),
    B37_  轻型旅居半挂车 ("B37"," 轻型旅居半挂车"),
    B38_  轻型专项作业半挂车 ("B38"," 轻型专项作业半挂车"),
    B39_  轻型低平板半挂车 ("B39"," 轻型低平板半挂车"),
    X99_  其他 ("X99"," 其他"),


    ;
    private final String code;

    private final String name;

    VehicleTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String getName(String name) {
        for (VehicleTypeEnum item : VehicleTypeEnum.values()) {
            if (item.name().equals(name)) {
                return item.name;
            }
        }
        return name;
    }

    public static String getCode(String name) {
        for (VehicleTypeEnum item : VehicleTypeEnum.values()) {
            if (item.name().equals(name)) {
                return item.code;
            }
        }
        return null;
    }

}
