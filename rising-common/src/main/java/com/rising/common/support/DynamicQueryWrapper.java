package com.rising.common.support;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * 描述:
 * 包装jpa 动态查询所需对象
 *
 * @author 李启云
 * @ProjectName meet
 * @ClassName: DynamicQueryWraper
 * @date 2020/5/11 10:44
 */
public class DynamicQueryWrapper<T> {

    /**
     * JPA Root
     */
    private Root<T> root;
    /**
     * JPA CriteriaBuilder
     */
    private CriteriaBuilder cb;
    /**
     * JPA Predicate 集合
     */
    private List<Predicate> predicates;
    /**
     * JPA 查询对象
     */
    private CriteriaQuery<?> query;

    public DynamicQueryWrapper(Root<T> root, CriteriaBuilder cb, List<Predicate> predicates, CriteriaQuery<?> query) {
        this.root = root;
        this.cb = cb;
        this.predicates = predicates;
        this.query = query;
    }


    /**
     * <p> 方法描述：添加条件. </p>
     * <p> 创建时间：2020-05-11 11:14:54 </p>
     * <p> 创建作者：李启云 </p>
     * <p> 修改作者： </p>
     *
     * @param predicate the predicate
     */
    public void addPredicate(Predicate predicate) {
        this.predicates.add(predicate);
    }

    //-------------------------


    public Root<T> getRoot() {
        return root;
    }

    public void setRoot(Root<T> root) {
        this.root = root;
    }

    public CriteriaBuilder getCb() {
        return cb;
    }

    public void setCb(CriteriaBuilder cb) {
        this.cb = cb;
    }

    public List<Predicate> getPredicates() {
        return predicates;
    }

    public void setPredicates(List<Predicate> predicates) {
        this.predicates = predicates;
    }

    public CriteriaQuery<?> getQuery() {
        return query;
    }

    public void setQuery(CriteriaQuery<?> query) {
        this.query = query;
    }
}
