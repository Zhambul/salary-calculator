package ru.siblion.salary_calculator;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by zhambyl on 23/03/2017.
 */
public class MonthInfo {

    @JsonIgnore
    private final int month;
    private final String name;
    @JsonIgnore
    private final int firstHalfWorkingDays;
    @JsonIgnore
    private final int secondHalfWorkingDays;
    private final int workingDays;

    public MonthInfo(int month, int firstHalfWorkingDays, int secondHalfWorkingDays) {
        this.month = month;
        this.name = createName(month);
        this.firstHalfWorkingDays = firstHalfWorkingDays;
        this.secondHalfWorkingDays = secondHalfWorkingDays;
        this.workingDays = firstHalfWorkingDays + secondHalfWorkingDays;
    }

    public int getMonth() {
        return month;
    }

    public int getFirstHalfWorkingDays() {
        return firstHalfWorkingDays;
    }

    public int getSecondHalfWorkingDays() {
        return secondHalfWorkingDays;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public String getName() {
        return name;
    }

    private String createName(int value) {
        switch (value) {
            case 1:
                return "Январь";
            case 2:
                return "Февраль";
            case 3:
                return "Март";
            case 4:
                return "Апрель";
            case 5:
                return "Май";
            case 6:
                return "Июнь";
            case 7:
                return "Июль";
            case 8:
                return "Август";
            case 9:
                return "Сентябрь";
            case 10:
                return "Октябрь";
            case 11:
                return "Ноябрь";
            case 12:
                return "Декабрь";
            default: throw new IllegalArgumentException("unknown month value " + value);
        }
    }

    @Override
    public String toString() {
        return "ru.siblion.salary_calculator.MonthInfo{" +
                "month=" + month +
                ", name='" + name + '\'' +
                ", firstHalfWorkingDays=" + firstHalfWorkingDays +
                ", secondHalfWorkingDays=" + secondHalfWorkingDays +
                ", workingDays=" + workingDays +
                '}';
    }
}
