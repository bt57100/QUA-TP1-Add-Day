package application.server.controller;

import java.util.Arrays;

import application.server.model.MyDate;

public class DateComputor {
	private static Integer[] ThirtyOneDayMonth = {1, 3, 5, 7, 8, 10};
	private static Integer[] ThirtyDayMonth = {4, 6, 9, 11};

	public static MyDate addOneDayToDate(MyDate date) {
		if(isValid(date)) {
			if(date.getDay()<28) {
				addOneDayToDay(date);
			} else if (date.getDay() == 28) {
				if(date.getMonth() == 2 && !isBissextile(date.getYear())) {
					newMonth(date);
				} else {
					addOneDayToDay(date);
				}
			} else if (date.getDay() == 29) {
				if(date.getMonth() == 2) {
					newMonth(date);
				} else {
					addOneDayToDay(date);
				}
			} else if (date.getDay() == 30) {
				if(Arrays.asList(ThirtyDayMonth).contains(date.getMonth())) {
					newMonth(date);
				} else {
					addOneDayToDay(date);
				}
			} else {
				newMonth(date);
			}
		}
		return date;
	}

	private static void addOneDayToDay(MyDate date) {
		date.setDay(date.getDay() + 1);
	}

	private static void newMonth(MyDate date) {
		date.setDay(1);
		if(date.getMonth() < 12) {
			date.setMonth(date.getMonth() + 1);
		} else {
			newYear(date);
		}
	}

	private static void newYear(MyDate date) {
		date.setMonth(1);
		date.setYear(date.getYear() + 1);
	}

	private static boolean isBissextile(int year) {
		return year%4 == 0;
	}

	private static boolean isValid(MyDate date) {
		boolean valid = true;
		if(date.getDay() < 1) {
			valid = false;
		}
		if(Arrays.asList(ThirtyDayMonth).contains(date.getMonth())) {
			if(date.getDay() > 30) {
				valid = false;
			}
		} else if ((Arrays.asList(ThirtyOneDayMonth).contains(date.getMonth()))) {
			if(date.getDay() > 31) {
				valid = false;
			}
		}
		if(date.getMonth()==2) {
			if(!isBissextile(date.getYear()) && (date.getDay()>28)) {
				valid = false;
			} else if (isBissextile(date.getYear()) && (date.getDay()>29)) {
				valid = false;
			}
		}
		return valid;
	}
}
