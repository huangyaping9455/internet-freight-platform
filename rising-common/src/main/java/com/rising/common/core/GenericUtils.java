/**
 *
 */
package com.rising.common.core;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型工具
 * 两个静态重载方法 如果不传索引所有默认获取第一个泛型
 *
 * @author liqiyun
 */
public class GenericUtils {

    /**
     * 获取目标class的第一个泛型参数的类型
     *
     * @param clazz the clazz
     * @return class
     */
    @SuppressWarnings("rawtypes")
    public static Class getGenericClass(Class clazz) {
        return getGenericClass(clazz, 0);
    }

    /**
     * 获取目标class的指定位置的泛型参数的类型
     *
     * @param clazz
     * @param index 泛型参数的位置,第一个参数为0
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Class getGenericClass(Class clazz, int index) {
        Type t = clazz.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) t).getActualTypeArguments();
            if (params[index] instanceof ParameterizedType) {
                return ((ParameterizedType) params[index]).getRawType().getClass();
            } else {
                return (Class) params[index];
            }
        }
        throw new RuntimeException("无法获得泛型的类型");
    }


    /**
     * 创建：李启云
     * 日期：2021-01-07
     * 描述：得到interfacet
     *
     * @param clazz clazz
     * @param index 指数
     * @return {@link Class }
     */
    public static Class getInterfaceT(Class clazz, int index) {
        Class[] interfaces = clazz.getInterfaces();
        Type[] types = clazz.getGenericInterfaces();
        for (Type type : types) {
            ParameterizedType parameterizedType = (ParameterizedType)type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();

        }

        ParameterizedType parameterizedType = (ParameterizedType) types[0];
        Type type = parameterizedType.getActualTypeArguments()[index];
        return checkType(type, index);

    }

    /**
     * 创建：李启云
     * 日期：2021-01-07
     * 描述：检查类型
     *
     * @param type  类型
     * @param index 指数
     * @return {@link Class<?> }
     */
    private static Class<?> checkType(Type type, int index) {
        if (type instanceof Class<?>) {
            return (Class<?>) type;
        } else if (type instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType) type;
            Type t = pt.getActualTypeArguments()[index];
            return checkType(t, index);
        } else {
            String className = type == null ? "null" : type.getClass().getName();
            throw new IllegalArgumentException("Expected a Class, ParameterizedType"
                    + ", but <" + type + "> is of type " + className);
        }
    }
}