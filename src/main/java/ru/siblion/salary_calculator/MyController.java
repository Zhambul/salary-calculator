package ru.siblion.salary_calculator;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.BufferedWriter;

/**
 * Created by zhambyl on 24/03/2017.
 */

@Controller
@SpringBootApplication
@EnableWebMvc
public class MyController {

    private final SalaryCalculator calculator = new SalaryCalculator();

//    @GetMapping("/")
//    public String hi() {
//        return "hi";
//    }
//
//    @GetMapping("api/{salary}")
//    public YearReport salary(@PathVariable double salary) {
//        return calculator.calculateForYear(salary);
//    }

    @GetMapping(value = "/{salary}")
    public String initPage(ModelMap model, @PathVariable String salary) {
        YearReport yearReport = calculator.calculateForYear(Double.parseDouble(salary));
        model.addAttribute("yearReport", yearReport);
        return "output";
    }


    public static void main(String[] args) {
        BufferedWriter writer = null;
        switch (1) {
            case 1:
                boolean a = true;
                break;
            case 2:
                a = false;
                break;
        }
    }
}
