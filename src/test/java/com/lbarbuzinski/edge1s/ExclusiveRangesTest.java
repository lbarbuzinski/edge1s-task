package com.lbarbuzinski.edge1s;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExclusiveRangesTest {

    @Test
    public void emptyCollectionShouldHaveZeroSize() {
        assertEquals(0, new ExclusiveRanges().size());
    }

    @Test
    public void shouldAddRangeToEmptyCollection() {
        //given
        ExclusiveRanges collection = new ExclusiveRanges();

        //when
        collection.add(new Range(1, 4));

        //then
        assertEquals(1, collection.size());
    }

    @Test
    public void shouldAddExclusiveRange() {
        //given
        ExclusiveRanges collection = new ExclusiveRanges();
        collection.add(new Range(1, 4));

        //when
        collection.add(new Range(5, 7));

        //then
        assertEquals(2, collection.size());
    }

    @Test
    public void shouldMergeRanges() {
        //given
        ExclusiveRanges collection = new ExclusiveRanges();
        Range firstRange = new Range(1, 4);
        collection.add(firstRange);

        //when
        Range secondRange = new Range(3, 5);
        collection.add(secondRange);

        //then
        assertEquals(1, collection.size());
        assertEquals(firstRange.merge(secondRange), collection.iterator().next());
    }

}