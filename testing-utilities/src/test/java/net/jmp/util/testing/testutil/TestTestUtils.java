package net.jmp.util.testing.testutil;

/*
 * (#)TestTestUtils.java    0.2.0   09/23/2024
 * (#)TestTestUtils.java    0.1.0   09/23/2024
 *
 * MIT License
 *
 * Copyright (c) 2024 Jonathan M. Parker
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.*;

import java.util.stream.Stream;

import static net.jmp.util.testing.testutil.TestUtils.*;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Test;

/**
 * The test class for TestUtils.
 *
 * @version 0.2.0
 * @since   0.1.0
 */
public final class TestTestUtils {
    @Test
    public void testCastToType() {
        final Object s = "Testing";
        final String string = castToType(String.class, s);

        assertNotNull(string);

        final Object l = List.of("one", "two", "three");
        final List<?> list = castToType(List.class, l);

        assertNotNull(list);
    }

    @Test
    public void testStreamToTypedList() {
        final Object s = Stream.of("one", "two", "three");
        final Stream<?> stream = castToType(Stream.class, s);
        final List<String> strings = streamToTypedList(stream, String.class);

        assertNotNull(stream);
        assertNotNull(strings);

        strings.forEach(Assert::assertNotNull);
    }

    @Test
    public void testListToTypedList() {
        final Object l = List.of("one", "two", "three");
        final List<?> list = castToType(List.class, l);
        final List<String> strings = listToTypedList(list, String.class);

        assertNotNull(list);
        assertNotNull(strings);

        strings.forEach(Assert::assertNotNull);
    }

    @Test
    public void testDequeToTypedDeque() {
        final Object d = new ArrayDeque<>();

        ((Deque<String>) d).add("one");
        ((Deque<String>) d).add("two");
        ((Deque<String>) d).add("three");

        final Deque<?> deque = castToType(Deque.class, d);
        final Deque<String> strings = dequeToTypedDeque(deque, String.class);

        assertNotNull(deque);
        assertNotNull(strings);

        strings.forEach(Assert::assertNotNull);
    }

    @Test
    public void testMapToTypedMap() {
        final Object m = Map.of(1, "one", 2, "two", 3, "three");
        final Map<?, ?> map = castToType(Map.class, m);
        final Map<Integer, String> dictionary = mapToTypedMap(map, Integer.class, String.class);

        assertNotNull(map);
        assertNotNull(dictionary);

        dictionary.forEach((k, v) -> {
            assertNotNull(k);
            assertNotNull(v);
        });
    }

    @Test
    public void testSetToTypedSet() {
        final Object s = Set.of("one", "two", "three");
        final Set<?> set = castToType(Set.class, s);
        final Set<String> strings = setToTypedSet(set, String.class);

        assertNotNull(set);
        assertNotNull(strings);

        strings.forEach(Assert::assertNotNull);
    }
}
