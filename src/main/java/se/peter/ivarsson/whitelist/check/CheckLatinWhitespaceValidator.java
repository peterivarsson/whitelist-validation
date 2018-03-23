/*
 * Whitelist validate input fields and parameters (Been Validaton)
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.whitelist.check;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import se.peter.ivarsson.whitelist.validation.LatinWhitespace;

/**
 * Check string only has Latin characters and whitespace
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class CheckLatinWhitespaceValidator implements ConstraintValidator<LatinWhitespace, String> {

    private static final Pattern ONLY_LATIN_CHARACTERS_AND_WHITESPACE = Pattern.compile("[\\p{IsLatin}\\s]*");  // Allow Latin characters and whitespace

    @Override
    public void initialize(LatinWhitespace constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.isEmpty()) {

            return false;
        }

        return ONLY_LATIN_CHARACTERS_AND_WHITESPACE.matcher(value).matches();
    }
}
