package com.rising.freight.dto;

import com.rising.freight.domain.Model;

/**
 * 描述：电子运单保险信息数据存储
 * <p>
 * 作者：李启云
 * 日期：2020-12-31
 */

public class ShippingInsuranceInformation extends Model {

    // 保险单号	1..1	an..30	必填，未投保的，可填“none”。
    private String policyNumber;
    // 保险公司代码	1..1	an..30	必填，代码集参见wlhy.mot.gov.cn。未投保的，可填“none”。
    private String insuranceCompanyCode;
}
