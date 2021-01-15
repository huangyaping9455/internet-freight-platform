package com.rising.freight.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 描述：电子运单驾驶员

 * 作者：李启云
 * 日期：2020-12-31
 */
@Builder
@Data
public class ShippingDriver {
    // 承运驾驶员姓名
    private String driverName;
    // 驾驶员身份证号
    private String drivingLicense;
}
