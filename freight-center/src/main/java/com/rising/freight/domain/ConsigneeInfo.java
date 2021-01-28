package com.rising.freight.domain;


import java.io.Serializable;

/**
 * 描述：
 * 网络货运平台车辆基础数据存储
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2020-12-31
 */
/*@Entity
@Table(name = "internet_consignee_info")
@Getter
@Setter*/
public class ConsigneeInfo extends Model {

    // 收货方名称	1..1	an..512	必填。
    private String consignee;


    // 收货方统一社会信用代码或个人证件号码	1..1	an..35	必填。
    private String consigneeID;

    // 收货地址	0..1	an..256	选填，实际装货的地点。
    private String goodsReceiptPlace;

    // 收货地点的国家行政区划代码	1..1	an..12	必填，参照最新版《中华人民共和国行政区划代码》（GB/T 2260-2017），精确到区县。
    private String countrySubdivisionCode;

}
