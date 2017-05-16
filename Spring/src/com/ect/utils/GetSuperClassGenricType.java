package com.ect.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GetSuperClassGenricType {
	public static Class getSuperClassGenricType(Class clazz, int index) {
			Type genType = clazz.getGenericSuperclass();

			if (!(genType instanceof ParameterizedType)) {
				return Object.class;
			}

			Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

			if (index >= params.length || index < 0) {
				return Object.class;
			}

			if (!(params[index] instanceof Class)) {
				return Object.class;
			}

			return (Class) params[index];
		}
}
