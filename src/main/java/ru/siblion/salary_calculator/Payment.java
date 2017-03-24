package ru.siblion.salary_calculator;

/**
 * Created by zhambyl on 24/03/2017.
 */
public class Payment {

    private final int day;
    private final int money;

    public Payment(int day, int money) {
        this.day = day;
        this.money = money;
    }

    public int getDay() {
        return day;
    }

    public int getMoney() {
        return money;
    }
}
