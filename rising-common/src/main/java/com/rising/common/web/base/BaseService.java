package com.rising.common.web.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * 描述：基础服务
 *
 * @see Serializable
 * 作者：李启云
 * 日期：2021-01-07
 */

public interface BaseService<T, R, C, ID> extends Serializable {


    BaseRepository<T, ID> getRepository();

    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：得到
     *
     * @param id id
     * @return {@link T }
     */
    R get(ID id);

    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：得到所有
     *
     * @return {@link List<T> }
     */
     List<R> getAll();

    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：得到总菌数
     *
     * @return {@link Long }
     */
    Long getTotalCount();

    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：保存
     *
     * @param entity 实体
     * @return {@link T }
     */
    R save(R entity);

    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：更新
     *
     * @param entity 实体
     * @return {@link T }
     */
    R update(R entity);

    /**
     * 创建：李启云
     * 日期：2021-01-08
     * 描述：保存或更新所有
     *
     * @param entities 实体
     * @return {@link List<R> }
     */
    List<R> saveOrUpdateAll(List<R> entities);

    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：删除通过id
     *
     * @param id id
     * @return
     */
    void deleteById(ID id);

    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：找到的条件
     *
     * @param condition 条件
     * @return {@link List<T> }
     */
    List<R> findListByCondition(C condition);

    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：找到所有
     *
     * @param pageable 可分页
     * @return {@link Page<T> }
     */
    Page<T> findAll(Pageable pageable);

    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：通过条件找到页面
     *
     * @param condition 条件
     * @param pageable  可分页
     * @return {@link Page<T> }
     */
    Page<R> findPageByCondition(C condition, Pageable pageable);



}
