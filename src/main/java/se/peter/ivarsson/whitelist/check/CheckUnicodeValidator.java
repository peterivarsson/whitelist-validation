/*
 * Whitelist validate input fields and parameters (Been Validaton)
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.whitelist.check;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import se.peter.ivarsson.whitelist.validation.Unicode;

/**
 * Check string only has Unicode characters and whitespace
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class CheckUnicodeValidator implements ConstraintValidator<Unicode, String> {

    private static final Pattern ONLY_UNICODE_CHARACTERS_AND_WHITESPACE = Pattern.compile("[\\p{L}\\s]*");  // Allow Unicode characters and whitespace

    @Override
    public void initialize(Unicode constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.isEmpty()) {

            return false;
        }

        return ONLY_UNICODE_CHARACTERS_AND_WHITESPACE.matcher(value).matches();
    }
}
