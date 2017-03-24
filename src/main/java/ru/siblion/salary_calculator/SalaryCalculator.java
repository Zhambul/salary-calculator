package ru.siblion.salary_calculator;

import javafx.util.Pair;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.*;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

/**
 * Created by zhambyl on 23/03/2017.
 */
public class SalaryCalculator {

    public YearReport calculateForYear(double salary) {
        return calc(getMonthsInfo(), salary);
    }

    public MonthReport calculateForMonth(double salary, int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("illegal month " + month);
        }
        YearReport yearReport = calc(getMonthsInfo(), salary);
        return yearReport.getMonths()
                .stream()
                .filter(monthReport -> monthReport.getInfo().getMonth() == month)
                .findFirst()
                .get();
    }

    private List<MonthInfo> getMonthsInfo() {
        Year year = Year.of(2017);
        List<MonthInfo> result = new ArrayList<>();
        Set<Pair<Integer, Integer>> holidays = getHolidays();
        for (int i = 1; i <= 12; i++) {
            YearMonth yearMonth = year.atMonth(i);
            int daysInMonths = yearMonth.getMonth().maxLength();
            List<LocalDate> workingDaysInMonths = new ArrayList<>();
            for (int k = 1; k <= daysInMonths; k++) {
                if (!yearMonth.isValidDay(k)) {
                    continue;
                }
                LocalDate day = yearMonth.atDay(k);
                DayOfWeek dayOfWeek = day.getDayOfWeek();
                if (dayOfWeek == SATURDAY || dayOfWeek == SUNDAY) {
                    continue;
                }
                Pair<Integer, Integer> monthAndDay = new Pair<>(day.getMonth().getValue(), day.getDayOfMonth());
                if (holidays.contains(monthAndDay)) {
                    continue;
                }
                workingDaysInMonths.add(day);
            }

            int firstHalfWorkingDays = 0;
            int secondHalfWorkingDays = 0;

            for (LocalDate day : workingDaysInMonths) {
                if (day.getDayOfMonth() <= 15) {
                    firstHalfWorkingDays++;
                } else {
                    secondHalfWorkingDays++;
                }
            }
            MonthInfo monthInfo = new MonthInfo(i, firstHalfWorkingDays, secondHalfWorkingDays);
            result.add(monthInfo);
        }
        return result;
    }

    private Set<Pair<Integer, Integer>> getHolidays() {
        Set<Pair<Integer, Integer>> holidays = new HashSet<>();
        holidays.add(new Pair<>(1, 1));
        holidays.add(new Pair<>(1, 2));
        holidays.add(new Pair<>(1, 3));
        holidays.add(new Pair<>(1, 4));
        holidays.add(new Pair<>(1, 5));
        holidays.add(new Pair<>(1, 6));
        holidays.add(new Pair<>(1, 7));
        holidays.add(new Pair<>(1, 8));
        holidays.add(new Pair<>(2, 23));
        holidays.add(new Pair<>(2, 24));
        holidays.add(new Pair<>(3, 8));
        holidays.add(new Pair<>(5, 1));
        holidays.add(new Pair<>(5, 8));
        holidays.add(new Pair<>(5, 9));
        holidays.add(new Pair<>(6, 12));
        holidays.add(new Pair<>(11, 4));
        holidays.add(new Pair<>(11, 6));
        return holidays;
    }

    private YearReport calc(List<MonthInfo> monthsInfo, double salary) {
        if (monthsInfo.size() != 12) {
            throw new IllegalArgumentException("not 12 months");
        }

        YearReport yearReport = new YearReport(salary);

        for (int i = 1; i < monthsInfo.size(); i++) {
            MonthInfo prevMonth = monthsInfo.get(i - 1);
            MonthInfo thisMonth = monthsInfo.get(i);

            double prevMonthRestSalary;
            double salaryInAdvance;

            double prevMonthRestKoef = (double) prevMonth.getSecondHalfWorkingDays() / prevMonth.getWorkingDays();
            prevMonthRestSalary = prevMonthRestKoef * salary;

            double thisMonthInAdvanceKoef = (double) thisMonth.getFirstHalfWorkingDays() / thisMonth.getWorkingDays();
            salaryInAdvance = thisMonthInAdvanceKoef * salary;

            MonthReport monthReport = new MonthReport(prevMonthRestSalary, salaryInAdvance, thisMonth);
            yearReport.addMonthReport(monthReport);
        }

        return yearReport;
    }
}
