/**
 *
 */
package com.rising.rbac.dto.condition;

import lombok.Data;

/**
 * 描述：管理条件
 * <p>
 * 作者：李启云
 * 日期：2020-12-02
 */
@Data
public class AdminCondition {

    private String username;

    private Long organizationId;

}
