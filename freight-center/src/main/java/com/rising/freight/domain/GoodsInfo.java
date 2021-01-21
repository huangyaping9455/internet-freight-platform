package com.rising.freight.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * 描述：
 * 网络货运平台车辆基础数据存储
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2020-12-31
 */
@Entity
@Table(name = "internet_goods_info")
@Getter
@Setter
public class GoodsInfo extends Model {

    // 货物名称	1..1	an..512	必填。
    private String descriptionOfGoods;

    // 货物类型分类代码	1..1	an..3	必填，代码集参见wlhy.mot.gov.cn。
    private String cargoTypeClassificationCode;

    // 核货物项毛重	1..1	n..14,3	必填，重量单位以KGM千克填写数值，保留3位小数，如整数的话，以.000填充。小数点不计入总长。如是轻泡货等货物，请估算重量。如一笔业务分几辆车运，需报送每辆车实际运输的货物重量。
    @Column(precision = 14, scale = 3)
    private BigDecimal goodsItemGrossWeight;
    // 体积	0..1	n..9,4	选填，体积单位以DMQ立方米填写数值，保留4位小数，如整数的话，以.0000填充。小数点不计入总长。
    @Column(precision = 9, scale = 4)
    private BigDecimal cube;
    // 总件数	0..1	n..8	选填。
    @Column(precision = 8)
    private BigDecimal totalNumberOfPackages;


}
