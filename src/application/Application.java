package application;

import java.util.ArrayList;
import java.util.List;

import application.server.controller.DateComputor;
import application.server.model.MyDate;

/**
 * Main Application
 *
 * @author Kevin
 */
public class Application {

    /**
     * Launch the application
     *
     * @param args
     */
    public static void main(String[] args) {
        List<MyDate> dateList = new ArrayList<>();
        dateList.add(new MyDate(1, 1, 2000));

        dateList.stream().map((date) -> {
            System.out.println("Enter date :" + date.toString());
            return date;
        }).map((date) -> {
            DateComputor.addOneDayToDate(date);
            return date;
        }).map((date) -> {
            System.out.println("New date :" + date.toString());
            return date;
        }).forEachOrdered((_item) -> {
            System.out.println();
        });
    }
}
