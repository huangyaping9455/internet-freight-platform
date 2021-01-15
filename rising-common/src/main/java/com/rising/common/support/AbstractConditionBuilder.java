package com.rising.common.support;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.Date;

/**
 * 描述：抽象的条件生成器
 * <p>
 * 作者：李启云
 * 日期：2020-10-13
 */
public abstract class AbstractConditionBuilder<T> {

    /**
     * 添加in条件
     *
     * @param dynamicQueryWrapper 包装好的查询对象
     * @param column             the column
     * @param values             the values
     */
    protected void addInConditionToColumn(DynamicQueryWrapper<T> dynamicQueryWrapper, String column, Object values) {
        if (needAddCondition(values)) {
            Path<?> fieldPath = getPath(dynamicQueryWrapper.getRoot(), column);
            if (values.getClass().isArray()) {
                dynamicQueryWrapper.addPredicate(fieldPath.in((Object[]) values));
            } else if (values instanceof Collection) {
                dynamicQueryWrapper.addPredicate(fieldPath.in((Collection<?>) values));
            }
        }
    }

    /**
     * 添加between条件查询
     *
     * @param dynamicQueryWrapper the query wraper
     * @param column             the column
     * @param minValue           范围下限
     * @param maxValue           范围上限
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected void addBetweenConditionToColumn(DynamicQueryWrapper<T> dynamicQueryWrapper, String column, Comparable minValue, Comparable maxValue) {
        if (minValue != null || maxValue != null) {
            Path<? extends Comparable> fieldPath = getPath(dynamicQueryWrapper.getRoot(), column);
            if (minValue != null && maxValue != null) {
                dynamicQueryWrapper.addPredicate(dynamicQueryWrapper.getCb().between(fieldPath, minValue, processMaxValueOnDate(maxValue)));
            } else if (minValue != null) {
                dynamicQueryWrapper.addPredicate(dynamicQueryWrapper.getCb().greaterThanOrEqualTo(fieldPath, minValue));
            } else if (maxValue != null) {
                dynamicQueryWrapper.addPredicate(dynamicQueryWrapper.getCb().lessThanOrEqualTo(fieldPath, processMaxValueOnDate(maxValue)));
            }
        }
    }

    /**
     * 当范围查询的条件是小于，并且值的类型是Date时，将传入的Date值变为当天的夜里12点的值。
     *
     * @param maxValue the max value
     * @return comparable
     */
    @SuppressWarnings("rawtypes")
    private Comparable processMaxValueOnDate(Comparable maxValue) {
        if (maxValue instanceof Date) {
            maxValue = new DateTime(maxValue).withTimeAtStartOfDay().plusDays(1).plusSeconds(-1).toDate();
        }
        return maxValue;
    }

    /**
     * 添加大于条件查询
     *
     * @param dynamicQueryWrapper the dynamic query wraper
     * @param column             the column
     * @param minValue           the min value
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected void addGreaterThanConditionToColumn(DynamicQueryWrapper<T> dynamicQueryWrapper, String column, Comparable minValue) {
        if (minValue != null) {
            Path<? extends Comparable> fieldPath = getPath(dynamicQueryWrapper.getRoot(), column);
            dynamicQueryWrapper.addPredicate(dynamicQueryWrapper.getCb().greaterThan(fieldPath, minValue));
        }
    }

    /**
     * 创建：李启云
     * 日期：2020-10-13
     * 描述：大于或等于条件添加到列
     *
     * @param dynamicQueryWrapper 动态查询包装
     * @param column             列
     * @param minValue           最小值
     * @return
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected void addGreaterThanOrEqualConditionToColumn(DynamicQueryWrapper<T> dynamicQueryWrapper, String column, Comparable minValue) {
        if (minValue != null) {
            Path<? extends Comparable> fieldPath = getPath(dynamicQueryWrapper.getRoot(), column);
            dynamicQueryWrapper.addPredicate(dynamicQueryWrapper.getCb().greaterThanOrEqualTo(fieldPath, minValue));
        }
    }

    /**
     * 添加小于条件查询
     *
     * @param dynamicQueryWrapper the dynamic query wraper
     * @param column             the column
     * @param maxValue           the max value
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void addLessThanConditionToColumn(DynamicQueryWrapper<T> dynamicQueryWrapper, String column, Comparable maxValue) {
        if (maxValue != null) {
            Path<? extends Comparable> fieldPath = getPath(dynamicQueryWrapper.getRoot(), column);
            dynamicQueryWrapper.addPredicate(dynamicQueryWrapper.getCb().lessThan(fieldPath, processMaxValueOnDate(maxValue)));
        }
    }

    /**
     * 添加小于等于条件查询
     *
     * @param dynamicQueryWrapper the dynamic query wraper
     * @param column             the column
     * @param maxValue           the max value
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    protected void addLessThanOrEqualConditionToColumn(DynamicQueryWrapper<T> dynamicQueryWrapper, String column, Comparable maxValue) {
        if (maxValue != null) {
            Path<? extends Comparable> fieldPath = getPath(dynamicQueryWrapper.getRoot(), column);
            dynamicQueryWrapper.addPredicate(dynamicQueryWrapper.getCb().lessThanOrEqualTo(fieldPath, processMaxValueOnDate(maxValue)));
        }
    }

    /**
     * <pre>
     * 添加like条件
     * <pre>
     * @param dynamicQueryWrapper the dynamic query wraper
     * @param column the column
     * @param value the value
     */
    protected void addLikeConditionToColumn(DynamicQueryWrapper<T> dynamicQueryWrapper, String column, String value) {
        if (StringUtils.isNotBlank(value)) {
            dynamicQueryWrapper.addPredicate(createLikeCondition(dynamicQueryWrapper, column, value));
        }
    }

