package com.abhaynoor.Hotel_Management_System.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target({ ElementType.TYPE, ElementType.FIELD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {

	String message() default "Invalid email";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default{};
	
}
