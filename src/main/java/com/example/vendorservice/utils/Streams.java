package com.example.vendorservice.utils;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {
    private Streams() {
    }

    public static <T> Stream<T> ofNullable(Collection<T> collection) {
        return Objects.isNull(collection) ? Stream.empty() : collection.stream();
    }

    public static <T> Stream<T> ofNullable(Optional<? extends Collection<T>> optional) {
        return Objects.nonNull(optional) && optional.isPresent() ? ((Collection)optional.get()).stream() : Stream.empty();
    }

    public static <T> Stream<T> ofNullable(T[] arrays) {
        return Objects.isNull(arrays) ? Stream.empty() : Arrays.stream(arrays);
    }

    public static <T> Stream<T> of(T... arrays) {
        return !Objects.isNull(arrays) && arrays.length != 0 ? Arrays.stream(arrays) : Stream.empty();
    }
}
