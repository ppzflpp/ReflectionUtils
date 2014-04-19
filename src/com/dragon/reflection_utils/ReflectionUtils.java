package com.dragon.reflection_utils;

import java.lang.reflect.Method;

/**
 * 
 * @author zhangfeilong
 * @version 1.0
 * 
 */

public class ReflectionUtils {

	/**
	 * 
	 * @param clazz
	 *            can be instance or className
	 * @param methodName
	 * @param argsType
	 *            type of arguments
	 * @param argsValue
	 *            value of arguments
	 * @return method return value;
	 * @throws Exception
	 */

	public static Object invokeMethod(Object clazz, String methodName,
			Class<?>[] argsType, Object[] argsValue) throws Exception {
		Object resultObject = null;
		if (clazz == null) {
			throw new Exception(
					"clazz can not be null");
		}

		if (methodName == null || methodName.equals("")) {
			throw new Exception("methodName is null or empty");
		}

		Class<?> c = null;

		if (clazz instanceof String) {
			String className = (String) clazz;
			if (className == null || className.equals("")) {
				throw new Exception("className is null or empty");
			}

			c = Class.forName(className);
		} else {
			c = clazz.getClass();
		}

		Method method = c.getDeclaredMethod(methodName, argsType);
		if (method == null) {
			throw new Exception("" + methodName + " not exists");
		}

		resultObject = method.invoke(clazz, argsValue);

		return resultObject;
	}

}
