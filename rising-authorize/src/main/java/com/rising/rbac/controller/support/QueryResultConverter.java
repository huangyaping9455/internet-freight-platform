/**
 *
 */
package com.rising.rbac.controller.support;

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
 * 日期：2020-12-03
 */
public class QueryResultConverter {

	private static Logger logger = LoggerFactory.getLogger(QueryResultConverter.class);

	/**
	 * @param pageData
	 * @param clazz
	 * @param pageable
	 * @return
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static <T, I> Page<I> convert(Page<T> pageData, Class<I> clazz, Pageable pageable) {
		List<T> contents = pageData.getContent();
		List<I> infos = convert(contents, clazz);
		return new PageImpl<I>(infos, pageable, pageData.getTotalElements());
	}

	public static <I, T> List<I> convert(List<T> contents, Class<I> clazz) {
		List<I> infos = new ArrayList<I>();
		for (T domain : contents) {
			I info = null;
			try {
				info = clazz.newInstance();
				BeanUtils.copyProperties(domain, info);
			} catch (Exception e) {
				logger.info("转换数据失败", e);
				throw new RuntimeException("转换数据失败");
			}
			if(info != null) {
				infos.add(info);
			}

		}
		return infos;
	}




}
