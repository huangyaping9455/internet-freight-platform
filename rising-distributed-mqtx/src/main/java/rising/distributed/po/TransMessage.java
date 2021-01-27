package rising.distributed.po;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import rising.distributed.enums.TransMessageType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@Table(name = "tx_transMessage")
@Entity
public class TransMessage implements Serializable {

    @ApiModelProperty(value = "数据库表主键")
    @Id
    @GeneratedValue( generator = "custom-id")
    @GenericGenerator(name = "custom-id", strategy = "com.rising.common.support.CustomIDGenerator")
    private String id;
    private String service;
    @Enumerated(EnumType.STRING)
    private TransMessageType type;
    private String exchange;
    private String routingKey;
    private String queue;
    private Integer sequence;
    private String payload;
    private Date date;
}
