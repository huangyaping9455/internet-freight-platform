package com.rising.freight.dto;


import com.rising.freight.domain.Model;
import com.rising.freight.domain.ShippingGoods;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 描述：电子运单运输车辆
 * <p>
 * 作者：李启云
 * 日期：2020-12-31
 */

public class ShippingVehicleInfo extends Model {

    // 车牌颜色代码	1..1	an..2	必填，代码集参见wlhy.mot.gov.cn。
    /**
     * 代码 名称 代码 名称
     * 1 蓝色 4 白色
     * 2 黄色 5 绿色
     * 3 黑色 9 其他
     * 91 农黄色 92 农绿色
     * 93 黄绿色 94 渐变绿
     */
    private String vehiclePlateColorCode;
    // 车辆牌照号	1..1	an..35	必填。
    private String vehicleNumber;

}
