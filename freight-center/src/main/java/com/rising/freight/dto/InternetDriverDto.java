package com.rising.freight.dto;

import com.rising.freight.domain.InternetCar;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class InternetDriverDto {

    private String id;

    private Set<InternetCar> internetCars = new HashSet<>();


    @ApiModelProperty(value = "姓名1..1 an..30必填。对应运单技术规范第 35 项")
    private String driverName;

    @ApiModelProperty(value = "身份证号	1..1	an..18	必填。对应运单技术规范第 36 项")
    private String drivingLicense;
    @ApiModelProperty(value = "准驾车型0..1 an..20 使用总质量 4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员必填，根据机动车驾驶证填写")
    private String vehicleClass;
    // 驾驶证发证机关	0..1	an..128	使用总质量 4.5 吨及以下普通货运车辆从事
    //普通货物运输经营的驾驶员必填，根据机动车驾驶证填写。
    private String issuingOrganizations;
    // 驾驶证有效期自	0..1	n8	使用总质量 4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员必填，根据机动车驾驶证填写。YYYYMMDD

    private LocalDate validPeriodFrom;
    // 驾驶证有效期至	0..1	n8	使用总质量 4.5 吨及以下普通货运车辆从事
    //普通货物运输经营的驾驶员必填，根据机动车驾驶证填写。YYYYMMDD

    private LocalDate validPeriodTo;
    // 从业资格证号	1..1	an..18	必填，驾驶员从业资格证号，使用总质量4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员，填写“驾驶员身份证前 6位+000000000000”。
    private String qualificationCertificate;
    // 手机号码	1..1	an..18	必填。
    private String telephone;
    // 备注	0..1	an..256	选填。
    private String remark;
    //驾驶证
    private String driverLicense;


}
