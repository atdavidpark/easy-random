/*
 * The MIT License
 *
 *   Copyright (c) 2016, Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 *
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *   of this software and associated documentation files (the "Software"), to deal
 *   in the Software without restriction, including without limitation the rights
 *   to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *   copies of the Software, and to permit persons to whom the Software is
 *   furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *   all copies or substantial portions of the Software.
 *
 *   THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *   IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *   FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *   AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *   LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *   OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *   THE SOFTWARE.
 */
package io.github.benas.randombeans.randomizers.time;

import io.github.benas.randombeans.api.Randomizer;
import io.github.benas.randombeans.randomizers.misc.EnumRandomizer;
import io.github.benas.randombeans.randomizers.time.internal.DayRandomizer;

import java.time.Month;
import java.time.MonthDay;

/**
 * A {@link Randomizer} that generates random {@link MonthDay}.
 *
 * @author Mahmoud Ben Hassine (mahmoud.benhassine@icloud.com)
 */
public class MonthDayRandomizer implements Randomizer<MonthDay> {

    private EnumRandomizer<Month> monthRandomizer;
    private DayRandomizer dayRandomizer;

    /**
     * Create a new {@link MonthDayRandomizer}.
     */
    public MonthDayRandomizer() {
        monthRandomizer = new EnumRandomizer<>(Month.class);
        dayRandomizer = new DayRandomizer();
    }

    /**
     * Create a new {@link MonthDayRandomizer}.
     *
     * @param seed initial seed
     */
    public MonthDayRandomizer(final long seed) {
        monthRandomizer = new EnumRandomizer<>(Month.class, seed);
        dayRandomizer = new DayRandomizer(seed);
    }

    /**
     * Create a new {@link MonthDayRandomizer}.
     *
     * @return a new {@link MonthDayRandomizer}.
     */
    public static MonthDayRandomizer aNewMonthDayRandomizer() {
        return new MonthDayRandomizer();
    }

    /**
     * Create a new {@link MonthDayRandomizer}.
     *
     * @param seed initial seed
     * @return a new {@link MonthDayRandomizer}.
     */
    public static MonthDayRandomizer aNewMonthDayRandomizer(final long seed) {
        return new MonthDayRandomizer(seed);
    }

    @Override
    public MonthDay getRandomValue() {
        Month randomMonth = monthRandomizer.getRandomValue();
        int randomDay = dayRandomizer.getRandomValue();
        return MonthDay.of(randomMonth, randomDay);
    }
}
