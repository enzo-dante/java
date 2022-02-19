package crownhounds.learnjava;

public class BarkingDog {

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {

        boolean isAwake = false;

        if(hourOfDay < 0 || hourOfDay > 23) {
            isAwake = false;
        } else if((barking && hourOfDay < 8) ||
                (barking && hourOfDay > 22)) {
            isAwake = true;
        }

        return isAwake;
    }
}
