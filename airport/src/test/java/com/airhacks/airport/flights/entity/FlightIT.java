/*
 */
package com.airhacks.airport.flights.entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class FlightIT {

    private EntityManager em;
    private EntityTransaction tx;

    @Before
    public void initEM() {
        this.em = Persistence.createEntityManagerFactory("it").createEntityManager();
        this.tx = this.em.getTransaction();
    }

    @Test
    public void crud() {
        Flight flight = new Flight("new flight", 2);
        this.tx.begin();
        this.em.persist(flight);
        this.tx.commit();

        List<Flight> flights = this.em.createNamedQuery(Flight.findAll, Flight.class).
                getResultList();
        assertFalse(flights.isEmpty());
    }

}
