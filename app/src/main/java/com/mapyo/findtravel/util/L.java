package com.mapyo.findtravel.util;

import android.support.compat.BuildConfig;
import android.util.Log;

import java.util.regex.Pattern;

public class L {
    public static void d(String msg) {
        if (!BuildConfig.DEBUG) return;
        Log.d(getTag(), msg);
    }

    public static void d(int i) {
        d(String.valueOf(i));
    }

    public static void d(boolean bool) {
        d(String.valueOf(bool));
    }

    public static void d(float i) {
        d(String.valueOf(i));
    }

    public static void d(CharSequence charSequence) {
        d(String.valueOf(charSequence));
    }

    public static void e(String msg) {
        Log.e(getTag(), msg);
    }

    public static void e(String msg, Throwable t) {
        Log.e(getTag(), msg, t);
    }

    private static String getTag() {
        final StackTraceElement trace = Thread.currentThread().getStackTrace()[4];
        final String className = trace.getClassName();
        Pattern pattern = Pattern.compile("[\\.]+");
        final String[] splitStrings = pattern.split(className);
        final String simpleClass = splitStrings[splitStrings.length - 1];
        final String methodName = trace.getMethodName();
        final int line = trace.getLineNumber();
        return simpleClass + "#" + methodName + ":" + line;
    }
}
