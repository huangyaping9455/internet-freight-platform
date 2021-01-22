package com.rising.freight.dto;

import com.rising.enums.MessageTypeEnum;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class SendMessageDto implements Serializable {

    private static final long serialVersionUID = 849658329159778636L;
    private MessageTypeEnum messageTypeEnum;

    //*************************网络货运平台车辆基础数据************************************
    private String carId;

    // 车辆牌照号	1..1	an..35	必填，对应运单技术规范第 26 项。
    private String vehicleNumber;
    /**
     * 代码 名称 代码 名称
     * 1 蓝色 4 白色
     * 2 黄色 5 绿色
     * 3 黑色 9 其他
     * 91 农黄色 92 农绿色
     * 93 黄绿色 94 渐变绿
     */
    // 车牌颜色代码	1..1	an..2	必填，21。
    private String vehiclePlateColorCode;
    // 车辆类型代码	1..1	an..3	必填。参考机动车行驶证填写，代码集参见 wlhy.mot.gov.cn。
    /**
     * 太多了 自己去文档找去
     */
    private String vehicleType;
    // 所有人	0..1	an..128	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。
    private String owner;
    // 使用性质	0..1	an..20	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。
    private String useCharacter;
    // 车辆识别代号	0..1	an..32	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。
    private String vin;
    // 发证机关	0..1	an..128	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。
    private String issuingOrganizations;
    // 注册日期	0..1	n8	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。YYYYMMDD

    private String registerDate;
    // 发证日期	0..1	n8	总质量 4.5 吨及以下普通货运车辆必填，按照机动车行驶证填写。YYYYMMDD

    private String issueDate;
    /**
     * 代 码 能源类型 说明
     * A 汽油
     * B 柴油
     * C 电 以电能驱动的汽车
     * D 混合油
     * E 天然气
     * F 液化石油气
     * L 甲醇
     * M 乙醇
     * N 太阳能
     * O 混合动力
     * Y 无 仅限全挂车等无动力的
     * Z 其他
     */
    // 车辆能源类型	1..1	an..12	必填，代码集参见wlhy.mot.gov.cn。
    private String vehicleEnergyType;
    // 核定载质量	1..1	n..9,2	必填，参考机动车行驶证填写，默认单位：
    //吨，保留两位小数，如整数的话，以.00 填
    //充。小数点不计入总长。
    private BigDecimal vehicleTonnage;
    // 吨位	1..1	n..9,2	必填，车辆总质量，默认单位：吨，保留两
    //位小数，如整数的话，以.00 填充。小数点不计入总长
    private BigDecimal grossMass;
    // 道路运输证号	1..1	n..20	必填，总质量 4.5 吨及以下普通货运车辆
    //的，可填“车籍地 6 位行政区域代码
    //+000000”。
    private Long roadTransportCertificateNumber;
    // 挂车牌照号	0..1	an..35	选填。
    private String trailerVehiclePlateNumber;
    // 备注	0..1	an..256	选填。
    private String carRemark;
    //*************************网络货运平台车辆基础数据************************************

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //*************************网络货运平台驾驶员基础数据************************************
    private String driverId;
    // 姓名	1..1	an..30	必填。对应运单技术规范第 35 项
    private String driverName;
    // 身份证号	1..1	an..18	必填。对应运单技术规范第 36 项
    private String drivingLicense;
    // 准驾车型	0..1	an..20	使用总质量 4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员必填，根据机动车驾驶证填写。
    private String vehicleClass;

    // 驾驶证有效期自	0..1	n8	使用总质量 4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员必填，根据机动车驾驶证填写。YYYYMMDD
//    @JsonSerialize(using = CustomDateFormlessChange.class)
    private String validPeriodFrom;
    // 驾驶证有效期至	0..1	n8	使用总质量 4.5 吨及以下普通货运车辆从事
    //普通货物运输经营的驾驶员必填，根据机动车驾驶证填写。YYYYMMDD
//    @JsonSerialize(using = CustomDateFormlessChange.class)
    private String validPeriodTo;
    // 从业资格证号	1..1	an..18	必填，驾驶员从业资格证号，使用总质量4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员，填写“驾驶员身份证前 6位+000000000000”。
    private String qualificationCertificate;
    // 手机号码	1..1	an..18	必填。
    private String telephone;
    // 备注	0..1	an..256	选填。
    private String driverRemark;

    //*************************网络货运平台驾驶员基础数据************************************
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //*************************网络货运平台电子运单基础数据************************************
    // 电子运单id MongoDB存储使用
    private String shippingNodeId;

    // 原始单号 必填，上游企业委托运输单号。 an..35
    private String originalDocumentNumber;
    // 运单号 必填，运单号。 an..20
    private String shippingNoteNumber;
    // 分段分单号	1..1	an..4	必填，分段运输和多车运输由四位数字组成， 前两位代表一单多车的序号，后两位代表分段序号。若运输形式为一单一车填 0000。
    private String serialNumber;
    // 运输总车辆数	1..1	n..4	必填，同一运单号的货物总共使用的运输车辆总数
    private Integer vehicleAmount;
    // 运输组织类型代码	1..1	n..2	必填，代码集参见wlhy.mot.gov.cn。
    /**
     * 代码 名称
     * 1 公路运输
     * 2 公铁联运
     * 3 公水联运
     * 4 公空联运
     * 5 公铁水联运
     * 6 公铁空联运
     * 7 公水空联运
     * 8 公铁水空联运
     */
    private Integer transportTypeCode;
    // 运单上传时间	1..1	n14	必填，网络货运经营者上传运单到省级监测系统的时间。YYYYMMDDhhmmss
//    @JsonSerialize(using = CustomDateTimeFormlessChange.class)
    private String sendToProDateTime;
    // 网络货运经营者名称	1..1	an..512	必填。
    private String carrier;
    // 统一社会信用代码	1..1	an18	必填。
    private String unifiedSocialCreditIdentifier;
    // 道路运输经营许可证编号	1..1	an..50	必填，网络货运经营者的道路运输经营许可证编号。
    private String permitNumber;
    // 运单生成时间	1..1	n14	必填，网络货运经营者信息系统正式成交生成运单的日期时间。YYYYMMDDhhmmss
//    @JsonSerialize(using = CustomDateTimeFormlessChange.class)
    private String consignmentDateTime;
    // 业务类型代码	1..1	an..7	必填，代码集参见wlhy.mot.gov.cn。
    /**
     * 代 码    名 称        描 述
     * 1002996 干线普货运输 干线普货运输服务
     * 1003997 城市配送 在城市范围内进行配送
     * 1003998 农村配送 若发货方或收货方在农村地区即为农村物流
     * 1002998 集装箱运输 集装箱运输
     * 1003999 其他 其他
     */
    private String businessTypeCode;
    // 发货日期时间	1..1	n14	必填，本单货物的发货时间 YYYYMMDDhhmmss
//    @JsonSerialize(using = CustomDateTimeFormlessChange.class)
    private String despatchActualDateTime;
    // 收货日期时间	1..1	n14	必填，本单货物的收货时间YYYYMMDDhhmmss
//    @JsonSerialize(using = CustomDateTimeFormlessChange.class)
    private String goodsReceiptDateTime;
    // 托运人信息
    // 托运人名称	1..1	an..512	必填。
    private String consignor;
    // 托运人统一社会信用代码或个人证件号	1..1	an..35	必填。
    private String consignorId;
    //  装货地址	1..1	an..256	必填，本单货物的装货的地点。
    private String placeOfLoading;
    // 装货地点的国家行政区划代码或国别代码	1..1	an..12	必填，代码集参见wlhy.mot.gov.cn。
    private String countrySubdivisionCode;
    // 收货方信息
    //  收货方名称	1..1	an..512	必填。
    private String consignee;
    // 收货方统一社会信用代码或个人证件号码	0..1	an.35	选填。
    private String consigneeId;
    // 收货地址	1..1	an..256	必填，本单货物的收货的地点
    private String goodsReceiptPlace;

    // 运费金额	1..1	n..18,3	必填，托运人与网络货运经营者签订运输合同确定的运费金额，货币单位为人民币（元）， 保留 3 位小数，如整数的话，以.000 填充。如是一笔业务分几辆车运，需将托运人针对这笔业务付给网络货运经营者的运输费用分摊到每辆车上。

    private BigDecimal totalMonetaryAmount;

    // 实际承运人信息
    // 实际承运人名称	1..1	an..256	必填，与网络货运经营者签订运输合同，实际完成运输的经营者。取得道路运输经营许可证的个体运输业户，直接填写“许可证上的业户名称”；其他情况填写“运输公司名称（合同签订人姓名）”。
    private String actualCarrierName;
    // 实际承运人统一社会信用代码或证件号码	1..1	an..50	必填。
    private String actualCarrierId;
    // 实际承运人道路运输经营许可证号	1..1	an..50	必填，实际承运人的道路运输经营许可证编号，网络货运经营者整合车辆全部为总质量 4.5吨及以下普通货运车辆的，可填“车籍地 6 位行政区域代码+000000”。
    private String actualCarrierBusinessLicense;
    // 保险信息
    // 保险单号	1..1	an..30	必填，未投保的，可填“none”。
    private String policyNumber;
    // 保险公司代码	1..1	an..30	必填，代码集参见wlhy.mot.gov.cn。未投保的，可填“none”。
    private String insuranceCompanyCode;
    // 备注
    private String shippingNodeRemark;
    //*************************网络货运平台电子运单基础数据************************************

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    //*************************网络货运平资金流水基础数据************************************
    private String financialId;

    //单证号	1…1	an..35	必填，本资金流水单号。
    private String documentNumber;

    // 运单列表
    // 托运单号	1..1	an..20	必填，对应运单技术规范中第 2 项。

    // 财务列表()
    //付款方式代码	1..1	an..3	必填，代码集参见wlhy.mot.gov.cn。
    private String paymentMeansCode;
    // 收款方名称	1..1	an..512	必填。
    private String recipient;
    // 收款帐户信息	1..1	an..512	必填，银行卡号或其他收款帐号。
    private String receiptAccount;
    // 收款方银行代码	0..1	an..11	选填，代码集参见wlhy.mot.gov.cn。
    private String bankCode;
    // 流水号/序列号	1..1	an..50	必填，银行或第三方支付平台的资金流水单号。
    private String sequenceCode;
    // 实际支付金额	1..1	n..18,3	必填，资金流水金额，货币单位为人民币，
    //保留 3 位小数，如整数的话，以.000 填充。

    private BigDecimal monetaryAmount;
    // 日期时间	1..1	n14	资金流水实际发生时间。YYYYMMDDhhmmss

    private LocalDateTime dateTime;


    //*************************网络货运平资金流水基础数据************************************


}


