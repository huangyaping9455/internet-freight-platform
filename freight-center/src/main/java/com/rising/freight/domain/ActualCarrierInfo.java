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
@Table(name = "internet_actual_carrier_info")
@Getter
@Setter
public class ActualCarrierInfo extends Model {

    // 实际承运人名称	1..1	an..256	必填，与网络货运经营者签订运输合同，实际完成运输的经营者。
    //取得道路运输经营许可证的个体运输业户，直接填写“许可证上的业户名称”；
    //其他情况填写“运输公司名称（实际承运驾驶员姓名）”。
    private String actualCarrierName;

    // 实际承运人道路运输经营许可证号	1..1	an..50	必填，实际承运人的道路运输经营许可证编号，网络货运经营者整合车辆全部为总质量4.5吨及以下普通货运车辆的，可填“车籍地6位行政区域代码+000000”。
    private String actualCarrierBusinessLicense;

    // 实际承运人统一社会信用代码或证件号码	1..1	an..50	必填。
    private String actualCarrierID;

}
