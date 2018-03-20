/*
 * Whitelist validate input fields and parameters (Been Validaton)
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.whitelist.check;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import se.peter.ivarsson.whitelist.validation.Ascii;

/**
 * Check string only has Ascii characters
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class CheckAsciiValidator implements ConstraintValidator<Ascii, String> {

    private static final Pattern ONLY_ASCII_CHARACTERS = Pattern.compile("[a-zA-Z]*");

    @Override
    public void initialize(Ascii constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.isEmpty()) {

            return false;
        }

        return ONLY_ASCII_CHARACTERS.matcher(value).matches();
    }
}
