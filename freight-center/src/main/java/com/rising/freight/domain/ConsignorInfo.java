package com.rising.freight.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 描述：
 * 网络货运平台车辆基础数据存储
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2020-12-31
 */
@Entity
@Table(name = "internet_consignor_info")
@Getter
@Setter
public class ConsignorInfo extends Model {

    // 托运人名称	1..1	an..512	必填。
    private String consignor;

    // 托运人统一社会信用代码或个人证件号	1..1	an..35	必填。
    private String ConsignorID;

    // 装货地址	0..1	an..256	选填，实际装货的地点。
    private String placeOfLoading;

    // 装货地点的国家行政区划代码	1..1	an..12	必填，参照最新版《中华人民共和国行政区划代码》（GB/T 2260-2017），精确到区县。
    private String countrySubdivisionCode;

}
