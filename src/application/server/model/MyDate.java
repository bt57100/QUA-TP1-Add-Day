package application.server.model;

public class MyDate {

    /* Fields */
    private int day;
    private int month;
    private int year;

    /**
     * Constructor with all fields
     *
     * @param day
     * @param month
     * @param year
     */
    public MyDate(int day, int month, int year) {
        super();
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /* Getter & Setter */
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Override to string to display to format YYYY-MM-DD
     *
     * @return
     */
    @Override
    public String toString() {
        return year + "-" + month + "-" + day;
    }
}
