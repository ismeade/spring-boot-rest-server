package com.ade.demo.server.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void isNumeric() {
        assertTrue(StringUtils.isNumeric("123"));
        assertFalse(StringUtils.isNumeric("123asd"));
        assertTrue(StringUtils.isNumeric("-123"));
        assertFalse(StringUtils.isNumeric("--123a"));
        assertTrue(StringUtils.isNumeric("0123"));
        assertTrue(StringUtils.isNumeric("-0123"));
    }
}