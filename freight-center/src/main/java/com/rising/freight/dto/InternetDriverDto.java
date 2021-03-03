package com.rising.freight.dto;

import com.rising.freight.domain.InternetCar;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@ApiModel("司机信息传输对象")
public class InternetDriverDto {
    private String id;
    private String organizationId;
    private Set<InternetCar> internetCars = new HashSet<>();
    @ApiModelProperty(value = "姓名1..1 an..30必填。对应运单技术规范第 35 项")
    private String driverName;
    @ApiModelProperty(value = "身份证号", required = true, notes = "1..1 an..18必填。对应运单技术规范第 36 项")
    private String drivingLicense;
    @ApiModelProperty(value = "准驾车型", required = true, notes = "0..1 an..20 使用总质量 4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员必填，根据机动车驾驶证填写")
    private String vehicleClass;
    @ApiModelProperty(value = "驾驶证发证机关", required = true, notes = "0..1 an..128 使用总质量 4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员必填，根据机动车驾驶证填写")
    private String issuingOrganizations;
    @ApiModelProperty(value = "驾驶证有效期自", required = true, notes = "0..1 n8使用总质量 4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员必填，根据机动车驾驶证填写。YYYYMMDD")
    private LocalDate validPeriodFrom;
    @ApiModelProperty(value = "驾驶证有效期至", required = true, notes = "使用总质量 4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员必填，根据机动车驾驶证填写。YYYYMMDD")
    private LocalDate validPeriodTo;
    @ApiModelProperty(value = "从业资格证号",required = true,notes = "必填，驾驶员从业资格证号，使用总质量4.5 吨及以下普通货运车辆从事普通货物运输经营的驾驶员，填写“驾驶员身份证前 6位+000000000000”。")
    private String qualificationCertificate;
    @ApiModelProperty(value = "手机号码",required = true,notes = "")
    private String telephone;
    // 	0..1	an..256	选填。
    @ApiModelProperty(value = "备注")
    private String remark;
    //司机附件URl
    private Set<String> driverAttachmentURLs;


}
