package com.example.bookapimanytomany.controller;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

//@Documented
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NoSingleWordValidator.class)
public @interface NoSingleWord {

    String message() default "Value must not be a single word";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
