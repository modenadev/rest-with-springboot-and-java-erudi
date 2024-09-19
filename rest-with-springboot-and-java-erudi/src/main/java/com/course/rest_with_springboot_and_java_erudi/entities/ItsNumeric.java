package com.course.rest_with_springboot_and_java_erudi.entities;

public class ItsNumeric {


    public static boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }
}
