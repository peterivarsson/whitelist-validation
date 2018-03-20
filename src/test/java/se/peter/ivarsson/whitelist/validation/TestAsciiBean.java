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
public class TestAsciiBean {
    
    @Ascii
    private String asciiString;

    public void setAsciiString(String asciiString) {
        this.asciiString = asciiString;
    }
}
