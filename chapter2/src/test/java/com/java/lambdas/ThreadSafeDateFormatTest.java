package com.java.lambdas;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class ThreadSafeDateFormatTest {
    @Test
    public void date_should_follow_dd_mmm_yyyy() {
        String expected = "01-jun-2017";
        Calendar calendar = Calendar.getInstance();
        calendar.set(2017, Calendar.JUNE, 1);

        String actual = new ThreadSafeDateFormat().format(calendar.getTime());

        assertEquals(expected, actual);
    }
}
