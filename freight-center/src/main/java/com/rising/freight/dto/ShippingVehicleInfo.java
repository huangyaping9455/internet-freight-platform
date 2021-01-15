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

    // 驾驶员信息（多个）
    private List<ShippingDriver> driver;
    // 货物信息（多个）
    private List<ShippingGoods> goods;
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
    // 发货日期时间	0..1	n14	如果为分段运输必填，本车的发货时间 YYYYMMDDhhmmss
//    @JsonSerialize(using = CustomDateTimeFormlessChange.class)
    private LocalDateTime despatchActualDateTime;
    // 收货日期时间	0..1	n14	如果为分段运输必填，本车的收货时间 YYYYMMDDhhmmss
//    @JsonSerialize(using = CustomDateTimeFormlessChange.class)
    private LocalDateTime goodsReceiptDateTime;
    // 装货地址	0..1	an..256	如果为分段运输必填，本车的装货的地点。
    private String placeOfLoading;
    // 收货地址	0..1	an..256	如果为分段运输必填，本车拉货终点。
    private String goodsReceiptPlace;
    // 装货地址的国家行政区划代码或国别代码	0..1	an..12	如果为分段运输必填，代码集参见
    //wlhy.mot.gov.cn。loading_country_subdivision_code
    private String loadingCountrySubdivisionCode;
    // 收货地址的国家行政区划代码或国别代码	0..1	an..12	如果为分段运输必填，代码集参见
    //wlhy.mot.gov.cn。 receipt_country_subdivision_code
    private String receiptCountrySubdivisionCode;
}
