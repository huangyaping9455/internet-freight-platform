package com.rising.freight.domain;


import com.rising.common.web.annotation.Comment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 描述：财务报表
 * 收款人信息（财务列表  资金流水存储使用）
 * 作者：李启云
 * 日期：2020-12-31
 */
@Entity
@Table(name = "internet_financial_statement")
@Getter
@Setter
@Comment("财务报表")
public class InternetFinancialStatement extends Model {

    /**
     * 代码   名 称
     * 1      信用证
     * 2      托收
     * 3      汇付
     * 31      银行汇票
     * 32      银行转账
     * 4      第三方支付平台
     * 41      支付宝支付
     * 42      微信支付
     * 9      其他电子支付方式（不允许现金支付）
     */
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
    @Column(precision = 18, scale = 3)
    private BigDecimal monetaryAmount;
    // 日期时间	1..1	n14	资金流水实际发生时间。
    //YYYYMMDDhhmmss
//    @JsonSerialize(using = CustomDateTimeFormlessChange.class)
    private LocalDateTime dateTime;
}
