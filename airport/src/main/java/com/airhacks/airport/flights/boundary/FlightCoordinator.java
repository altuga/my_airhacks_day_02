
package com.airhacks.airport.flights.boundary;

import com.airhacks.airport.flights.entity.Flight;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class FlightCoordinator {

    @PersistenceContext
    EntityManager em;

    @Inject
    Event<Flight> events;
    
    public List<Flight> flights() {
        return this.em.createNamedQuery(Flight.findAll, Flight.class).getResultList();

    }

    public void save(Flight flight) {
        if (flight != null && flight.number != null && !flight.number.startsWith("lh")) {
            throw new InvalidFlightException("Only LH are accepted");
        }
        this.em.persist(flight);
        this.events.fire(flight);
    }

    public Flight find(long id) {
        return this.em.find(Flight.class, id);
    }

}
