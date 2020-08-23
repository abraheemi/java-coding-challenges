package com.abraheem;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParenthesesTest {
    Parentheses p;
    @Before
    public void setUp() throws Exception {
        p = new Parentheses();
    }

    @Test
    public void isMatch() {
        assertTrue(p.isMatch("(a)a(a)"));
        assertTrue(p.isMatch("aa"));
        assertTrue(p.isMatch(""));
        assertFalse(p.isMatch(")(a())"));
        assertFalse(p.isMatch("(()"));
    }

    @Test
    public void depth() {
        assertEquals(4, p.depth("( a(b) (c) (d(e(f)g)h) I (j(k)l)m)"));
        assertEquals(3, p.depth("( p((q)) ((s)t) )"));
        assertEquals(3, p.depth("(()(())"));
    }
}