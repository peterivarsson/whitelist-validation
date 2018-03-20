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
public class TestDigitBean {
    
    @Digit
    private String digitString;

    public void setDigitString(String digitString) {
        this.digitString = digitString;
    }
}
