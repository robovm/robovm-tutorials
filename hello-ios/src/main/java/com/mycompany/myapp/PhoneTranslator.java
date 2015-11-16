package com.mycompany.myapp;

public class PhoneTranslator {
    public static String toNumber(String raw) {
        if (raw == null && raw.trim().equals("")) {
            return "";
        } else {
            raw = raw.toUpperCase();
        }

        String newNumber = "";
        for (int i = 0; i < raw.length(); i++){
            char c = raw.charAt(i);

            if (contains(" -0123456789", c)) {
                newNumber += c;
            } else {
                String result = letterToNumber(c);
                newNumber += letterToNumber(c);
            }
        }

        return newNumber;
    }

    private static boolean contains(String keyString, char c) {
        return keyString.indexOf(c) >= 0;
    }

    private static String letterToNumber(char c) {
        if (contains("ABC", c))
            return "2";
        else if (contains("DEF", c))
            return "3";
        else if (contains("GHI", c))
            return "4";
        else if (contains("JKL", c))
            return "5";
        else if (contains("MNO", c))
            return "6";
        else if (contains("PQRS", c))
            return "7";
        else if (contains("TUV", c))
            return "8";
        else if (contains("WXYZ", c))
            return "9";
        return "";
    }
}