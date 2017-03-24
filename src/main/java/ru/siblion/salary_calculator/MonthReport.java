package ru.siblion.salary_calculator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhambyl on 23/03/2017.
 */
public class MonthReport {

    private final MonthInfo info;
    private final List<Payment> payments = new ArrayList<>();

    @JsonIgnore
    private final double prevMonthRestSalary;
    @JsonIgnore
    private final double salaryInAdvance;

    public MonthReport(double prevMonthRestSalary, double salaryInAdvance, MonthInfo info) {
        this.prevMonthRestSalary = prevMonthRestSalary;
        this.salaryInAdvance = salaryInAdvance;
        this.info = info;

        payments.add(new Payment(10, (int) prevMonthRestSalary));
        payments.add(new Payment(25, (int) salaryInAdvance));
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public double getPrevMonthRestSalary() {
        return prevMonthRestSalary;
    }

    public double getSalaryInAdvance() {
        return salaryInAdvance;
    }

    public MonthInfo getInfo() {
        return info;
    }

}
