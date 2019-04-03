
package com.airhacks.airport.flights.boundary;

import com.airhacks.airport.flights.entity.Flight;
import java.util.List;
import javax.ejb.Stateless;
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
    
    public List<Flight> flights() {
        return this.em.createNamedQuery(Flight.findAll, Flight.class).getResultList();

    }

    public void save(Flight flight) {
        this.em.persist(flight);
    }


}
