package crownhounds.learnjava;

public class MinutesToYearsDaysCalculator {

    private static final String INVALID_MESSAGE = "Invalid Value";

    public static void printYearsAndDays(long minutes) {

        String formattedMessage = "XX min = YY y and ZZ d";
        long totalHours = minutes / 60L;
        long totalDays = totalHours / 24L;
        long totalYears = totalDays / 365L;
        long remainingDays = totalDays % 365L;

//        System.out.println(minutes);
//        System.out.println(totalHours);
//        System.out.println("totalDays: " + totalDays);
//        System.out.println("remainingDays: " + remainingDays);
//        System.out.println(totalYears);

        if(minutes < 0) {
            System.out.println(INVALID_MESSAGE);
        } else {
            formattedMessage = formattedMessage.replace("XX", Long.toString(minutes))
                    .replace("YY", Long.toString(totalYears))
                    .replace("ZZ", Long.toString(remainingDays));

            System.out.println(formattedMessage);
        }
    }
}
