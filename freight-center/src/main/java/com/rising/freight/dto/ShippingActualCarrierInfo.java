package com.rising.freight.dto;

import com.rising.freight.domain.Model;

/**
 * 描述：实际承运人信息
 * <p>
 * 作者：李启云
 * 日期：2020-12-31
 */


public class ShippingActualCarrierInfo extends Model {

    // 实际承运人名称	1..1	an..256	必填，与网络货运经营者签订运输合同，实际完成运输的经营者。取得道路运输经营许可证的个体运输业户，直接填写“许可证上的业户名称”；其他情况填写“运输公司名称（合同签订人姓名）”。
    private String actualCarrierName;
    // 实际承运人统一社会信用代码或证件号码	1..1	an..50	必填。
    private String actualCarrierId;
    // 实际承运人道路运输经营许可证号	1..1	an..50	必填，实际承运人的道路运输经营许可证编号，网络货运经营者整合车辆全部为总质量 4.5吨及以下普通货运车辆的，可填“车籍地 6 位行政区域代码+000000”。
    private String actualCarrierBusinessLicense;
}
