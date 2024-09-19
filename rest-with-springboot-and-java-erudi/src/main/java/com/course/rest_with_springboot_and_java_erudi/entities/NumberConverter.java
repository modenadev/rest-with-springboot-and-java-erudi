package com.course.rest_with_springboot_and_java_erudi.entities;

public class NumberConverter {

    public static Double convertToDouble(String strNumber) {

        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(ItsNumeric.isNumeric(number)) return Double.parseDouble(number);
        return 0D;

    }
}
