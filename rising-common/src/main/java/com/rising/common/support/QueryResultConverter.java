package com.rising.common.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：查询结果转换器
 * <p>
 * 作者：李启云
 * 日期：2020-12-31
 */
public class QueryResultConverter {


    private static Logger logger = LoggerFactory.getLogger(QueryResultConverter.class);

    /**
     * 创建：李启云
     * 日期：2021-01-07
     * 描述：转换
     *
     * @param pageData 页面数据
     * @param clazz    clazz
     * @param pageable 可分页
     * @return {@link Page<I> }
     */
    public static <T, I> Page<I> convert(Page<T> pageData, Class<I> clazz, Pageable pageable) {
        List<T> contents = pageData.getContent();
        List<I> infos = convert(contents, clazz);
        return new PageImpl<I>(infos, pageable, pageData.getTotalElements());
    }

    /**
     * 创建：李启云
     * 日期：2021-01-12
     * 描述：转换
     *
     * @param contents 内容
     * @param clazz    clazz
     * @return {@link List<I> }
     */
    public static <I, T> List<I> convert(List<T> contents, Class<I> clazz) {
        List<I> infos = new ArrayList<>();
        for (T domain : contents) {
            I target = null;
            try {
                target = clazz.newInstance();
                BeanUtils.copyProperties(domain, target);
            } catch (Exception e) {
                logger.info("转换数据失败", e);
                throw new RuntimeException("转换数据失败");
            }
            infos.add(target);

        }
        return infos;
    }

    /**
     * 创建：李启云
     * 日期：2021-01-07
     * 描述：转换
     *
     * @param pageData  页面数据
     * @param pageable  可分页
     * @param converter 转换器
     * @return {@link Page<I> }
     */
    public static <T, I> Page<I> convert(Page<T> pageData, Pageable pageable, Domain2InfoConverter<T, I> converter) {
        List<T> contents = pageData.getContent();
        List<I> infos = convert(contents, converter);
        return new PageImpl<I>(infos, pageable, pageData.getTotalElements());
    }

    /**
     * 创建：李启云
     * 日期：2021-01-07
     * 描述：转换
     *
     * @param contents  内容
     * @param converter 转换器
     * @return {@link List<I> }
     */
    public static <I, T> List<I> convert(List<T> contents, Domain2InfoConverter<T, I> converter) {
        List<I> infos = new ArrayList<I>();
        for (T domain : contents) {
            infos.add(converter.convert(domain));
        }
        return infos;
    }


}
