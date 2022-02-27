package crownhounds.learnjava;

public class NumberOfDaysInMonth {

    public static boolean isLeapYear(int year) {

        if(year < 1 || year > 9999) {
            return false;
        }

        boolean isLeap = false;

        if(year % 4 == 0 &&
                year % 100 == 0 &&
                year % 400 == 0) {
            isLeap = true;
        } else if(year % 4 == 0 && year % 100 != 0) {
            isLeap = true;
        }

        return isLeap;
    }

    public static int getDaysInMonth(int month, int year) {

        if((month < 1 || month > 12) ||
                (year < 1 || year > 9999)) {
            return -1;
        }

        int numMonthDays = 0;

        switch(month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                numMonthDays = 31;
                break;
            case 4: case 6: case 9: case 11:
                numMonthDays = 30;
                break;
            case 2:
                numMonthDays = isLeapYear(year) ? 29 : 28;
                break;
            default:
                numMonthDays = -1;
                break;
        }

        return numMonthDays;
    }
}
