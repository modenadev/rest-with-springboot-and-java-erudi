package com.course.rest_with_springboot_and_java_erudi;

import com.course.rest_with_springboot_and_java_erudi.excpetions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Math.sqrt;


@RestController
public class MathController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping(value =
            "/sum/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double sum
            (@PathVariable(value = "numberOne") String numberOne
                    , @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {

            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);

    }

    @RequestMapping(value =
            "/subtract/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double subctract
            (@PathVariable(value = "numberOne") String numberOne
                    , @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {

            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }
    @RequestMapping(value =
            "/multiply/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double multiply
            (@PathVariable(value = "numberOne") String numberOne
                    , @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {

            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value =
            "/division/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double division
            (@PathVariable(value = "numberOne") String numberOne
                    , @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {

            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping(value =
            "/media/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double media
            (@PathVariable(value = "numberOne") String numberOne
                    , @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {

            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo) / 2;
    }

    @RequestMapping(value =
            "/raiz/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double raiz
            (@PathVariable(value = "numberOne") String numberOne
                    , @PathVariable(value = "numberTwo") String numberTwo)

            throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {

            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return sqrt (convertToDouble(numberOne) + convertToDouble(numberTwo));
    }

    private Double convertToDouble(String strNumber) {

        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;

    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[+-]?[0-9]*\\.?[0-9]+");
    }


}