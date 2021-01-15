package com.rising.common.support;

import org.springframework.core.convert.converter.Converter;

/**
 * 描述：domain2信息转换器
 *
 * @see Converter
 * 作者：李启云
 * 日期：2021-01-07
 */
public interface Domain2InfoConverter<T, R> extends Converter<T, R> {
    T rConvertT(R domainDto);

}
