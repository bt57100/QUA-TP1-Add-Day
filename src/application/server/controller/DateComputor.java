package application.server.controller;

import java.util.Arrays;

import application.server.model.MyDate;

/**
 * DateComputor class Use static methods to compute MyDate model
 *
 * @author Kevin
 */
public class DateComputor {

    /* Month with 30 or 31 days */
    private static final Integer[] THIRRTY_ONE_DAY_MONTH = {1, 3, 5, 7, 8, 10};
    private static final Integer[] THIRTY_DAY_MONTH = {4, 6, 9, 11};

    /**
     * Add one day to the given date
     *
     * @param date
     * @return the next day of the date
     */
    public static MyDate addOneDayToDate(MyDate date) {
        if (isValid(date)) {
            if ((date.getMonth() == 2 && !isBissextile(date.getYear()) && date.getDay() < 28)
                    || (date.getMonth() == 2 && isBissextile(date.getYear()) && date.getDay() < 29)
                    || (Arrays.asList(THIRTY_DAY_MONTH).contains(date.getMonth()) && date.getDay() < 30)
                    || (Arrays.asList(THIRRTY_ONE_DAY_MONTH).contains(date.getMonth()) && date.getDay() < 31)) {
                addOneDay(date);
            } else {
                addOneMonth(date);
            }
        }
        return date;
    }

    /**
     * Add one day to the date day
     *
     * @param date
     */
    private static void addOneDay(MyDate date) {
        date.setDay(date.getDay() + 1);
    }

    /**
     * Add one month to the date, reset the day to one and check whether it's a
     * new year
     *
     * @param date
     */
    private static void addOneMonth(MyDate date) {
        date.setDay(1);
        if (date.getMonth() < 12) {
            date.setMonth(date.getMonth() + 1);
        } else {
            date.setMonth(1);
            addOneYear(date);
        }
    }

    /**
     * Add one year to the date year
     *
     * @param date
     */
    private static void addOneYear(MyDate date) {
        date.setYear(date.getYear() + 1);
    }

    /**
     * Check whether the year is bissextile
     *
     * @param year
     * @return 1 if bissextile else 0
     */
    private static boolean isBissextile(int year) {
        return year % 4 == 0;
    }

    /**
     * Check whether the date can exist
     *
     * @param date
     * @return 1 if valid else 0
     */
    private static boolean isValid(MyDate date) {
        return isDayValid(date.getDay())
                && isMonthValid(date.getMonth(), date.getYear())
                && isYearValid(date.getDay(), date.getMonth(), date.getYear());
    }

    /**
     * Check whether the day is valid
     *
     * @param day
     * @return 1 if valid else 0
     */
    private static boolean isDayValid(int day) {
        return (day > 0 && day < 32);
    }

    /**
     * Check whether the day in the month is possible
     *
     * @param day
     * @param month
     * @return 1 if valid else 0
     */
    private static boolean isMonthValid(int day, int month) {
        boolean valid = true;
        if (Arrays.asList(THIRTY_DAY_MONTH).contains(month)) {
            if (day > 30) {
                valid = false;
            }
        } else if ((Arrays.asList(THIRRTY_ONE_DAY_MONTH).contains(month))) {
            if (day > 31) {
                valid = false;
            }
        }
        return valid;
    }

    /**
     * Check whether the day in the month in the year is possible
     *
     * @param day
     * @param month
     * @param year
     * @return 1 if valid else 0
     */
    private static boolean isYearValid(int day, int month, int year) {
        boolean valid = true;
        if (month == 2) {
            if (!isBissextile(year) && (day > 28)) {
                valid = false;
            } else if (isBissextile(year) && (day > 29)) {
                valid = false;
            }
        }
        return valid;
    }
}
