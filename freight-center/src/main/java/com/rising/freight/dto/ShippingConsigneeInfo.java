package com.rising.freight.dto;

import com.rising.freight.domain.Model;

/**
 * 描述：收货方信息
 * <p>
 * 作者：李启云
 * 日期：2020-12-31
 */

public class ShippingConsigneeInfo extends Model {
    //  收货方名称	1..1	an..512	必填。
    private String consignee;
    // 收货方统一社会信用代码或个人证件号码	0..1	an.35	选填。
    private String consigneeId;
    // 收货地址	1..1	an..256	必填，本单货物的收货的地点
    private String goodsReceiptPlace;
    // 收货地点的国家行政区划代码或国别代码	1..1	an..12	必填，代码集参见wlhy.mot.gov.cn。
    private String countrySubdivisionCode;
}
