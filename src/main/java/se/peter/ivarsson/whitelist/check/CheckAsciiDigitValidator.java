/*
 * Whitelist validate input fields and parameters (Been Validaton)
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.whitelist.check;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import se.peter.ivarsson.whitelist.validation.AsciiDigit;

/**
 * Check string only has Ascii characters and digits
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class CheckAsciiDigitValidator implements ConstraintValidator<AsciiDigit, String> {

    private static final Pattern ONLY_ASCII_CHARACTERS_AND_DIGITS = Pattern.compile("[a-zA-Z0-9]*");

    @Override
    public void initialize(AsciiDigit constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.isEmpty()) {

            return false;
        }

        return ONLY_ASCII_CHARACTERS_AND_DIGITS.matcher(value).matches();
    }
}
