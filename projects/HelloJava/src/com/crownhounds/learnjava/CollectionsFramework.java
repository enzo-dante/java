package com.crownhounds.learnjava;

import java.util.ArrayList;
import java.util.List;

public class CollectionsFramework {

    // CONSTANT/static class variables assigned FINAL value on compile
    private static final String PLEASE_PAY = "Please pay";
    private static final String SEAT_TAKEN = "Sorry, seat is taken";

    public static void main(String[] args) {
        testTheatre(new Theatre("Olympian", 8, 12));
    }

    // ! STATIC FIELD: a unique class-level shared variable associated with class blueprint and NOT with any specific instances
    public static void testTheatre(Theatre theatre) {

        theatre.getSeats();

        if(theatre.reserveSeat("H11")) {
            System.out.println(PLEASE_PAY);
        } else {
            System.out.println(SEAT_TAKEN);
        }

        if(theatre.reserveSeat("H11")) {
            System.out.println(PLEASE_PAY);
        } else {
            System.out.println(SEAT_TAKEN);
        }
    }

}

// ! OOP COMPOSITION + INNER CLASS: logically grouped components within a parent object
// ! ACCESS-MODIFIER package private: only visible within the SCOPE of this package
class Theatre {

    // CONSTANTS/static class variables assigned FINAL value before instantiation
    private static final String NO_SEAT = "There is no seat ";
    // "%02d" = format the integer with 2 digits, left padding it with zeroes
    private static final String SEAT_NUMBER_FORMAT = "%02d";

    // ENCAPSULATION access-modifier private class fields assigned FINAL value on instantiation
    private final String theatreName;
    private List<Seat> seats;
    private char rowLetter = 'A';

    // OOP constructor that initializes the class fields on class/object instantiation
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        int lastRow = rowLetter + (numRows - 1);

        // default values
        this.seats = new ArrayList<Seat>();

        // instantiate seats per row objects for seats arrayList
        for(char row = rowLetter; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                String seatTitle = row + String.format(SEAT_NUMBER_FORMAT, seatNum);
                Seat seat = new Seat(seatTitle);
                seats.add(seat);
            }
        }
    }

    // non-static unique behavior/class methods
    public boolean reserveSeat(String seatNumber) {

        Seat requestedSeat = null;

        // for seat_instance in seats_arrayList
        for(Seat seat : seats) {
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

    // getter & setters
    public String getTheatreName() {
        return this.theatreName;
    }

    public List<Seat> getSeats() {
        for(Seat seat : this.seats) {
            System.out.println(seat.getSeatNumber());
        }

        return this.seats;
    }

    // ! OOP ENCAPSULATION + INNER CLASS + OOP COMPOSITION: logically grouped PRIVATE to this class scope component within a parent class
    private class Seat {

        // CONSTANTS/static class variables assigned FINAL value on instantiation
        private static final String RESERVED = " reserved";
        private static final String CANCELLED = " cancelled";
        private static final String SEAT = "Seat ";
        private static final String RESERVATION_OF_SEAT = "Reservation of seat ";

        // ENCAPSULATION access-modifier private class fields
        private final String seatNumber;
        private boolean reserved;

        // OOP constructor that initializes the class fields on class/object instantiation
        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
            this.reserved = false;
        }

        // non-static unique behavior/class methods
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

        // getters & setters
        public String getSeatNumber() {
            return seatNumber;
        }
    }
}