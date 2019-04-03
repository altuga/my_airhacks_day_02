package com.airhacks.ping.boundary;

import com.airhacks.ping.control.FlightsCatalog;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("ping")
public class PingResource {

    @Inject
    FlightsCatalog catalog;

    @GET
    public String ping() {
        return "Enjoy Java EE 8! " + this.catalog.allFlights();
    }

}
