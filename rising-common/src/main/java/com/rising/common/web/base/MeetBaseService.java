package com.rising.common.web.base;

import com.rising.common.support.Domain2InfoConverter;
import com.rising.common.support.QueryResultConverter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 描述：满足基本的服务
 *
 * @see Domain2InfoConverter
 * 作者：李启云
 * 日期：2021-01-12
 */

public interface MeetBaseService<T, R, C, ID> extends Domain2InfoConverter<T, R> {


    BaseRepository<T, ID> getRepository();

    /**
     * 创建：李启云
     * 日期：2021-01-12
     * 描述：获取返回的clazz
     *
     * @return {@link Class<R> }
     */
    Class<R> getResponseClazz();

    /**
     * 创建：李启云
     * 日期：2021-01-12
     * 描述：获取实体clazz
     *
     * @return {@link Class<T> }
     */
    Class<T> getDomainClazz();


    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：得到
     *
     * @param id id
     * @return {@link T }
     */
    default R get(ID id) {
        T domain = getRepository().findById(id).orElse(null);
        assert domain != null;
        return convert(domain);
    }


    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：得到所有
     *
     * @return {@link List<T> }
     */
    default List<R> getAll() {
        List<T> all = getRepository().findAll();
        return QueryResultConverter.convert(all, getResponseClazz());

    }

    ;

    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：得到总菌数
     *
     * @return {@link Long }
     */
    default Long getTotalCount() {
        return getRepository().count();
    }

    /**
     * 创建：李启云
     * 日期：2021-01-12
     * 描述：保存
     *
     * @param entityDto 实体dto
     * @return {@link R }
     */
    default R save(R entityDto) {
        getRepository().save(rConvertT(entityDto));
        return entityDto;
    }

    /**
     * 创建：李启云
     * 日期：2021-01-12
     * 描述：更新
     *
     * @param entityDto 实体dto
     * @return {@link R }
     */
    default R update(R entityDto) {
        getRepository().save(rConvertT(entityDto));
        return entityDto;
    }

    /**
     * 创建：李启云
     * 日期：2021-01-08
     * 描述：保存或更新所有
     *
     * @param entities 实体
     * @return {@link List<R> }
     */
    default List<R> saveOrUpdateAll(List<R> entities) {
        List<T> domainList = QueryResultConverter.convert(entities, getDomainClazz());
        getRepository().saveAll(domainList);

        return entities;
    }

    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：删除通过id
     *
     * @param id id
     * @return
     */
    default void deleteById(ID id) {
        getRepository().deleteById(id);
    }


    /**
     * 创建：李启云
     * 日期：2020-12-31
     * 描述：找到所有
     *
     * @param pageable 可分页
     * @return {@link Page<T> }
     */
    default Page<R> findAll(Pageable pageable) {
        Page<T> all = getRepository().findAll(pageable);

        return QueryResultConverter.convert(all, getResponseClazz(), pageable);
    }


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


    /**
     * 创建：李启云
     * 日期：2021-01-12
     * 描述：找到列表的条件
     *
     * @param condition 条件
     * @return {@link List<R> }
     */
    List<R> findListByCondition(C condition);

}
