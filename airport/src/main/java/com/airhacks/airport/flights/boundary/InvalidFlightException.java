
package com.airhacks.airport.flights.boundary;

/**
 *
 * @author airhacks.com
 */
public class InvalidFlightException extends RuntimeException {

    public InvalidFlightException(String message) {
        super(message);
    }

}
