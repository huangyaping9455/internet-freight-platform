package com.rising.enums;

/**
 * 版本：1.0.0
 * 描述：车辆类型的枚举
 *
 * @see Enum
 * 码农：李齐云
 * 日期：2021-03-01
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
    M21_ORDINARY_TWO_WHEELED_MOTORCYCLE ("M21"," 普通二轮摩托车"),
    M22_MOPED ("M22"," 轻便二轮摩托车"),
    N11_TRICYCLE ("N11"," 三轮汽车"),
    T11_LARGE_WHEELED_TRACTOR ("T11"," 大型轮式拖拉机"),
    T20_SMALL_TRACTOR ("T20"," 小型拖拉机"),
    T21_SMALL_WHEELED_TRACTOR ("T21"," 小型轮式拖拉机"),
    T22_WALKING_TRACTOR ("T22"," 手扶拖拉机"),
    T23_WALKING_DEFORMATION_CONVEYOR ("T23"," 手扶变形运输机"),
    J11_WHEEL_LOADER ("J11"," 轮式装载机械"),
    J12_WHEEL_EXCAVATOR ("J12"," 轮式挖掘机械"),
    J13_WHEELED_GRADER ("J13"," 轮式平地机械"),
    G10_HEAVY_DUTY_FULL_TRAILER ("G10"," 重型全挂车"),
    G11_HEAVY_DUTY_ORDINARY_FULL_TRAILER ("G11"," 重型普通全挂车"),
    G12_HEAVY_VAN_TRAILER ("G12"," 重型厢式全挂车"),
    G13_HEAVY_TANK_TRAILER ("G13"," 重型罐式全挂车"),
    G14_HEAVY_FLAT_TRAILER ("G14"," 重型平板全挂车"),
    G15_HEAVY_CONTAINER_TRAILER ("G15"," 重型集装箱全挂车"),
    G16_HEAVY_DUTY_DUMP_TRUCK ("G16"," 重型自卸全挂车"),
    G17_HEAVY_RACK_TRAILER ("G17"," 重型仓栅式全挂车"),
    G18_HEAVY_CARAVAN_TRAILER ("G18"," 重型旅居全挂车"),
    G19_HEAVY_SPECIAL_OPERATION_TRAILER ("G19"," 重型专项作业全挂车"),
    G20_MEDIUM_FULL_TRAILER ("G20"," 中型全挂车"),
    G21_MEDIUM_SIZED_ORDINARY_FULL_TRAILER ("G21"," 中型普通全挂车"),
    G22_MEDIUM_VAN_TRAILER ("G22"," 中型厢式全挂车"),
    G23_MEDIUM_TANK_TRAILER ("G23"," 中型罐式全挂车"),
    G24_MEDIUM_FLAT_TRAILER ("G24"," 中型平板全挂车"),
    G25_MEDIUM_CONTAINER_TRAILER ("G25"," 中型集装箱全挂车"),
    G26_MEDIUM_DUMP_TRUCK ("G26"," 中型自卸全挂车"),
    G27_MEDIUM_SIZED_FULL_TRAILER ("G27"," 中型仓栅式全挂车"),
    G28_MEDIUM_CARAVAN_TRAILER ("G28"," 中型旅居全挂车"),
    G29_MEDIUM_SIZED_SPECIAL_OPERATION_FULL_TRAILER ("G29"," 中型专项作业全挂车"),
    G30_LIGHT_FULL_TRAILER ("G30"," 轻型全挂车"),
    G31_LIGHT_ORDINARY_FULL_TRAILER ("G31"," 轻型普通全挂车"),
    G32_LIGHT_VAN_TRAILER ("G32"," 轻型厢式全挂车"),
    G33_LIGHT_TANK_TRAILER ("G33"," 轻型罐式全挂车"),
    G34_LIGHT_FLAT_TRAILER ("G34"," 轻型平板全挂车"),
    G35_LIGHT_DUMP_TRAILER ("G35"," 轻型自卸全挂车"),
    G36_LIGHT_RACK_TRAILER ("G36"," 轻型仓栅式全挂车"),
    G37_LIGHT_CARAVAN_TRAILER ("G37"," 轻型旅居全挂车"),
    G38_FULL_TRAILER_FOR_LIGHT_SPECIAL_OPERATION ("G38"," 轻型专项作业全挂车"),
    B10_HEAVY_SEMI_TRAILER ("B10"," 重型半挂车"),
    B11_HEAVY_DUTY_SEMI_TRAILER ("B11"," 重型普通半挂车"),
    B12_HEAVY_VAN_SEMI_TRAILER ("B12"," 重型厢式半挂车"),
    B13_HEAVY_TANK_SEMITRAILER ("B13"," 重型罐式半挂车"),
    B14_HEAVY_DUTY_FLAT_SEMI_TRAILER ("B14"," 重型平板半挂车"),
    B15_HEAVY_CONTAINER_SEMI_TRAILER ("B15"," 重型集装箱半挂车"),
    B16_HEAVY_DUMP_SEMI_TRAILER ("B16"," 重型自卸半挂车"),
    B17_HEAVY_SPECIAL_STRUCTURE_SEMI_TRAILER ("B17"," 重型特殊结构半挂车"),
    B18_HEAVY_RACK_SEMI_TRAILER ("B18"," 重型仓栅式半挂车"),
    B19_HEAVY_CARAVAN_SEMITRAILER ("B19"," 重型旅居半挂车"),
    B1A_HEAVY_DUTY_SPECIAL_OPERATION_SEMI_TRAILER ("B1A"," 重型专项作业半挂车"),
    B1B_HEAVY_LOW_FLAT_SEMI_TRAILER ("B1B"," 重型低平板半挂车"),
    B20_MEDIUM_SEMI_TRAILER ("B20"," 中型半挂车"),
    B21_MEDIUM_SIZED_ORDINARY_SEMITRAILER ("B21"," 中型普通半挂车"),
    B22_MEDIUM_VAN_SEMITRAILER ("B22"," 中型厢式半挂车"),
    B23_MEDIUM_TANK_SEMITRAILER ("B23"," 中型罐式半挂车"),
    B24_MEDIUM_FLAT_SEMI_TRAILER ("B24"," 中型平板半挂车"),
    B25_MEDIUM_CONTAINER_SEMI_TRAILER ("B25"," 中型集装箱半挂车"),
    B26_MEDIUM_DUMP_SEMI_TRAILER ("B26"," 中型自卸半挂车"),
    B27_MEDIUM_SPECIAL_STRUCTURE_SEMI_TRAILER ("B27"," 中型特殊结构半挂车"),
    B28_MEDIUM_SIZED_GRATE_SEMI_TRAILER ("B28"," 中型仓栅式半挂车"),
    B29_MEDIUM_SIZED_RECREATIONAL_SEMITRAILER ("B29"," 中型旅居半挂车"),
    B2A_MEDIUM_SIZED_SPECIAL_OPERATION_SEMI_TRAILER ("B2A"," 中型专项作业半挂车"),
    B2B_MEDIUM_LOW_FLAT_SEMI_TRAILER ("B2B"," 中型低平板半挂车"),
    B30_LIGHT_SEMI_TRAILER ("B30"," 轻型半挂车"),
    B31_LIGHT_ORDINARY_SEMITRAILER ("B31"," 轻型普通半挂车"),
    B32_LIGHT_VAN_SEMI_TRAILER ("B32"," 轻型厢式半挂车"),
    B33_LIGHT_TANK_SEMITRAILER ("B33"," 轻型罐式半挂车"),
    B34_LIGHT_FLAT_SEMI_TRAILER ("B34"," 轻型平板半挂车"),
    B35_LIGHT_DUMP_SEMI_TRAILER ("B35"," 轻型自卸半挂车"),
    B36_LIGHT_RACK_SEMITRAILER ("B36"," 轻型仓栅式半挂车"),
    B37_LIGHT_CARAVAN_SEMITRAILER ("B37"," 轻型旅居半挂车"),
    B38_LIGHT_SPECIAL_OPERATION_SEMI_TRAILER ("B38"," 轻型专项作业半挂车"),
    B39_LIGHT_LOW_FLAT_SEMI_TRAILER ("B39"," 轻型低平板半挂车"),
    X99_OTHER ("X99"," 其他"),







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
