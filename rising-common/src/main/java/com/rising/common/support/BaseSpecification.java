package com.rising.common.support;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述：满足基本规范
 *
 * @see AbstractEventConditionBuilder
 * @see Specification
 * 作者：李启云
 * 日期：2020-12-31
 */
public abstract class BaseSpecification<T, C> extends AbstractEventConditionBuilder<T, C>
        implements Specification<T> {
    /**
     * 创建：李启云
     * 日期：2021-01-12
     * 描述：基础规范
     *
     * @param condition 条件
     * @return {@link  }
     */
    public BaseSpecification(C condition) {
        super(condition);
    }

    /**
     * 创建：李启云
     * 日期：2021-01-12
     * 描述：对谓词
     *
     * @param root  根
     * @param query 查询
     * @param cb    cb
     * @return {@link Predicate }
     */
    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        if (Long.class != query.getResultType()) {
            addFetch(root);
        }

        List<Predicate> predicates = new ArrayList<Predicate>();

        DynamicQueryWrapper<T> queryWrapper = new DynamicQueryWrapper<T>(root, cb, predicates, query);

        addCondition(queryWrapper);

        Predicate permissionCondition = getPermissionCondition(queryWrapper);
        if (permissionCondition != null) {
            queryWrapper.addPredicate(permissionCondition);
        }

        return cb.and(predicates.toArray(new Predicate[predicates.size()]));
    }

    /**
     * 创建：李启云
     * 日期：2021-01-12
     * 描述：获得许可条件
     *
     * @param queryWrapper 查询包装
     * @return {@link Predicate }
     */
    protected Predicate getPermissionCondition(DynamicQueryWrapper<T> queryWrapper) {
        return null;
    }

    /**
     * <pre>
     * 子类可以通过覆盖此方法实现关联抓取，避免n+1查询
     *
     * <pre>
     *
     * @param root
     */
    protected void addFetch(Root<T> root) {

    }

    protected abstract void addCondition(DynamicQueryWrapper<T> queryWrapper);
}
