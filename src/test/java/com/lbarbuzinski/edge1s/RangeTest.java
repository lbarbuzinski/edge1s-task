package com.lbarbuzinski.edge1s;

import org.junit.Test;

import static org.junit.Assert.*;

public class RangeTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldNotCreateIncorrectRange() {
        new Range(4, 2);
    }

    @Test
    public void shouldCreateCorrectRange() {
        new Range(1, 2);
        new Range(4, 4);
    }

    @Test
    public void shouldBeExclusive() {
        assertTrue(new Range(1, 2).isExclusiveWith(new Range(3, 4)));
    }

    @Test
    public void shouldNotBeExclusive() {
        assertFalse(new Range(1, 2).isExclusiveWith(new Range(1, 4)));
    }

    @Test
    public void shouldBeMergeable() {
        assertTrue(new Range(1, 5).isMergeableWith(new Range(3, 4)));
    }

    @Test
    public void shouldMerge() {
        assertEquals(new Range(1, 5), new Range(1, 5).merge(new Range(3, 4)));
        assertEquals(new Range(1, 5), new Range(1, 3).merge(new Range(3, 5)));
        assertEquals(new Range(1, 5), new Range(1, 3).merge(new Range(2, 5)));
    }

    @Test
    public void shouldNotBeMergeable() {
        assertFalse(new Range(1, 6).isMergeableWith(new Range(-1, 0)));
    }
}