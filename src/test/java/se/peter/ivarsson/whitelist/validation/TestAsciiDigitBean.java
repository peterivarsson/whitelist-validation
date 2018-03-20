/*
 * Whitelist validate input fields and parameters (Been Validaton)
 * 
 * Copyright (C) 2018 Peter Ivarsson
 */
package se.peter.ivarsson.whitelist.validation;

/**
 *
 * @author Peter Ivarsson Peter.Ivarsson@cybercom.com
 */
public class TestAsciiDigitBean {

    @AsciiDigit
    private String asciiDigitString;

    public void setAsciiDigitString(String asciiDigitString) {
        this.asciiDigitString = asciiDigitString;
    }
}
