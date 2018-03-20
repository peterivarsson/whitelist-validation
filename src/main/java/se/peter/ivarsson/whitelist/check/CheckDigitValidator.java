/*
 * Whitelist validate input fields and parameters (Been Validaton)
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.whitelist.check;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import se.peter.ivarsson.whitelist.validation.Digit;

/**
 * Check string is only digits
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class CheckDigitValidator implements ConstraintValidator<Digit, String> {

    private static final Pattern ONLY_DIGITS = Pattern.compile("[0-9]*");

    @Override
    public void initialize(Digit constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.isEmpty()) {

            return false;
        }

        return ONLY_DIGITS.matcher(value).matches();
    }
}
