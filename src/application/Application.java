package application;

import java.util.ArrayList;
import java.util.List;

import application.server.controller.DateComputor;
import application.server.model.MyDate;

public class Application {

	public static void main(String [] args) {
		List<MyDate> dateList = new ArrayList<>();
		dateList.add(new MyDate(1,1,2000));
		
		for(MyDate date : dateList) {
			System.out.println("Enter date :" + date.toString());
			DateComputor.addOneDayToDate(date);
			System.out.println("New date :" + date.toString());
			System.out.println();
		}
	}
}
