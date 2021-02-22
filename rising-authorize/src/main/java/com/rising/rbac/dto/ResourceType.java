/**
 *
 */
package com.rising.rbac.dto;

import lombok.Getter;

/**
 * 描述：资源类型
 *
 * @see Enum
 * 作者：李启云
 * 日期：2020-11-20
 */
@Getter
public enum ResourceType {
    /**
     * 目录
     */


    CATALOG(0),
    /**
     * 菜单
     */
    MENU(1),
    /**
     * 按钮
     */
    BUTTON(2);

    private final Integer value;

    /**
     * 码农：李齐云
     * 日期：2021-02-22
     * 描述：资源类型
     * <p>
     * 返回值：{@link  }
     *
     * @param value 价值
     */
    ResourceType(Integer value) {
        this.value = value;
    }

}


