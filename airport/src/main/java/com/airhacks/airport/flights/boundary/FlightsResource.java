
package com.airhacks.airport.flights.boundary;

import com.airhacks.airport.flights.entity.Flight;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

//!!!!!!!!!!!!! Exceptions
@Stateless
@Path("flights")
public class FlightsResource {

    //members are starting here
    @Inject
    FlightCoordinator coordinator;
    //end of members

    /**
     * Returns all flights
     *
     * @return
     */
    @GET
    public List<Flight> flights() {
        return this.coordinator.flights();
    }

    @GET
    @Path("{id}")
    public Flight find(@PathParam("id") long id) {
        return this.coordinator.find(id);
    }



    /**
     * Creates a flight
     *
     * @param flight
     */
    @POST
    public Response save(@Context UriInfo info, Flight flight) {
        this.coordinator.save(flight);
        URI uri = info.getAbsolutePathBuilder().
                path(String.valueOf(flight.getId())).
                build();
        return Response.created(uri).build();
    }


}
