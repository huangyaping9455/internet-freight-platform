package com.rising.common.support;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 描述：抽象事件条件生成器
 *
 * @see AbstractConditionBuilder
 * 作者：李启云
 * 日期：2020-10-13
 */
public abstract class AbstractEventConditionBuilder<T, C> extends AbstractConditionBuilder<T> {

    /**
     * 查询条件
     */
    private C condition;

    /**
     * @param condition 查询条件
     */
    public AbstractEventConditionBuilder(C condition) {
        this.condition = condition;
    }

    /**
     * 创建：李启云
     * 日期：2020-10-13
     * 描述：添加条件等
     *指出查询条件的值从condition对象的哪个字段里取，并且指出要向哪个字段添加包含(like)条件。(同一个字段名称)
     * @param dynamicQueryWrapper 动态查询包装
     * @param field              场
     * @return
     */
    protected void addLikeCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field) {
        addLikeCondition(dynamicQueryWrapper, field, field);
    }

    /**
     * 向查询中添加包含(like)条件
     *
     * @param dynamicQueryWrapper
     * @param field              指出查询条件的值从condition对象的哪个字段里取
     * @param column             指出要向哪个字段添加包含(like)条件
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    protected void addLikeCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field, String column) {
        addLikeConditionToColumn(dynamicQueryWrapper, column, (String)
                getValue(getCondition(), field));
    }


    /**
     * 向查询中添加包含(like)条件,%放在值后面
     *
     * @param dynamicQueryWrapper
     * @param field              指出查询条件的值从condition对象的哪个字段里取，并且指出要向哪个字段添加包含(like)条件。(同一个字段名称)
     */
    protected void addStartsWidthCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field) {
        addStartsWidthCondition(dynamicQueryWrapper, field, field);
    }

    /**
     * 向查询中添加包含(like)条件,%放在值后面
     *
     * @param dynamicQueryWrapper
     * @param field              指出查询条件的值从condition对象的哪个字段里取
     * @param column             指出要向哪个字段添加包含(like)条件
     */
    protected void addStartsWidthCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field, String column) {
        addStartsWidthConditionToColumn(dynamicQueryWrapper, column, (String)
                getValue(getCondition(), field));
    }

    /**
     * 向查询中添加等于(=)条件
     *
     * @param dynamicQueryWrapper
     * @param field              指出查询条件的值从condition对象的哪个字段里取，并且指出要向哪个字段添加条件。(同一个字段名称)
     */
    protected void addEqualsCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field) {
        addEqualsCondition(dynamicQueryWrapper, field, field);
    }

    /**
     * 向查询中添加等于(=)条件
     *
     * @param dynamicQueryWrapper the dynamic query wraper
     * @param field              指出查询条件的值从condition对象的哪个字段里取
     * @param column             指出要向哪个字段添加条件
     */
    protected void addEqualsCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field, String column) {
        addEqualsConditionToColumn(dynamicQueryWrapper, column,
                getValue(getCondition(), field));
    }

    /**
     * 向查询中添加不等于(!=)条件
     *
     * @param dynamicQueryWrapper
     * @param field              指出查询条件的值从condition对象的哪个字段里取，并且指出要向哪个字段添加条件。(同一个字段名称)
     */
    protected void addNotEqualsCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field) {
        addNotEqualsCondition(dynamicQueryWrapper, field, field);
    }

    /**
     * 向查询中添加等于(=)条件
     *
     * @param dynamicQueryWrapper
     * @param field              指出查询条件的值从condition对象的哪个字段里取
     * @param column             指出要向哪个字段添加条件
     */
    protected void addNotEqualsCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field, String column) {
        addNotEqualsConditionToColumn(dynamicQueryWrapper, column, getValue(getCondition(), field));
    }

    /**
     * <pre>
     * 向查询中添加in条件
     * <pre>
     * @param dynamicQueryWrapper
     * @param field
     */
    protected void addInCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field) {
        addInCondition(dynamicQueryWrapper, field, field);
    }

    /**
     * <pre>
     * 向查询中添加in条件
     * <pre>
     * @param dynamicQueryWrapper
     * @param field
     * @param column
     */
    protected void addInCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field, String column) {
        addInConditionToColumn(dynamicQueryWrapper, column,
                getValue(getCondition(), field));
    }

    /**
     * <pre>
     * 向查询中添加between条件
     * <pre>
     * @param dynamicQueryWrapper
     * @param field
     */
    protected void addBetweenCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field) {
        addBetweenCondition(dynamicQueryWrapper, field, field + "To", field);
    }

    /**
     * <pre>
     * 向查询中添加between条件
     * <pre>
     * @param dynamicQueryWrapper the dynamic query wraper
     * @param startField the start field
     * @param endField the end field
     * @param column the column
     */
    @SuppressWarnings("rawtypes")
    protected void addBetweenCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String startField, String endField, String column) {
        addBetweenConditionToColumn(dynamicQueryWrapper, column,
                (Comparable) getValue(getCondition(), startField),
                (Comparable) getValue(getCondition(), endField));
    }

    /**
     * <pre>
     * 向查询中添加大于条件
     * <pre>
     * @param dynamicQueryWrapper
     * @param field
     */
    protected void addGreaterThanCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field) {
        addGreaterThanCondition(dynamicQueryWrapper, field, field);
    }

    /**
     * <pre>
     * 向查询中添加大于条件
     * <pre>
     * @param dynamicQueryWrapper
     * @param field
     * @param column
     */
    @SuppressWarnings("rawtypes")
    protected void addGreaterThanCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field, String column) {
        addGreaterThanConditionToColumn(dynamicQueryWrapper, column,
                (Comparable) getValue(getCondition(), field));
    }

    /**
     * <pre>
     * 向查询中添加大于等于条件
     * <pre>
     * @param dynamicQueryWrapper
     * @param field
     */
    protected void addGreaterThanOrEqualCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field) {
        addGreaterThanOrEqualCondition(dynamicQueryWrapper, field, field);
    }

    /**
     * <pre>
     * 向查询中添加大于等于条件
     * <pre>
     * @param dynamicQueryWrapper
     * @param field
     * @param column
     */
    @SuppressWarnings("rawtypes")
    protected void addGreaterThanOrEqualCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field, String column) {
        addGreaterThanOrEqualConditionToColumn(dynamicQueryWrapper, column,
                (Comparable) getValue(getCondition(), field));
    }

    /**
     * <pre>
     * 向查询中添加小于条件
     * <pre>
     * @param dynamicQueryWrapper
     * @param field
     */
    protected void addLessThanCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field) {
        addLessThanCondition(dynamicQueryWrapper, field, field);
    }

    /**
     * <pre>
     * 向查询中添加小于条件
     * <pre>
     * @param dynamicQueryWrapper
     * @param field
     * @param column
     */
    @SuppressWarnings("rawtypes")
    protected void addLessThanCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field, String column) {
        addLessThanConditionToColumn(dynamicQueryWrapper, column,
                (Comparable) getValue(getCondition(), field));
    }

    /**
     * <pre>
     * 向查询中添加小于等于条件
     * <pre>
     * @param dynamicQueryWrapper
     * @param field
     */
    protected void addLessThanOrEqualCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field) {
        addLessThanOrEqualCondition(dynamicQueryWrapper, field, field);
    }

    /**
     * <pre>
     * 向查询中添加小于等于条件
     * <pre>
     * @param dynamicQueryWrapper
     * @param field
     * @param column
     */
    @SuppressWarnings("rawtypes")
    protected void addLessThanOrEqualCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String field, String column) {
        addLessThanOrEqualConditionToColumn(dynamicQueryWrapper, column,
                (Comparable) getValue(getCondition(), field));
    }

    private Object getValue(C condition, String field) {
        try {
            return PropertyUtils.getProperty(condition, field);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @return the condition
     */
    public C getCondition() {
        return condition;
    }

    /**
     * @param condition the condition to set
     */
    public void setCondition(C condition) {
        this.condition = condition;
    }


}

