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
public class LatinDigitTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() {

        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        int i = 0;
    }

    /*
     * Accept only Latin Characters and digits
     */
    @Test
    public void onlyLatinDigitEmpty() {

        System.out.println("onlyLatinDigitEmpty");

        TestLatinDigitBean testBean = new TestLatinDigitBean();
        testBean.setLatinDigitString("");

        Set<ConstraintViolation<TestLatinDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Latin Characters and digits
     */
    @Test
    public void onlyLatinDigit() {

        System.out.println("onlyLatinDigit");

        TestLatinDigitBean testBean = new TestLatinDigitBean();
        testBean.setLatinDigitString("ABCabcåäöÅÄÖüÜ1234567890 ");

        Set<ConstraintViolation<TestLatinDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertTrue(violations.isEmpty());
    }

    /*
     * Accept only Latin Characters and digits
     */
    @Test
    public void onlyLatinDigit1Fail() {

        System.out.println("onlyLatinDigit1Fail");

        TestLatinDigitBean testBean = new TestLatinDigitBean();
        testBean.setLatinDigitString("ABCabcåäöÅÄÖüÜ1234567890 \n"); 

        Set<ConstraintViolation<TestLatinDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Latin Characters and digits
     */
    @Test
    public void onlyLatinDigit2Fail() {

        System.out.println("onlyLatinDigit2Fail");

        TestLatinDigitBean testBean = new TestLatinDigitBean();
        testBean.setLatinDigitString("ABCabcåäöÅÄÖüÜ1234567890 \u0626");  // Arabic character

        Set<ConstraintViolation<TestLatinDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
      * Accept only Latin Characters and digits
     */
    @Test
    public void onlyLatinDigitJavaScriptFail() {

        System.out.println("onlyLatinDigitJavaScriptFail");

        TestLatinDigitBean testBean = new TestLatinDigitBean();
        testBean.setLatinDigitString("<script>");

        Set<ConstraintViolation<TestLatinDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Latin Characters and digits
     */
    @Test
    public void onlyLatinDigitSQLFail() {

        System.out.println("onlyLatinDigitSQLFail");

        TestLatinDigitBean testBean = new TestLatinDigitBean();
        testBean.setLatinDigitString("select * from users");

        Set<ConstraintViolation<TestLatinDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    @AfterClass
    public static void tearDown() {

        validatorFactory.close();
    }
}
