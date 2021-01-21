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
 * 作者：普校仙
 * 日期：2021-1-20
 */
@Entity
@Table(name = "internet_insurance")
@Getter
@Setter
public class InsuranceInformation extends Model {

    // 保险单号	1..1	an..30	必填，未投保的，可填none。
    private String policyNumber;
    // 保险公司名称	1..1	an..30	必填，代码集参见wlhy.mot.gov.cn。未投保的，可填“无”。
    private String InsuranceCompany;

}
