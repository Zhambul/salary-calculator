package ru.siblion.salary_calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhambyl on 24/03/2017.
 */
@RestController
@EnableAutoConfiguration
public class Controller {

    private final SalaryCalculator calculator = new SalaryCalculator();

    @GetMapping("/{salary}")
    public YearReport index(@PathVariable double salary) {
        return calculator.calculateForYear(salary);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Controller.class, args);
    }
}
