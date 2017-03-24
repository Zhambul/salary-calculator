package ru.siblion.salary_calculator;

/**
 * Created by zhambyl on 23/03/2017.
 */
public class MonthReport {

    private final MonthInfo info;
    private final double prevMonthRestSalary;
    private final double salaryInAdvance;

    public MonthReport(double prevMonthRestSalary, double salaryInAdvance, MonthInfo info) {
        this.prevMonthRestSalary = prevMonthRestSalary;
        this.salaryInAdvance = salaryInAdvance;
        this.info = info;
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
