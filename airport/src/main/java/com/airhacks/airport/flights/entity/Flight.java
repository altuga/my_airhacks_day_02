
package com.airhacks.airport.flights.entity;

import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author airhacks.com
 */
@Entity
@NamedQuery(name = Flight.findAll, query = "SELECT f FROM Flight f")
public class Flight {

    @Id
    @GeneratedValue
    private long id;

    public String number;
    public int numberOfSeats;
    final static String PREFIX = "com.airhacks.airport.flights.entity.Flight.";
    public final static String findAll = PREFIX + "findAll";

    @JsonbCreator
    public Flight(@JsonbProperty("number") String number, @JsonbProperty("numberOfSeats") int numberOfSeats) {
        this.number = number;
        this.numberOfSeats = numberOfSeats;
    }

    /**
     * This is a parameterless constructor
     */
    public Flight() {
        super();
    }

    public long getId() {
        return id;
    }


}
