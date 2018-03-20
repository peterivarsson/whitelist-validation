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
public class UnicodeTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() {

        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        int i = 0;
    }

    /*
     * Accept only unicode charaters
     */
    @Test
    public void onlyUnicodeEmpty() {

        System.out.println("onlyUnicodeEmpty");

        TestUnicodeBean testBean = new TestUnicodeBean();
        testBean.setUnicodeString("");

        Set<ConstraintViolation<TestUnicodeBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only unicode charaters
     */
    @Test
    public void onlyUnicode() {

        System.out.println("onlyUnicode");

        TestUnicodeBean testBean = new TestUnicodeBean();
        testBean.setUnicodeString("ABCabcåäöÅÄÖüÜ \t\n\r\u0626");  // Arabic character

        Set<ConstraintViolation<TestUnicodeBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertTrue(violations.isEmpty());
    }

    /*
      * Accept only unicode charaters
     */
    @Test
    public void onlyUnicodeDigitFail() {

        System.out.println("onlyUnicodeJavaScriptFail");

        TestUnicodeBean testBean = new TestUnicodeBean();
        testBean.setUnicodeString("ABCabcåäöÅÄÖüÜ1234567890 \t\n\r\u0626");

        Set<ConstraintViolation<TestUnicodeBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
      * Accept only unicode charaters
     */
    @Test
    public void onlyUnicodeJavaScriptFail() {

        System.out.println("onlyUnicodeJavaScriptFail");

        TestUnicodeBean testBean = new TestUnicodeBean();
        testBean.setUnicodeString("<script>");

        Set<ConstraintViolation<TestUnicodeBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only unicode charaters
     */
    @Test
    public void onlyUnicodeSQLFail() {

        System.out.println("onlyUnicodeSQLFail");

        TestUnicodeBean testBean = new TestUnicodeBean();
        testBean.setUnicodeString("select * from users");

        Set<ConstraintViolation<TestUnicodeBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    @AfterClass
    public static void tearDown() {

        validatorFactory.close();
    }
}
