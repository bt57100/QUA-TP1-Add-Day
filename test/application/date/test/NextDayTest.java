package application.date.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import application.server.controller.DateComputor;
import application.server.model.MyDate;

public class NextDayTest {

    private MyDate falseDay;
    private MyDate falseMonth;
    private MyDate falseYear;
    private MyDate endDec;
    private MyDate strJan;
    private MyDate sndJan;
    private MyDate endMar;
    private MyDate strAvr;
    private MyDate sndAvr;
    private MyDate endAvr;
    private MyDate strMai;
    private MyDate strBisFev;
    private MyDate strNoBisFev;
    private MyDate sndBisFev;
    private MyDate sndNoBisFev;
    private MyDate endBisFev;
    private MyDate endNoBisFev;
    private MyDate strBisMar;
    private MyDate strNoBisMar;

    @Before
    public void setUp() throws Exception {
    	falseDay = new MyDate(0, 1, 2000);
    	falseMonth = new MyDate(1, 0, 2000);
    	falseYear = new MyDate(29, 2, 1999);
        endDec = new MyDate(31, 12, 2000);
        strJan = new MyDate(1, 1, 2001);
        sndJan = new MyDate(2, 1, 2001);
        endMar = new MyDate(31, 3, 2000);
        strAvr = new MyDate(1, 4, 2000);
        sndAvr = new MyDate(2, 4, 2000);
        endAvr = new MyDate(30, 4, 2000);
        strMai = new MyDate(1, 5, 2000);
        strBisFev = new MyDate(1, 2, 2000);
        strNoBisFev = new MyDate(1, 2, 1999);
        sndBisFev = new MyDate(2, 2, 2000);
        sndNoBisFev = new MyDate(2, 2, 1999);
        endBisFev = new MyDate(29, 2, 2000);
        endNoBisFev = new MyDate(28, 2, 1999);
        strBisMar = new MyDate(1, 3, 2000);
        strNoBisMar = new MyDate(1, 3, 1999);
    }
    
    @Test
    public void addOneDayToDateTest() {
        assertTrue("NOK addOneDayToDate for " + falseDay.toString(), DateComputor.addOneDayToDate(falseDay).toString().equals(falseDay.toString()));
        assertTrue("NOK addOneDayToDate for " + falseMonth.toString(), DateComputor.addOneDayToDate(falseMonth).toString().equals(falseMonth.toString()));
        assertTrue("NOK addOneDayToDate for " + falseYear.toString(), DateComputor.addOneDayToDate(falseYear).toString().equals(falseYear.toString()));
        assertTrue("NOK addOneDayToDate for " + endDec.toString(), DateComputor.addOneDayToDate(endDec).toString().equals(strJan.toString()));
        assertTrue("NOK addOneDayToDate for " + strJan.toString(), DateComputor.addOneDayToDate(strJan).toString().equals(sndJan.toString()));
        assertTrue("NOK addOneDayToDate for " + endMar.toString(), DateComputor.addOneDayToDate(endMar).toString().equals(strAvr.toString()));
        assertTrue("NOK addOneDayToDate for " + strAvr.toString(), DateComputor.addOneDayToDate(strAvr).toString().equals(sndAvr.toString()));
        assertTrue("NOK addOneDayToDate for " + endAvr.toString(), DateComputor.addOneDayToDate(endAvr).toString().equals(strMai.toString()));

        assertTrue("NOK addOneDayToDate for " + endBisFev.toString(), DateComputor.addOneDayToDate(endBisFev).toString().equals(strBisMar.toString()));
        assertTrue("NOK addOneDayToDate for " + endNoBisFev.toString(), DateComputor.addOneDayToDate(endNoBisFev).toString().equals(strNoBisMar.toString()));
        assertTrue("NOK addOneDayToDate for " + strBisFev.toString(), DateComputor.addOneDayToDate(strBisFev).toString().equals(sndBisFev.toString()));
        assertTrue("NOK addOneDayToDate for " + strNoBisFev.toString(), DateComputor.addOneDayToDate(sndNoBisFev).toString().equals(sndNoBisFev.toString()));
    }

    @Test
    public void addOneMonthTest() {
    	MyDate endJan = new MyDate(31, 1, 2000); 
    	MyDate strFeb = new MyDate(1, 2, 2000); 
    	MyDate endDec = new MyDate(31, 12, 2000);
    	MyDate strJan = new MyDate(1, 1, 2001); 
    	
    	assertTrue("NOK addOneMonth for 0", DateComputor.addOneMonth(endJan).toString().equals(strFeb.toString()));
    	assertTrue("NOK addOneMonth for 0", DateComputor.addOneMonth(endDec).toString().equals(strJan.toString()));
    }
    
    @Test
    public void isBissextileTest() {
        assertFalse("NOK isBissextile for 1", DateComputor.isBissextile(1));
        assertFalse("NOK isBissextile for 2", DateComputor.isBissextile(2));
        assertFalse("NOK isBissextile for 3", DateComputor.isBissextile(3));
        assertTrue("NOK isBissextile for 0", DateComputor.isBissextile(0));
        assertTrue("NOK isBissextile for 4", DateComputor.isBissextile(4));
    }

    @Test
    public void isDayValidTest() {
    	assertFalse("NOK isDayValid for 0", DateComputor.isDayValid(0));
    	assertFalse("NOK isDayValid for 32", DateComputor.isDayValid(32));
        assertTrue("NOK isDayValid for 1", DateComputor.isDayValid(1));
    }
    @Test
    public void isMonthValidTest() {
    	assertFalse("NOK isMonthValid for day=0 and month=0", DateComputor.isMonthValid(1, 0));
    	assertFalse("NOK isMonthValid for day=0 and month=0", DateComputor.isMonthValid(1, 13));
    	assertFalse("NOK isMonthValid for day=30 and month=2", DateComputor.isMonthValid(30, 2));
    	assertFalse("NOK isMonthValid for day=31 and month=4", DateComputor.isMonthValid(31, 4));
    	assertFalse("NOK isMonthValid for day=32 and month=1", DateComputor.isMonthValid(32, 1));
    	assertTrue("NOK isMonthValid for day=1 and month=1", DateComputor.isMonthValid(1, 1));
    	assertTrue("NOK isMonthValid for day=1 and month=4", DateComputor.isMonthValid(1, 4));
    	assertTrue("NOK isMonthValid for day=1 and month=2", DateComputor.isMonthValid(1, 2));
    }
    
    @Test
    public void isYearValidTest() {
    	assertFalse("NOK isMonthValid for day=29, month=2 and year=1999", DateComputor.isYearValid(29, 2, 1999));
    	assertFalse("NOK isMonthValid for day=30, month=2 and year=1999", DateComputor.isYearValid(30, 2, 1999));
    	assertFalse("NOK isMonthValid for day=30, month=2 and year=2000", DateComputor.isYearValid(30, 2, 2000));
    	assertTrue("NOK isMonthValid for day=28, month=2 and year=2000", DateComputor.isYearValid(28, 2, 2000));
    	assertTrue("NOK isMonthValid for day=28, month=2 and year=1999", DateComputor.isYearValid(28, 2, 1999));
    	assertTrue("NOK isMonthValid for day=29, month=2 and year=2000", DateComputor.isYearValid(29, 2, 2000));
    	assertTrue("NOK isMonthValid for day=29, month=2 and year=2000", DateComputor.isYearValid(29, 2, 2000));
    	assertTrue("NOK isMonthValid for day=29, month=1 and year=2000", DateComputor.isYearValid(29, 1, 2000));
    }

}
