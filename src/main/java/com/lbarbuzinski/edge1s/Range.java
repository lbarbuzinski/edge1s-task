package com.lbarbuzinski.edge1s;

import java.util.Objects;

public class Range {

    private final Integer start;
    private final Integer end;

    public Range(int start, int end) {
        if (start > end)
            throw new IllegalArgumentException("incorrect range");

        this.start = start;
        this.end = end;
    }

    public boolean isExclusiveWith(Range another) {
        return end < another.start || start > another.end;
    }

    public Range merge(Range another) {
        if (!isMergeableWith(another))
            throw new IllegalArgumentException("not mergeable");

        return new Range(Math.min(start, another.start), Math.max(end, another.end));
    }

    public boolean isMergeableWith(Range another) {
        return !isExclusiveWith(another);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Range range = (Range) o;
        return start.equals(range.start) &&
                end.equals(range.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}
