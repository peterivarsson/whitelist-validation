/*
 * Whitelist validate input fields and parameters (Been Validaton)
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.whitelist.check;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import se.peter.ivarsson.whitelist.validation.UnicodeDigit;

/**
 * Check string only has Unicode characters, whitespace and digits
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class CheckUnicodeDigitValidator implements ConstraintValidator<UnicodeDigit, String> {

    private static final Pattern ONLY_UNICODE_CHARACTERS_AND_DIGITS_AND_WHITESPACE = Pattern.compile("[\\p{L}\\s0-9]*");  // Allow Unicode characters, whitespace and digits

    @Override
    public void initialize(UnicodeDigit constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.isEmpty()) {

            return false;
        }

        return ONLY_UNICODE_CHARACTERS_AND_DIGITS_AND_WHITESPACE.matcher(value).matches();
    }
}
