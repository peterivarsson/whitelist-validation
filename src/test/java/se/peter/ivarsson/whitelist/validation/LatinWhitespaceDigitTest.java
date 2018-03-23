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
public class LatinWhitespaceDigitTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() {

        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        int i = 0;
    }

    /*
     * Accept only Latin and Whitespace Characters or digits
     */
    @Test
    public void onlyLatinWhitespaceDigitEmpty() {

        System.out.println("onlyLatinWhitespaceDigitEmpty");

        TestLatinWhitespaceDigitBean testBean = new TestLatinWhitespaceDigitBean();
        testBean.setLatinWhitespaceDigitString("");

        Set<ConstraintViolation<TestLatinWhitespaceDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Latin and Whitespace Characters or digits
     */
    @Test
    public void onlyLatinWhitespaceDigit() {

        System.out.println("onlyLatinWhitespaceDigit");

        TestLatinWhitespaceDigitBean testBean = new TestLatinWhitespaceDigitBean();
        testBean.setLatinWhitespaceDigitString("ABCabcåäöÅÄÖüÜ1234567890 \t\n\r");

        Set<ConstraintViolation<TestLatinWhitespaceDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertTrue(violations.isEmpty());
    }

    /*
     * Accept only Latin and Whitespace Characters or digits
     */
    @Test
    public void onlyLatinWhitespaceDigitFail() {

        System.out.println("onlyLatinWhitespaceDigitFail");

        TestLatinWhitespaceDigitBean testBean = new TestLatinWhitespaceDigitBean();
        testBean.setLatinWhitespaceDigitString("ABCabcåäöÅÄÖüÜ1234567890 \t\n\r\u0626");  // Arabic character

        Set<ConstraintViolation<TestLatinWhitespaceDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
      * Accept only Latin and Whitespace Characters or digits
     */
    @Test
    public void onlyLatinWhitespaceDigitJavaScriptFail() {

        System.out.println("onlyLatinWhitespaceDigitJavaScriptFail");

        TestLatinWhitespaceDigitBean testBean = new TestLatinWhitespaceDigitBean();
        testBean.setLatinWhitespaceDigitString("<script>");

        Set<ConstraintViolation<TestLatinWhitespaceDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Latin and Whitespace Characters or digits
     */
    @Test
    public void onlyLatinWhitespaceDigitSQLFail() {

        System.out.println("onlyLatinWhitespaceDigitSQLFail");

        TestLatinWhitespaceDigitBean testBean = new TestLatinWhitespaceDigitBean();
        testBean.setLatinWhitespaceDigitString("select * from users");

        Set<ConstraintViolation<TestLatinWhitespaceDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    @AfterClass
    public static void tearDown() {

        validatorFactory.close();
    }
}
