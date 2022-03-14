package crownhounds.learnjava;

public class FlourPacker {

    public static boolean canPack(int bigCount, int smallCount, int goal) {

        boolean hasFullBag = false;
        int convertedBigCount = bigCount * 5;
        int convertedBigRemainder = convertedBigCount % 5;

        if(bigCount < 0 || smallCount < 0 || goal < 0) {
            return false;
        }

        // bigCount doesn't apply
        if(goal < 5) {

            hasFullBag = smallCount >= goal;

            // evenly divBy5 convertedBigCount
        } else if(convertedBigCount % 5 == 0) {

            if(convertedBigCount > goal) {

                convertedBigCount = (goal / 5) * 5;

            }

            hasFullBag = convertedBigCount + smallCount >= goal;

        } else {

            // divBy5 convertedBigCount with remainder
            hasFullBag = (convertedBigCount - convertedBigRemainder) + smallCount >= goal;

        }

        return hasFullBag;
    }
}
