package ru.siblion.salary_calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhambyl on 23/03/2017.
 */
public class YearReport {

    private final double salary;

    public YearReport(double salary) {
        this.salary = salary;
    }

    private final List<MonthReport> months = new ArrayList<>();

    public List<MonthReport> getMonths() {
        return new ArrayList<>(months);
    }

    public void addMonthReport(MonthReport monthReport) {
        months.add(monthReport);
    }
}
