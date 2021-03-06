/*
 * Whitelist validate input fields and parameters (Been Validaton)
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.whitelist.check;

import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import se.peter.ivarsson.whitelist.validation.Latin;

/**
 * Check string only has Latin characters and ' '
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class CheckLatinValidator implements ConstraintValidator<Latin, String> {

    private static final Pattern ONLY_LATIN_CHARACTERS_AND_SPACE = Pattern.compile("[\\p{IsLatin} ]*");  // Allow Latin characters and whitespace

    @Override
    public void initialize(Latin constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value.isEmpty()) {

            return false;
        }

        return ONLY_LATIN_CHARACTERS_AND_SPACE.matcher(value).matches();
    }
}
