package com.rising.freight.repository.condition;

import lombok.Data;

@Data
public class InternetDriverCondition {
    private String driverName;
    private String telephone;
    private Boolean isDelete;
    private String organizationId;
}
