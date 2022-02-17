package crownhounds.learnjava;

public class SpeedConverter {

    // changed from public to private for security
    private static long toMilesPerHour(double kilometersPerHour) {

        long result = 0L;
        double kilometerToMileRatio = 1.609D;

        if(kilometersPerHour >= 0) {
            result = Math.round(kilometersPerHour / kilometerToMileRatio);
        } else if(kilometersPerHour < 0) {
            result = -1L;
        }

        return result;
    }

    public static void printConversion(double kilometersPerHour) {

        long mph = toMilesPerHour(kilometersPerHour);

        if(kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " km/h = " + mph + " mi/h");
        }
    }
}
