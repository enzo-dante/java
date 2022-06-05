package com.crownhounds.learnjava;

import java.util.*;

public class CollectionsFramework {

    // CONSTANT/static class variables assigned FINAL value on compile
    private static final String PLEASE_PAY = "Please pay";
    private static final String SEAT_TAKEN = "Sorry, seat is taken";
    private static final String TEST_SEAT = "H11";
    private static final String TEST_SEAT_2 = "A00";
    private static final String TEST_SEAT_3 = "B00";
    private static final String SEAT_FORMAT = " - $";
    public static final String PRINT_SHUFFLE_COPY = "\tPrinting shuffle seatsCopy\n";
    public static final String PRINT_REVERSE_COPY = "\tPrinting reverse seatsCopy\n";
    public static final String PRINT_COMPARATOR_PRICE_ORDER = "\tPrinting anonymous inner class COMPARATOR PRICE ORDER priceSeats\n";
    public static final String MIN = "min: ";
    public static final String MAX = "max: ";

    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympian", 8, 12);
        // shallow copy: copy all element references of an arrayList into a new list passed into the constructor
        // ! GENERICS CLASS: enforce specific parameter dataType for elements in dataStructure to improve ENCAPSULATION
        List<Theatre.Seat> seatsShallowCopy = new ArrayList<Theatre.Seat>(theatre.getSeats());

        // ? COLLECTION BINARY SEARCH(): recursive rapid partitioning of an already sorted list into halves to compareTo & find match
        // reserveSeat() uses Collections binary search
        testTheatre(theatre);

        // ? COLLECTIONS REVERSE(): return list in reverse order
        Collections.reverse(seatsShallowCopy);

        printSeats(seatsShallowCopy, PRINT_REVERSE_COPY);

        // ? COLLECTIONS SHUFFLE(): return list in random order
        Collections.shuffle(seatsShallowCopy);

        printSeats(seatsShallowCopy, PRINT_SHUFFLE_COPY);

        // ? COLLECTIONS MIN/MAX(): return lowest/highest element value in list in natural order
        System.out.println(MIN + Collections.min(seatsShallowCopy).getSeatNumber());
        System.out.println(MAX + Collections.max(seatsShallowCopy).getSeatNumber());

        Util.printSeparator();

        // ? COLLECTIONS COMPARATOR + ANONYMOUS INNER CLASS: @Override one-time execution of uniquely implemented anonymous class compare() from Comparator INTERFACE w/ GENERIC CLASS ENCAPSULATION
        // order list by seat price via Comparator interface PRICE_ORDER
        List<Theatre.Seat> priceSeats = new ArrayList<Theatre.Seat>(theatre.getSeats());
        priceSeats.add(theatre.new Seat(TEST_SEAT_2, 13D));
        priceSeats.add(theatre.new Seat(TEST_SEAT_3, 13D));

        Collections.sort(priceSeats, Theatre.PRICE_ORDER);
        printSeats(priceSeats, PRINT_COMPARATOR_PRICE_ORDER);
    }

    // ! STATIC FIELD: a unique class-level shared variable associated with class blueprint and NOT with any specific instances
    public static void testTheatre(Theatre theatre) {

        System.out.println(theatre.getTheatreName().toUpperCase());

        if(theatre.reserveSeat(TEST_SEAT)) {
            System.out.println(PLEASE_PAY);
        } else {
            System.out.println(SEAT_TAKEN);
        }

        if(theatre.reserveSeat(TEST_SEAT)) {
            System.out.println(PLEASE_PAY);
        } else {
            System.out.println(SEAT_TAKEN);
        }

        Util.printSeparator();
    }

    // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take specific dataType parameter
    public static void printSeats(List<Theatre.Seat> seats, String listType) {

        System.out.println(listType);

        // for DataType instance in list
        for(Theatre.Seat seat : seats) {
            System.out.println(seat.getSeatNumber() + SEAT_FORMAT + seat.getPrice());
        }

        Util.printSeparator();
    }
}

// ! OOP COMPOSITION + INNER CLASS: logically grouped components within a parent object
// ! ACCESS-MODIFIER package private: only visible within the SCOPE of this package
class Theatre {

    // CONSTANTS/static class variables assigned FINAL value before instantiation
    private static final String NO_SEAT = "There is no seat ";

    // * "%02d" = format the integer with 2 digits, left padding it with zeroes
    private static final String SEAT_NUMBER_FORMAT = "%02d";

    // ? COLLECTIONS COMPARATOR + ANONYMOUS INNER CLASS: @Override one-time execution of uniquely implemented compare() from Comparator INTERFACE w/ GENERIC CLASS ENCAPSULATION
    // ? STATIC INITIALIZATION BLOCKS: one-time on-initialization execution of 'static {}' and their assigned STATIC FINAL variables
    static final Comparator<Seat> PRICE_ORDER;

