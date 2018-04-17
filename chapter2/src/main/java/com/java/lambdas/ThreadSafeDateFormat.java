package com.java.lambdas;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadSafeDateFormat extends DateFormat {
    private static final ThreadLocal<DateFormat> DATE_FORMAT_THREAD_LOCAL = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd-MMM-yyyy"));

    @Override
    public StringBuffer format(Date date, StringBuffer toAppendTo, FieldPosition fieldPosition) {
        return DATE_FORMAT_THREAD_LOCAL.get().format(date, toAppendTo, fieldPosition);
    }

    @Override
    public Date parse(String source, ParsePosition pos) {
        return DATE_FORMAT_THREAD_LOCAL.get().parse(source, pos);
    }
}
