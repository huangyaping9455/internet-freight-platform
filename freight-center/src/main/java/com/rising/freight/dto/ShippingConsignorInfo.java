package com.rising.freight.dto;

import com.rising.freight.domain.Model;

/**
 * 描述：托运人信息
 * 托运人信息
 * 作者：李启云
 * 日期：2020-12-31
 */

public class ShippingConsignorInfo extends Model {
    // 托运人名称	1..1	an..512	必填。
    private String consignor;
    // 托运人统一社会信用代码或个人证件号	1..1	an..35	必填。
    private String consignorId;
    //  装货地址	1..1	an..256	必填，本单货物的装货的地点。
    private String placeOfLoading;
    // 装货地点的国家行政区划代码或国别代码	1..1	an..12	必填，代码集参见wlhy.mot.gov.cn。
    private String countrySubdivisionCode;

}
