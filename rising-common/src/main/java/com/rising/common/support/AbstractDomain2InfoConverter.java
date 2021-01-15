package com.rising.common.support;

import com.rising.common.core.GenericUtils;
import org.springframework.beans.BeanUtils;

/**
 * 描述：文摘domain2信息转换器
 *
 * @see Domain2InfoConverter
 * 作者：李启云
 * 日期：2021-01-07
 */
public abstract class AbstractDomain2InfoConverter<T, R> implements Domain2InfoConverter<T, R> {

    /**
     * @param domain
     * @return
     * @see Domain2InfoConverter#convert(Object)
     */
    @SuppressWarnings("unchecked")
    @Override
    public R convert(T domain) {
        R target = null;
        try {
            Class<R> clazz = GenericUtils.getGenericClass(getClass(), 1);
            target = clazz.newInstance();
            BeanUtils.copyProperties(domain, target);
            doConvert(domain, target);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return target;
    }



    protected abstract void doConvert(T domain, R target) throws Exception;

    @Override
    public T rConvertT(R domainDto) {
        T target = null;
        try {
            Class<T> clazz = GenericUtils.getGenericClass(getClass(), 0);
            target = clazz.newInstance();
            BeanUtils.copyProperties(domainDto, target);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return target;
    }
}
