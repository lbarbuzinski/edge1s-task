package com.lbarbuzinski.edge1s;

import java.util.stream.Stream;


public class ExclusiveRangesFinder {

    public int countExclusiveRanges(Range... ranges) {
        ExclusiveRanges exclusiveRanges = new ExclusiveRanges();
        Stream.of(ranges).forEach(exclusiveRanges::add);

        return exclusiveRanges.size();
    }
}
