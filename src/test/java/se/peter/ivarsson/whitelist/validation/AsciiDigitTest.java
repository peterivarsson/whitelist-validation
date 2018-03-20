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
public class AsciiDigitTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeClass
    public static void setUp() {

        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        int i = 0;
    }

    /*
     * Accept only Ascii Characters and digits
     */
    @Test
    public void onlyAsciiCharactersDigitEmpty() {

        System.out.println("onlyAsciiCharactersDigitEmpty");

        TestAsciiDigitBean testBean = new TestAsciiDigitBean();
        testBean.setAsciiDigitString("");

        Set<ConstraintViolation<TestAsciiDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Ascii Characters and digits
     */
    @Test
    public void onlyAsciiCharactersDigit() {

        System.out.println("onlyAsciiCharactersDigit");

        TestAsciiDigitBean testBean = new TestAsciiDigitBean();
        testBean.setAsciiDigitString("ABCabc1234567890");

        Set<ConstraintViolation<TestAsciiDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertTrue(violations.isEmpty());
    }

    /*
     * Accept only Ascii Characters and digits
     */
    @Test
    public void onlyAsciiCharactersDigitFail() {

        System.out.println("onlyAsciiCharactersDigitFail");

        TestAsciiDigitBean testBean = new TestAsciiDigitBean();
        testBean.setAsciiDigitString("ABCabc1234567890Å");

        Set<ConstraintViolation<TestAsciiDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
      * Accept only Ascii Characters and digits
     */
    @Test
    public void onlyAsciiCharactersDigitSpaceFail() {

        System.out.println("onlyAsciiCharactersDigitSpaceFail");

        TestAsciiDigitBean testBean = new TestAsciiDigitBean();
        testBean.setAsciiDigitString("ABCabc1234567890 ");

        Set<ConstraintViolation<TestAsciiDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
      * Accept only Ascii Characters and digits
     */
    @Test
    public void onlyAsciiCharactersDigitJavaScriptFail() {

        System.out.println("onlyAsciiCharactersDigitJavaScriptFail");

        TestAsciiDigitBean testBean = new TestAsciiDigitBean();
        testBean.setAsciiDigitString("<script>");

        Set<ConstraintViolation<TestAsciiDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    /*
     * Accept only Ascii Characters and digits
     */
    @Test
    public void onlyAsciiCharactersDigitSQLFail() {

        System.out.println("onlyAsciiCharactersDigitSQLFail");

        TestAsciiDigitBean testBean = new TestAsciiDigitBean();
        testBean.setAsciiDigitString("select * from users");

        Set<ConstraintViolation<TestAsciiDigitBean>> violations = validator.validate(testBean);

        System.out.println(violations.toString());

        Assert.assertFalse(violations.isEmpty());
    }

    @AfterClass
    public static void tearDown() {

        validatorFactory.close();
    }
}
