package com.evolution.sqlcore.utils;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

public class StringTools {
    public static String format(String template, List<String> args) {
        return MessageFormat.format(template, args.toArray());
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }


    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String trim(String str) {
        return str == null ? null : str.trim();
    }

    public static String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean containsIgnoreCase(String str, String substring) {
        if (str == null || substring == null) {
            return false;
        }
        return str.toLowerCase().contains(substring.toLowerCase());
    }

    public static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static String uncapitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static String join(List<String> list, String delimiter) {
        if (list == null) {
            return null;
        }
        return list.stream().collect(Collectors.joining(delimiter));
    }

    public static String[] split(String str, String delimiter) {
        if (str == null) {
            return null;
        }
        return str.split(delimiter);
    }

    public static String repeat(String str, int times) {
        if (str == null || times <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
