package com.palmergames.bukkit.config;

import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConfigUtil {
	/**
	 * Serialize an object into a named map.
	 * @param instance, The Class of this object must be public.
	 * @return a map with serialized fields that are annotated with Node. If the Node(key) argument isn't specified
	 */
	public static Map<String, Object> serialize(Object instance) {
		if (instance == null)
			return null;

		Map<String, Object> result = new LinkedHashMap<String, Object>();
		Class<?> clazz = instance.getClass();

		for (Field f : clazz.getDeclaredFields()) {

			if (f.isAnnotationPresent(Node.class)) {
				String key = getKey(f);

				if (key == null)
					key = f.getName();

				Object fieldObj = null;
				try {
					fieldObj = f.get(instance);
				} catch (IllegalArgumentException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					try {
						String getterName = "get" + StringUtils.capitalize(f.getName()); // TODO: Move to reflection util?
						Method m = clazz.getMethod(getterName);
						fieldObj = m.invoke(instance);
					} catch (Exception e) { // IllegalArgumentException | InvocationTargetException | IllegalAccessException | NoSuchMethodException | SecurityException
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				if (fieldObj == null)
					continue;

				if (fieldObj instanceof ConfigurationSerializable) {
					ConfigurationSerializable configurationSerializable = (ConfigurationSerializable) fieldObj;
					fieldObj = configurationSerializable.serialize();
				}

				result.put(key, fieldObj);
			}
		}

		return result;
	}

	/**
	 *
	 * @param clazz, The class we use reflection to search the keys in the given map.
	 * @param args, The map containing the elements
	 * @return The deserialized object to be casted later.
	 */
	public static Object deserialize(Class<?> clazz, Map<String, Object> args) {
		Object instance;

		try {
			instance = clazz.newInstance();
		} catch (Exception e1) { // InstantiationException | IllegalAccessException
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}

		for (Field f : clazz.getDeclaredFields()) {
			if (f.isAnnotationPresent(Node.class)) {
				String key = getKey(f);

				// Check if that it was defined.
				if (!args.containsKey(key))
					// Use default value for that field.
					continue;

				Object nodeObj = args.get(key);

				if (ConfigurationSerializable.class.isAssignableFrom(f.getType())) {
					try {

						Method m = f.getType().getMethod("deserialize", Map.class);
						nodeObj = m.invoke(null, nodeObj);
					} catch (Exception e) { // NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// Field.getType() will return primitive classes, so we need to wrap them in order to compare them.
				Class<?> fieldClass = f.getType();
				if (fieldClass.isPrimitive())
					fieldClass = ClassUtils.primitiveToWrapper(fieldClass);

				//System.out.format("%s (%s) = %s%n", f.getType(), fieldClass, nodeObj.getClass());

				if (fieldClass.isInstance(nodeObj)) {
					try {
						f.set(instance, nodeObj);
					} catch (IllegalAccessException e) {
						try {
							String setterName = "set" + StringUtils.capitalize(f.getName()); // TODO: Move to reflection util?
							//System.out.format(".%s(...)%n", setterName);
							Method m = clazz.getMethod(setterName, f.getType());

							m.invoke(instance, nodeObj);
						} catch (Exception e2) { // NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException | IllegalAccessException
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
				}
			}
		}

		return instance;
	}

	/**
	 * Get the key to use to serialize the field.
	 *
	 * @param field that is annotated with Node
	 * @return the name of the field if the key has not been specified in the annotation.
	 */
	public static String getKey(Field field) {
		Node nodeAnnotation = field.getAnnotation(Node.class);
		String key = nodeAnnotation.key();
		if (key.equals(Node.NULL_STRING))
			return field.getName();
		else
			return key;
	}

}
