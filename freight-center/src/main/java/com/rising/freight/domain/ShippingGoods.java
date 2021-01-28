package com.rising.freight.domain;

import com.rising.common.web.annotation.Comment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述：运输货物信息
 *货物信息（用于电子运单货物信息存储）
 * 作者：李启云
 * 日期：2020-12-31
 */
@Entity
@Table(name = "internet_goods_info")
@Getter
@Setter
@Comment("货物信息")
public class ShippingGoods extends Model{

    @ManyToMany(mappedBy = "goodsInfos")
    private Set<InternetCar> internetCars = new HashSet<>();

    // 货物名称	1..1	an..512	必填。
    @Column(length = 512)
    @Comment("货物名称")
    private String descriptionOfGoods;
    // 货物类型
    //分类代码	1..1	an..3	必填，代码集参见wlhy.mot.gov.cn。
    /**
     * 代 码 货物分类
     * 0100 煤炭及制品
     * 0200 石油、天然气及制品
     * 0300 金属矿石
     * 0400 钢铁
     * 0500 矿建材料
     * 0600 水泥
     * 0700 木材
     * 0800 非金属矿石
     * 0900 化肥及农药
     * 1000 盐
     * 1100 粮食
     * 1200 机械、设备、电器
     * 1300 轻工原料及制品
     * 1400 有色金属
     * 1500 轻工医药产品
     * 1601 鲜活农产品
     * 1602 冷藏冷冻货物
     * 1701 商品汽车
     * 1700 其他
     */
    private String cargoTypeClassificationCode;
    // 货物项毛重	1..1	n..14,3	必填，重量单位以KGM 千克填写数值，保留 3 位小数，如整数的话，以.000 填充。小数点不计入总长。如是轻泡货等货物，请估算重量。分几辆车运，需报送每辆车实际运输的货物重量。
    //如一笔业
    @Column(precision = 14,scale = 3)
    private BigDecimal goodsItemGrossWeight;
    // 体积	0..1	n..9,4	选填，体积单位以DMQ 立方米填写数值，保留 4 位小数，如整数的话，以.0000 填充。小数点不计入总长。
    @Column(precision = 9,scale = 4)
    private BigDecimal cube;
    // 总件数	0..1	n..8	选填。
    @Column(precision = 8)
    private Integer totalNumberOfPackages;



    // 收货方名称	1..1	an..512	必填。
    private String consignee;


    // 收货方统一社会信用代码或个人证件号码	1..1	an..35	必填。
    private String consigneeID;

    // 收货地址	0..1	an..256	选填，实际装货的地点。
    private String goodsReceiptPlace;

    // 收货地点的国家行政区划代码	1..1	an..12	必填，参照最新版《中华人民共和国行政区划代码》（GB/T 2260-2017），精确到区县。
    private String countrySubdivisionCode;



}
