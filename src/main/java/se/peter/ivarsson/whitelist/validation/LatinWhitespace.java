/*
 * Whitelist validate input fields and parameters (Been Validaton)
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.whitelist.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import se.peter.ivarsson.whitelist.check.CheckLatinWhitespaceValidator;

/**
 * Check string only has Latin characters and whitespace
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = CheckLatinWhitespaceValidator.class)
public @interface LatinWhitespace {

    String message() default "Please enter only Latin charaters and whitespace.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
