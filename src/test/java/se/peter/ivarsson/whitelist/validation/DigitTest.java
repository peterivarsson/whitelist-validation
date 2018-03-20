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
public class DigitTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() {

        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        int i = 0;
    }

    /*
     * Accept only digits
     */
    @Test
    public void onlyDigitEmpty() {

        System.out.println("onlyDigitEmpty");

        TestDigitBean testBean = new TestDigitBean();
        testBean.setDigitString("");

        Set<ConstraintViolation<TestDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only digits
     */
    @Test
    public void onlyDigit() {

        System.out.println("onlyDigit");

        TestDigitBean testBean = new TestDigitBean();
        testBean.setDigitString("1234567890");

        Set<ConstraintViolation<TestDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertTrue(violations.isEmpty());
    }

    /*
     * Accept only digits
     */
    @Test
    public void onlyDigitFail() {

        System.out.println("onlyDigitFail");

        TestDigitBean testBean = new TestDigitBean();
        testBean.setDigitString("1234567890abc");

        Set<ConstraintViolation<TestDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
      * Accept only digits
     */
    @Test
    public void onlyDigitSpaceFail() {

        System.out.println("onlyDigitSpaceFail");

        TestDigitBean testBean = new TestDigitBean();
        testBean.setDigitString("1234567890 ");

        Set<ConstraintViolation<TestDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
      * Accept only digits
     */
    @Test
    public void onlyDigitJavaScriptFail() {

        System.out.println("onlyDigitJavaScriptFail");

        TestDigitBean testBean = new TestDigitBean();
        testBean.setDigitString("<script>");

        Set<ConstraintViolation<TestDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only digits
     */
    @Test
    public void onlyDigitSQLFail() {

        System.out.println("onlyDigitSQLFail");

        TestDigitBean testBean = new TestDigitBean();
        testBean.setDigitString("select * from users");

        Set<ConstraintViolation<TestDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    @AfterClass
    public static void tearDown() {

        validatorFactory.close();
    }
}
