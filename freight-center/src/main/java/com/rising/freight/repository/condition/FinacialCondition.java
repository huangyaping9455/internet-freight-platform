package com.rising.freight.repository.condition;

import lombok.Data;

@Data
public class FinacialCondition {
    private String documentNumber;
    private String carrier;
    private String vehicleNumber;
    private Boolean isDelete;
    private Long organizationId;
}