    static {
        // ! COMPARATOR ISSUE: same price seats are not equal objects, would need to validate letter designation as well
        PRICE_ORDER = new Comparator<Seat>() {
            @Override
            public int compare(Seat seat1, Seat seat2) {
                if(seat1.getPrice() < seat2.getPrice()) {
                    // less than
                    return -1;
                } else if(seat1.getPrice() > seat2.getPrice()) {
                    // greater than
                    return 1;
                } else {
                    // equal
                    return 0;
                }
            };
        };
    }

    // ENCAPSULATION access-modifier private class fields assigned FINAL value on instantiation
    private final String theatreName;

    // ! GENERICS: improve OOP ENCAPSULATION by creating classes, interfaces, & methods that only take specific dataType parameter
    private List<Seat> seats;

    // ? using Collection = super generic data structure that enables any class that implements one of the interfaces that extend Collection
//    private Collection<Seat> seats;

    private char rowLetter = 'A';
    private char rowD = 'D';
    private char rowF = 'F';

    // OOP constructor that initializes the class fields on class/object instantiation
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = rowLetter + (numRows - 1);

        // default values
        // ! COLLECTION + GENERIC CLASSES: when using Type parameter, extend Type parameter with bounded restriction to validate only usage of specific dataType via '<T extends dataType>'
        this.seats = new ArrayList<>();

        // instantiate seats per row objects for seats arrayList
        // ! TIME COMPLEXITY: nested loops have a O(n^2) quadratic time complexity
        for(char row = rowLetter; row <= lastRow; row++) {

            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12D;
                boolean isEdgeSeat = ((seatNum < 4) || (seatNum > 9));

                if((row < rowD) && !isEdgeSeat) {
                    // premium: markup price for first 3 rows (excluding 3 edge seats)
                    price = 14D;
                } else if((row > rowF) || isEdgeSeat) {
                    // discount: mark down price for back rows & row edge seats
                    price = 7D;
                }
                String seatTitle = row + String.format(SEAT_NUMBER_FORMAT, seatNum);
                Seat seat = new Seat(seatTitle, price);
                seats.add(seat);
            }
        }
    }

    // non-static unique behavior/class methods
    // ! OVERLOADED METHOD: use same name for multiple methods, but unique parameters for codebase readability & scalability
    public boolean reserveSeat(String seatNumber, boolean isBruteForce) {

        // * BRUTE FORCE: w/o COLLECTIONS BINARY SEARCH, use for loop to check every record

        Seat requestedSeat = null;

        // for seat_instance in seats_arrayList
        for(Seat seat : seats) {

            System.out.print("."); // track numCheck to find relevant seat

            if(seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }

        if(requestedSeat == null) {
            System.out.println(NO_SEAT + seatNumber);
            return false;
        }

        return requestedSeat.reserve();
    }

    public boolean reserveSeat(String seatNumber) {

        Seat requestedSeat = new Seat(seatNumber, 12D);

        // ? INTERFACE + COLLECTION BINARY SEARCH: recursive rapid partitioning of an already sorted list into halves to compareTo & find match
        // comparator null = natural order
        int foundSeat = Collections.binarySearch(this.seats, requestedSeat, null);

        if(foundSeat >= 0) {
            return this.seats.get(foundSeat).reserve();
        } else {
            System.out.println(NO_SEAT + seatNumber);
            return false;
        }
    }

    // OOP ENCAPSULATION getter & setters
    public List<Seat> getSeats() {
        return this.seats;
    }

    public String getTheatreName() {
        return theatreName;
    }

    // ! OOP ENCAPSULATION + INNER CLASS + OOP COMPOSITION: logically grouped PRIVATE to this class scope component within a parent class
    // ! INTERFACE + GENERIC CLASS: must uniquely implement all publicly-shared signatures & restrict allowed dataType
    class Seat implements Comparable<Seat>{

        // CONSTANTS/static class variables assigned FINAL value on instantiation
        private static final String RESERVED = " reserved";
        private static final String CANCELLED = " cancelled";
        private static final String SEAT = "Seat ";
        private static final String RESERVATION_OF_SEAT = "Reservation of seat ";

        // ENCAPSULATION access-modifier private class fields
        private Double price;
        private boolean reserved;
        private final String seatNumber;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Seat(String seatNumber, double price) {
            this.seatNumber = seatNumber;
            this.reserved = false;

            // ! AUTOBOXING: convert primitive dataType -> Wrapper Class dataType w/ greater functionality
            this.price = price;
        }

        // non-static unique behavior/class methods
        // ! INTERFACE + OOP POLYMORPHISM: must uniquely implement all publicly-shared signatures via @Override
        @Override
        public int compareTo(Seat seat) {
            /*
                ? INTERFACE + COLLECTION BINARY SEARCH: recursive rapid partitioning of an already sorted list into halves to compareTo & find match

                n < 0 = less than
                n = 0 = equal to
                n > 0 = greater than
             */
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println(SEAT + this.seatNumber + RESERVED);
                return true;
            }

            return false;
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println(RESERVATION_OF_SEAT + this.seatNumber + CANCELLED);
                return false;
            }

            return true;
        }

        // OOP ENCAPSULATION getters & setters
        public String getSeatNumber() {
            return seatNumber;
        }

        public Double getPrice() {
            return price;
        }
    }
}