package com.empapp.socgen.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.empapp.socgen.domain.Gender;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenderValidator {

	String message() default "Given gender is incorrect";
	
    Class<? extends Enum<?>> clazz() default Gender.class;

    String value();
}

