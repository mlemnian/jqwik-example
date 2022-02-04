package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;

public class AdderSpec {

    Adder cut = new Adder();

    @Property
    public void commutativity(@ForAll @IntRange(min = -30, max = 30) int a,
            @ForAll @IntRange(min = -30, max = 30) int b) {
        assertEquals(cut.add(a, b), cut.add(b, a));
    }

    @Property
    public void associativity(@ForAll @IntRange(min = -30, max = 30) int a,
            @ForAll @IntRange(min = -30, max = 30) int b, @ForAll @IntRange(min = -30, max = 30) int c) {
        assertEquals(cut.add(cut.add(a, b), c), cut.add(a, cut.add(b, c)));
    }

    @Property
    void distributivity(@ForAll @IntRange(min = -30, max = 30) int a, @ForAll @IntRange(min = -30, max = 30) int b,
            @ForAll @IntRange(min = -30, max = 30) int c) {
        assertEquals(cut.add(a, b) * c, cut.add(a * c, b * c));
    }

    @Property
    public void neutralElementIsZero(@ForAll @IntRange(min = -30, max = 30) int a) {
        assertEquals(a, cut.add(a, 0));
    }

    @Property
    public void addingYourInverseIsZero(@ForAll @IntRange(min = -30, max = 30) int a) {
        assertEquals(0, cut.add(a, -1 * a));
    }

    @Property
    public void addingThreeIsEqualToAddingThreeTimesAOne(@ForAll @IntRange(min = -30, max = 30) int a) {
        assertEquals(cut.add(a, 3), cut.add(cut.add(cut.add(a, 1), 1), 1));
    }
}
