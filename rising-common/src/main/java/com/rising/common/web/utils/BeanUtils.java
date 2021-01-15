package com.rising.common.web.utils;

import com.rising.common.web.annotation.FieldMap;

import java.lang.reflect.Field;
import java.util.*;

public class BeanUtils {
    public static void copy(Object source, Object target) throws Exception {
        Class<?> sourceClass = source.getClass();

        Field[] soutceFields = getAllFields(sourceClass);
        Class<?> targetClass = target.getClass();

        Map<String, Object> sourceMap = new HashMap<>();
        for (Field field : soutceFields) {
            field.setAccessible(true);
            sourceMap.put(field.getName(), field.get(source));
        }

        Field[] targetFields = getAllFields(targetClass);
        for (Field field : targetFields) {
            field.setAccessible(true);
            FieldMap annotation = field.getAnnotation(FieldMap.class);
            if (annotation != null) {
                String name = annotation.name();
                Object sourceValue = sourceMap.get(name);
                if (field.getType() == sourceClass.getDeclaredField(name).getType()) {
                    field.set(target, sourceValue);
                } else {

                    System.out.println(field.getType());
                    System.out.println(sourceClass.getDeclaredField(name).getType());
                    /**
                     * 比如source的date字段类型为String，target接收date字段的类型为LocalDateTime
                     */
                    System.out.println();


                }
                continue;
            }
            field.set(target, sourceMap.get(field.getName()));
        }

    }


    /**
     * 创建：李启云
     * 日期：2020-11-23
     * 描述：得到所有字段(子类+父类)
     *
     * @param clazz clazz
     * @return {@link Field[] }
     */
    private static Field[] getAllFields(Class<?> clazz) {
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        return fieldList.toArray(fields);
    }




}
