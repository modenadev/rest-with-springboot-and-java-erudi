package com.course.rest_with_springboot_and_java_erudi;

import com.course.rest_with_springboot_and_java_erudi.entities.NumberConverter;
import com.course.rest_with_springboot_and_java_erudi.entities.ItsNumeric;
import com.course.rest_with_springboot_and_java_erudi.excpetions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Math.sqrt;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne,
                      @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        validateNumbers(numberOne, numberTwo);
        return NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/subtract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtract(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        validateNumbers(numberOne, numberTwo);
        return NumberConverter.convertToDouble(numberOne) - NumberConverter.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiply(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        validateNumbers(numberOne, numberTwo);
        return NumberConverter.convertToDouble(numberOne) * NumberConverter.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne,
                           @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        validateNumbers(numberOne, numberTwo);
        return NumberConverter.convertToDouble(numberOne) / NumberConverter.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media(@PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        validateNumbers(numberOne, numberTwo);
        return (NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo)) / 2; // Corrigido
    }

    @RequestMapping(value = "/raiz/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double raiz(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        validateNumbers(numberOne, numberTwo);
        return sqrt(NumberConverter.convertToDouble(numberOne) + NumberConverter.convertToDouble(numberTwo));
    }

    private void validateNumbers(String numberOne, String numberTwo) throws Exception {
        if (!ItsNumeric.isNumeric(numberOne) || !ItsNumeric.isNumeric(numberTwo)) { // Corrigido
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
    }
}
