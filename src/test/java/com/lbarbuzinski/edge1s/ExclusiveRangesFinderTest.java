package com.lbarbuzinski.edge1s;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExclusiveRangesFinderTest {

    private ExclusiveRangesFinder finder = new ExclusiveRangesFinder();

    @Test
    public void shouldDetectOverlappingRanges() {
        assertEquals(1, finder.countExclusiveRanges(new Range(1, 3), new Range(2, 5)));
        assertEquals(1, finder.countExclusiveRanges(new Range(1, 3), new Range(-1, 10), new Range(4, 7)));
    }

    @Test
    public void shouldDetectExclusiveRanges() {
        assertEquals(2, finder.countExclusiveRanges(new Range(1, 3), new Range(4, 5)));
    }

    @Test
    public void shouldBeAwareOfClosedRanges() {
        assertEquals(1, finder.countExclusiveRanges(new Range(1, 3), new Range(3, 5)));
    }
}