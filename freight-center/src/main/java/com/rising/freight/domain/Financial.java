package com.rising.freight.domain;

import com.rising.common.web.annotation.Comment;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 描述：资金流水业务表
 * 创建时间：2020-03-19 13:45:22
 * 创建作者：罗毅涵
 */
//@Table(name = "internet_financial")
//@Entity
@Getter
@Setter
public class

Financial extends Model {
    private static final long serialVersionUID = 1L;


    //单证号	1…1	an..35	必填，本资金流水单号。
    @Comment("资金流水单号")
    private  String documentNumber;
    //资金流水单上传时间	1..1	an..14	必填，本资金流水单上传到省级监测系统的时间。
//    @JsonSerialize(using = CustomDateTimeFormlessChange.class)
    @Comment("资金流水单上传到省级监测系统的时间")
    private LocalDateTime sendToProDateTime;
    // 实际承运人名称	1..1	an..512	必填，对应运单技术规范中第 44 项。
    private  String carrier;
    // 实际承运人统一社会信用代码或证件号码	1..1	an..50	必填，对应运单技术规范中第 46 项。
    private  String actualCarrierId;
    // 车辆牌照号	1..1	an..35	对应运单技术规范中第 26 项。
    private  String vehicleNumber;
    // 车牌颜色代码	1..1	n..2	对应运单技术规范中第 27 项。
    /**
     * 代码 名称 代码 名称
     * 1 蓝色     4 白色
     * 2 黄色     5 绿色
     * 3 黑色     9 其他
     * 91 农黄色  92 农绿色
     * 93 黄绿色  94 渐变绿
     */
    private  Integer vehiclePlateColorCode;
    // 总金额	1..1	n..18,3	该笔运输实际发生费用，含燃油、路桥费和实际支付金额。
//    @JsonSerialize(using = CustomBigDecimalThreeChange.class)
//    private BigDecimal totalMonetaryAmount;
    // 运单列表
//    @OneToMany(mappedBy = "financial")
//    private Set<FinancialShippingNote> shippingNoteList ;
//    // 财务列表
//    @OneToMany
//    private Set<FinancialStatement> financiallist;
    // 备注
//   private String remark;

}
