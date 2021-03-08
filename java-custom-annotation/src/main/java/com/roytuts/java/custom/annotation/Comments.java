package com.roytuts.java.custom.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Comments {

	String authorName();

	String createdDate();

	String lastModifiedDate() default "N/A";

	String lastModifiedBy() default "N/A";

	String[] reviewers();

}
