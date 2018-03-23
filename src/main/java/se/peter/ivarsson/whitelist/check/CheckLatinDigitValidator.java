/*
 * Whitelist validate input fields and parameters (Been Validaton)
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.whitelist.check;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import se.peter.ivarsson.whitelist.validation.LatinDigit;

/**
 * Check string only has Latin characters and ' '
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class CheckLatinDigitValidator implements ConstraintValidator<LatinDigit, String> {

    private static final Pattern ONLY_LATIN_CHARACTERS_AND_SPACE_AND_DIGITS = Pattern.compile("[\\p{IsLatin} 0-9]*");  // Allow Latin characters, whitespace and digits

    @Override
    public void initialize(LatinDigit constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.isEmpty()) {

            return false;
        }

        return ONLY_LATIN_CHARACTERS_AND_SPACE_AND_DIGITS.matcher(value).matches();
    }
}
