
package com.airhacks.airport.flights.entity;

/**
 *
 * @author airhacks.com
 */
public class Flight {

    public String number;
    public int numberOfSeats;

    public Flight(String number, int numberOfSeats) {
        this.number = number;
        this.numberOfSeats = numberOfSeats;
    }

}
