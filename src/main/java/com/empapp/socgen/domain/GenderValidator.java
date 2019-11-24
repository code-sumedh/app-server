package com.empapp.socgen.domain;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GenderValidator {

    Class<? extends Enum<?>> clazz() default Gender.class;

    String value();
}

