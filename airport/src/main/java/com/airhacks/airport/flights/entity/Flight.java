
package com.airhacks.airport.flights.entity;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

/**
 *
 * @author airhacks.com
 */
public class Flight {

    public String number;
    public int numberOfSeats;

    @JsonbCreator
    public Flight(@JsonbProperty("number") String number, @JsonbProperty("numberOfSeats") int numberOfSeats) {
        this.number = number;
        this.numberOfSeats = numberOfSeats;
    }

}