    /**
     * <p> 方法描述：Create like condition predicate. </p>
     * <p> 创建时间：2020-05-11 11:35:12 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param dynamicQueryWrapper the dynamic query wraper
     * @param column             the column
     * @param value              the value
     * @return predicate
     */
    @SuppressWarnings("unchecked")
    protected Predicate createLikeCondition(DynamicQueryWrapper<T> dynamicQueryWrapper, String column, String value) {
        Path<String> fieldPath = getPath(dynamicQueryWrapper.getRoot(), column);
        Predicate condition = dynamicQueryWrapper.getCb().like(fieldPath, "%" + value + "%");
        return condition;
    }

    /**
     * <pre>
     * 添加like条件
     * <pre>
     * @param dynamicQueryWrapper the dynamic query wraper
     * @param column the column
     * @param value the value
     */
    @SuppressWarnings("unchecked")
    protected void addStartsWidthConditionToColumn(DynamicQueryWrapper<T> dynamicQueryWrapper, String column, String value) {
        if (StringUtils.isNotBlank(value)) {
            Path<String> fieldPath = getPath(dynamicQueryWrapper.getRoot(), column);
            dynamicQueryWrapper.addPredicate(dynamicQueryWrapper.getCb().like(fieldPath, value + "%"));
        }
    }


    /**
     * 添加等于条件
     *
     * @param dynamicQueryWrapper the dynamic query wraper
     * @param column             指出要向哪个字段添加条件
     * @param value              指定字段的值
     */
    protected void addEqualsConditionToColumn(DynamicQueryWrapper<T> dynamicQueryWrapper, String column, Object value) {
        if (needAddCondition(value)) {
            Path<?> fieldPath = getPath(dynamicQueryWrapper.getRoot(), column);
            dynamicQueryWrapper.addPredicate(dynamicQueryWrapper.getCb().equal(fieldPath, value));
        }
    }

    /**
     * 添加不等于条件
     *
     * @param dynamicQueryWrapper the dynamic query wraper
     * @param column             指出要向哪个字段添加条件
     * @param value              指定字段的值
     */
    protected void addNotEqualsConditionToColumn(DynamicQueryWrapper<T> dynamicQueryWrapper, String column, Object value) {
        if (needAddCondition(value)) {
            Path<?> fieldPath = getPath(dynamicQueryWrapper.getRoot(), column);
            dynamicQueryWrapper.addPredicate(dynamicQueryWrapper.getCb().notEqual(fieldPath, value));
        }
    }

    /**
     * <pre>
     *
     * <pre>
     * @param root
     * @param property
     * @return
     */
    @SuppressWarnings("rawtypes")
    protected Path getPath(Root root, String property) {
        String[] names = StringUtils.split(property, ".");
        Path path = root.get(names[0]);
        for (int i = 1; i < names.length; i++) {
            path = path.get(names[i]);
        }
        return path;
    }

    /**
     * <pre>
     * 判断是否需要添加where条件
     * <pre>
     * @param value the value
     * @return boolean
     */
    @SuppressWarnings("rawtypes")
    protected boolean needAddCondition(Object value) {
        boolean addCondition = false;
        if (value != null) {
            if (value instanceof String) {
                if (StringUtils.isNotBlank(value.toString())) {
                    addCondition = true;
                }
            } else if (value.getClass().isArray()) {
                if (ArrayUtils.isNotEmpty((Object[]) value)) {
                    addCondition = true;
                }
            } else if (value instanceof Collection) {
                if (CollectionUtils.isNotEmpty((Collection) value)) {
                    addCondition = true;
                }
            } else {
                addCondition = true;
            }
        }
        return addCondition;
    }

}
