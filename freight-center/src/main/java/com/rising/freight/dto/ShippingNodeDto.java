package com.rising.freight.dto;


import com.rising.freight.domain.*;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 描述：
 * 网络货运平台车辆基础数据存储
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2020-12-31
 */
@Data
public class ShippingNodeDto implements Serializable {
    private String id;




    // 托运人信息
    private ConsignorInfo consignorInfo;
    // 收货方信息
    private ConsigneeInfo consigneeInfo;
    // 实际承运人信息
    private ActualCarrierInfo actualCarrierInfo;
    // 保险信息
    private InsuranceInformation insuranceInformation;
    // 车辆信息
    private InternetCar vehicleInfo;
    // 司机信息
    private InternetDriver driver;
    // 货物信息
    private ShippingGoods goodsInfo;





//    private Set<ConsignorInfo> consignorInfo = new HashSet<>();
//    private Set<ConsigneeInfo> consigneeInfo = new HashSet<>();
//    private Set<ActualCarrierInfo> actualCarrierInfo = new HashSet<>();
//      private Set<InsuranceInformation> insuranceInformation = new HashSet<>();
//    private Set<VehicleInfo> vehicleInfo = new HashSet<>();
//      private Set<Driver> driver = new HashSet<>();
//      private Set<GoodsInfo> goodsInfo = new HashSet<>();
    // 原始单号 必填，上游企业委托运输单号。 an..35
    private String originalDocumentNumber;
    // 托运单号 必填，本运单单号。 an..20
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
    private LocalDateTime sendToProDateTime;
    // 网络货运经营者名称	1..1	an..512	必填。
    private String carrier;
    // 统一社会信用代码	1..1	an18	必填。
    private String unifiedSocialCreditIdentifier;
    // 道路运输经营许可证编号	1..1	an..50	必填，网络货运经营者的道路运输经营许可证编号，网络货运经营者整合车辆全部为总质量4.5吨及以下普通货运车辆的，可填“企业所在地行政区划代码+000000”。
    private String permitNumber;
    // 运单生成时间	1..1	n14	必填，网络货运经营者信息系统正式成交生成运单的日期时间。YYYYMMDDhhmmss
//    @JsonSerialize(using = CustomDateTimeFormlessChange.class)
    private LocalDateTime consignmentDateTime;
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
    // 发货日期时间	1..1	n14	必填，货物装车后的发车时间 YYYYMMDDhhmmss
//    @JsonSerialize(using = CustomDateTimeFormlessChange.class)
    private LocalDateTime despatchActualDateTime;
    // 收货日期时间	1..1	n14	必填，货物运到后的签收时间YYYYMMDDhhmmss
//    @JsonSerialize(using = CustomDateTimeFormlessChange.class)
    private LocalDateTime goodsReceiptDateTime;
    // 运费金额	1..1	n..18,3	必填，托运人与网络货运经营者签订运输合同确定的运费金额，货币单位为人民币（元）， 保留 3 位小数，如整数的话，以.000 填充。如是一笔业务分几辆车运，需将托运人针对这笔业务付给网络货运经营者的运输费用分摊到每辆车上。
    @Column(precision = 18, scale = 3)
    private BigDecimal totalMonetaryAmount;

    // 备注0..1	an..256	必填
    private String remark;

}
