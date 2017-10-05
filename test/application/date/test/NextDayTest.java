package application.date.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import application.server.controller.DateComputor;
import application.server.model.MyDate;

public class NextDayTest {
	private MyDate start;
	private MyDate end;

	@Before
	public void setUp() throws Exception {
		start = new MyDate(31,12,2000);
		end = new MyDate(1,1,2001);
	}

	@Test
	public void test() {
		DateComputor.addOneDayToDate(start);
		System.out.println(start.toString() + "\t->\t" + end.toString());
		assertTrue("NOK for " + start.toString(), start.toString().equals(end.toString()));
	}
	
	
}
