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
public class AsciiTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() {

        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        int i = 0;
    }

    /*
     * Accept only Ascii Characters
     */
    @Test
    public void onlyAsciiCharactersEmpty() {

        System.out.println("onlyAsciiCharactersEmpty");

        TestAsciiBean testBean = new TestAsciiBean();
        testBean.setAsciiString("");

        Set<ConstraintViolation<TestAsciiBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Ascii Characters
     */
    @Test
    public void onlyAsciiCharacters() {

        System.out.println("onlyAsciiCharacters");

        TestAsciiBean testBean = new TestAsciiBean();
        testBean.setAsciiString("ABC");

        Set<ConstraintViolation<TestAsciiBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertTrue(violations.isEmpty());
    }

    /*
     * Accept only Ascii Characters
     */
    @Test
    public void onlyAsciiCharactersFail() {

        System.out.println("onlyAsciiCharactersFail");

        TestAsciiBean testBean = new TestAsciiBean();
        testBean.setAsciiString("ABCÅ");

        Set<ConstraintViolation<TestAsciiBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Ascii Characters
     */
    @Test
    public void onlyAsciiCharactersSpaceFail() {

        System.out.println("onlyAsciiCharactersSpaceFail");

        TestAsciiBean testBean = new TestAsciiBean();
        testBean.setAsciiString("ABC ");

        Set<ConstraintViolation<TestAsciiBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Ascii Characters
     */
    @Test
    public void onlyAsciiCharactersJavaScriptFail() {

        System.out.println("onlyAsciiCharactersJavaScriptFail");

        TestAsciiBean testBean = new TestAsciiBean();
        testBean.setAsciiString("<script>");

        Set<ConstraintViolation<TestAsciiBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Ascii Characters
     */
    @Test
    public void onlyAsciiCharactersSQLFail() {

        System.out.println("onlyAsciiCharactersSQLFail");

        TestAsciiBean testBean = new TestAsciiBean();
        testBean.setAsciiString("select * from users");

        Set<ConstraintViolation<TestAsciiBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    @AfterClass
    public static void tearDown() {

        validatorFactory.close();
    }
}
