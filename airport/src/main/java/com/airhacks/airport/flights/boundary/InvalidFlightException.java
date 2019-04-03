
package com.airhacks.airport.flights.boundary;

import javax.ejb.ApplicationException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author airhacks.com
 */
@ApplicationException(rollback = true)
public class InvalidFlightException extends WebApplicationException {

    public InvalidFlightException(String message) {
        super(Response.status(400).header("info", message).build());
    }

}
