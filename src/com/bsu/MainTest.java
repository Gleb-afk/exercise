package com.bsu;

import org.junit.jupiter.api.Test;

import static com.bsu.Laba3.func;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void test() {
        String s = "hfkewu jeklfj,. ,f.we flah , niae";
        String actual = func(s);
        System.out.println(actual);
        String expected = "f flah hfkewu jeklfj niae we";
        assertEquals(expected, actual);
    }
}