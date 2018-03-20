/*
 * Whitelist validate input fields and parameters (Been Validaton)
 *
 * Copyright (C) 2018 Peter Ivarsson.
 */
package se.peter.ivarsson.whitelist.validation;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class UnicodeDigitTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() {

        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        int i = 0;
    }

    /*
     * Accept only unicode charaters and digits
     */
    @Test
    public void onlyUnicodeDigitEmpty() {

        System.out.println("onlyUnicodeDigitEmpty");

        TestUnicodeDigitBean testBean = new TestUnicodeDigitBean();
        testBean.setUnicodeDigitString("");

        Set<ConstraintViolation<TestUnicodeDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only unicode charaters and digits
     */
    @Test
    public void onlyUnicodeDigit() {

        System.out.println("onlyUnicodeDigit");

        TestUnicodeDigitBean testBean = new TestUnicodeDigitBean();
        testBean.setUnicodeDigitString("ABCabcåäöÅÄÖüÜ1234567890 \t\n\r\u0626");  // Arabic character

        Set<ConstraintViolation<TestUnicodeDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertTrue(violations.isEmpty());
    }

    /*
      * Accept only unicode charaters and digits
     */
    @Test
    public void onlyUnicodeDigitJavaScriptFail() {

        System.out.println("onlyUnicodeDigitJavaScriptFail");

        TestUnicodeDigitBean testBean = new TestUnicodeDigitBean();
        testBean.setUnicodeDigitString("<script>");

        Set<ConstraintViolation<TestUnicodeDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only unicode charaters and digits
     */
    @Test
    public void onlyUnicodeDigitSQLFail() {

        System.out.println("onlyUnicodeDigitSQLFail");

        TestUnicodeDigitBean testBean = new TestUnicodeDigitBean();
        testBean.setUnicodeDigitString("select * from users");

        Set<ConstraintViolation<TestUnicodeDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    @AfterClass
    public static void tearDown() {

        validatorFactory.close();
    }
}
