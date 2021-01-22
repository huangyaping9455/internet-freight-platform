package com.rising.freight.domain;

import com.rising.common.web.annotation.Comment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 描述：运单列表
 * <p>
 * 作者：李启云
 * 日期：2020-12-31
 */
/*@Table(name = "internet_financial")
@Entity*/
@Getter
@Setter
@Comment("运单列表")
public class FinancialShippingNote extends Model{
    // 托运单号	1..1	an..20	必填，对应运单技术规范中第 2 项。
    private String shippingNoteNumber;
    // 分段分单号	1..1	an..4	必填，对应运单技术规范中第 3 项。
    private String serialNumber;
}
