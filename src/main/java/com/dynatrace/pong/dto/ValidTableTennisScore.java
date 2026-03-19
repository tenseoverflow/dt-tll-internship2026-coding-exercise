package com.dynatrace.pong.dto;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Copilot used to create validation.

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TableTennisScoreValidator.class)
public @interface ValidTableTennisScore {
    String message() default "Invalid table tennis score: points must be up to 11 with win by 2, games max 5";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
