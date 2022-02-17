package crownhounds.learnjava;

public class MegaBytesConverter {

    public static void printMegaBytesAndKiloBytes(int kiloBytes) {
        double kiloToMegaRatio = 1024D; // 1024 KB = 1 MB
        long megaBytes = (long) Math.floor(kiloBytes / kiloToMegaRatio); // how many times does 1 megaByte (1024 kiloBytes) go into x kiloBytes
        long remainder = Math.round(kiloBytes % kiloToMegaRatio);

        if(kiloBytes < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kiloBytes + " KB = " + megaBytes + " MB and " +  remainder + " KB");
        }
    }
}
