package crownhounds.learnjava;

public class PlayingCat {

    public static boolean isCatPlaying(boolean summer, int temperature) {

        boolean isPlaying = false;

        if(!summer &&
                ((temperature >= 25) && (temperature <= 35))) {
            isPlaying = true;
        } else if(summer &&
                ((temperature >= 25) && (temperature <= 45))) {
            isPlaying = true;
        }

        return isPlaying;
    }
}
