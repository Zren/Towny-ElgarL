package com.palmergames.bukkit.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Node {

	/**
	 * Default value is "null", which will be used to flag that the key will be the field's name.
	 * @return the key used for serializing this field.
	 */
	String key() default NULL_STRING;

	static final String NULL_STRING = "null";
}
