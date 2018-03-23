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
public class LatinWhitespaceTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() {

        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        int i = 0;
    }

    /*
     * Accept Latin and Whitespace Characters
     */
    @Test
    public void onlyLatinWhitespaceEmpty() {

        System.out.println("onlyLatinWhitespaceEmpty");

        TestLatinWhitespaceBean testBean = new TestLatinWhitespaceBean();
        testBean.setLatinWhitespaceString("");

        Set<ConstraintViolation<TestLatinWhitespaceBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept Latin and Whitespace Characters
     */
    @Test
    public void onlyLatinWhitespace() {

        System.out.println("onlyLatinWhitespace");

        TestLatinWhitespaceBean testBean = new TestLatinWhitespaceBean();
        testBean.setLatinWhitespaceString("ABCabcåäöÅÄÖüÜ \t\n\r");

        Set<ConstraintViolation<TestLatinWhitespaceBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertTrue(violations.isEmpty());
    }

    /*
     * Accept Latin and Whitespace Characters
     */
    @Test
    public void onlyLatinWhitespaceFail() {

        System.out.println("onlyLatinWhitespaceFail");

        TestLatinWhitespaceBean testBean = new TestLatinWhitespaceBean();
        testBean.setLatinWhitespaceString("ABCabcåäöÅÄÖüÜ \t\n\r\u0626");  // Arabic character

        Set<ConstraintViolation<TestLatinWhitespaceBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
      * Accept Latin and Whitespace Characters
     */
    @Test
    public void onlyLatinWhitespaceJavaScriptFail() {

        System.out.println("onlyLatinWhitespaceJavaScriptFail");

        TestLatinWhitespaceBean testBean = new TestLatinWhitespaceBean();
        testBean.setLatinWhitespaceString("<script>");

        Set<ConstraintViolation<TestLatinWhitespaceBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept Latin and Whitespace Characters
     */
    @Test
    public void onlyLatinWhitespaceSQLFail() {

        System.out.println("onlyLatinWhitespaceSQLFail");

        TestLatinWhitespaceBean testBean = new TestLatinWhitespaceBean();
        testBean.setLatinWhitespaceString("select * from users");

        Set<ConstraintViolation<TestLatinWhitespaceBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    @AfterClass
    public static void tearDown() {

        validatorFactory.close();
    }
}
