/**
 *
 */
package com.rising.rbac.dto;

/**
 * 描述：资源类型
 *
 * @see Enum
 * 作者：李启云
 * 日期：2020-11-20
 */
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

    private Integer value;

    ResourceType(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }


    public static void main(String[] args) {
        ResourceType menu = ResourceType.MENU;
        System.out.println(menu.value);

    }

}


