package com.lbarbuzinski.edge1s;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExclusiveRanges {

    private Set<Range> ranges = new HashSet<>();

    public void add(Range toBeAdded) {
        Set<Range> exclusive = ranges.stream().filter(r -> r.isExclusiveWith(toBeAdded)).collect(Collectors.toSet());

        Stream<Range> mergeable = Stream.concat(
                Stream.of(toBeAdded),
                ranges.stream().filter(r -> r.isMergeableWith(toBeAdded)));

        Optional<Range> maybeMerged = mergeable.reduce(Range::merge);

        this.ranges = new HashSet<>(exclusive);
        maybeMerged.ifPresent(merged -> ranges.add(merged));
    }

    public int size() {
        return ranges.size();
    }

    public Iterator<Range> iterator() {
        return new HashSet<>(ranges).iterator();
    }
}
