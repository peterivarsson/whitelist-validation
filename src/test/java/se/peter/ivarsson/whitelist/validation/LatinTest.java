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
public class LatinTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() {

        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        int i = 0;
    }

    /*
     * Accept only Latin Characters and ' '
     */
    @Test
    public void onlyLatinEmpty() {

        System.out.println("onlyLatinEmpty");

        TestLatinBean testBean = new TestLatinBean();
        testBean.setLatinString("");

        Set<ConstraintViolation<TestLatinBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Latin Characters and ' '
     */
    @Test
    public void onlyLatin() {

        System.out.println("onlyLatin");

        TestLatinBean testBean = new TestLatinBean();
        testBean.setLatinString("ABCabcåäöÅÄÖüÜ ");

        Set<ConstraintViolation<TestLatinBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertTrue(violations.isEmpty());
    }

    /*
     * Accept only Latin Characters and ' '
     */
    @Test
    public void onlyLatin1Fail() {

        System.out.println("onlyLatin1Fail");

        TestLatinBean testBean = new TestLatinBean();
        testBean.setLatinString("ABCabcåäöÅÄÖüÜ \n");  // Arabic character

        Set<ConstraintViolation<TestLatinBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Latin Characters and ' '
     */
    @Test
    public void onlyLatin2Fail() {

        System.out.println("onlyLatin2Fail");

        TestLatinBean testBean = new TestLatinBean();
        testBean.setLatinString("ABCabcåäöÅÄÖüÜ 0626");  // Arabic character

        Set<ConstraintViolation<TestLatinBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
      * Accept only Latin Characters and ' '
     */
    @Test
    public void onlyLatinJavaScriptFail() {

        System.out.println("onlyLatinJavaScriptFail");

        TestLatinBean testBean = new TestLatinBean();
        testBean.setLatinString("<script>");

        Set<ConstraintViolation<TestLatinBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Latin Characters and ' '
     */
    @Test
    public void onlyLatinSQLFail() {

        System.out.println("onlyLatinSQLFail");

        TestLatinBean testBean = new TestLatinBean();
        testBean.setLatinString("select * from users");

        Set<ConstraintViolation<TestLatinBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    @AfterClass
    public static void tearDown() {

        validatorFactory.close();
    }
}
