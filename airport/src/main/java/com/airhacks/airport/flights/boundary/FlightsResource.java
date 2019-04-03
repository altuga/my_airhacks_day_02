
package com.airhacks.airport.flights.boundary;

import com.airhacks.airport.flights.entity.Flight;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("flights")
public class FlightsResource {

    @Inject
    FlightCoordinator coordinator;

    @GET
    public List<Flight> flights() {
        return this.coordinator.flights();
    }

    @POST
    public void save(Flight flight) {
        this.coordinator.save(flight);
    }


}
