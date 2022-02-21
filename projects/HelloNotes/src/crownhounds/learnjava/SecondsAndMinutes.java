package crownhounds.learnjava;

public class SecondsAndMinutes {

    /* a constant value that
            cannot be changed due to the 'final' keyword
            cannot be accessed outside of this class scope due to the 'private' keyword
     */
    private static final String INVALID_VALUE_MESSAGE = "Invalid value";

    public static String getDurationString(int minutes, int seconds) {

        int TOTAL_SECONDS = (minutes * 60) + seconds;

        String durationString = new String("XXh YYm ZZs");
        String formattedHours = "";
        String formattedMinutes = "";
        String formattedSeconds = "";

        int totalHours = 0;
        int totalMinutes = 0;

        if(minutes < 0 || (seconds < 0 || seconds > 59)) {
            return INVALID_VALUE_MESSAGE;
        }

        totalHours = TOTAL_SECONDS / 3600;
        totalMinutes = (TOTAL_SECONDS / 60) % 60;

//        System.out.println("TOTAL_SECONDS: " + TOTAL_SECONDS);
//        System.out.println("totalHours: " + totalHours);
//        System.out.println("totalMinutes: " + totalMinutes);

        // single-digit format: 01h 01m 01s
        formattedHours = totalHours < 10 ?
                "0" + Integer.toString(totalHours) : Integer.toString(totalHours);
        formattedMinutes = totalMinutes < 10 ?
                "0" + Integer.toString(totalMinutes) : Integer.toString(totalMinutes);
        formattedSeconds = seconds < 10 ?
                "0" + Integer.toString(seconds) : Integer.toString(seconds);

        durationString = durationString.replace("XX", formattedHours)
                .replace("YY", formattedMinutes)
                .replace("ZZ", formattedSeconds);

        return durationString;
    }

    public static String getDurationString(int seconds) {

        int totalMinutes = 0;
        int remainingSeconds = 0;

        if(seconds < 0) {
            return INVALID_VALUE_MESSAGE;
        }

        totalMinutes = seconds / 60;
        remainingSeconds = seconds % 60;

        return getDurationString(totalMinutes, remainingSeconds);
    }
}
