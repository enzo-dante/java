package crownhounds.learnjava;

public class LeapYearCalculator {

    public static boolean isLeapYear(int year) {

        boolean isYearLeaped = false;
        boolean isDivBy4 = year % 4 == 0;
        boolean isDivBy100 = year % 100 == 0;
        boolean isDivBy400 = year % 400 == 0;
        boolean isRange1To10000 = (year >= 1) && (year < 10000);

        if(isRange1To10000 && isDivBy4) {

            if(!isDivBy100) {
                isYearLeaped = true;

            } else if(isDivBy400) {
                isYearLeaped = true;
            }
        }

        return isYearLeaped;
    }
}
