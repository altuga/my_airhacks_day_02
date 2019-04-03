
package com.airhacks.airport.flights.boundary;

import com.airhacks.airport.flights.entity.Flight;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author airhacks.com
 */
@ApplicationScoped
public class FlightCoordinator {

    private ArrayList<Flight> list;

    @PostConstruct
    public void init() {
        this.list = new ArrayList<>();
        this.list.add(new Flight("lh42", 42));

        this.list.add(new Flight("lh 21", 2));
        this.list.add(new Flight("lh 13", 13));
    }

    public List<Flight> flights() {
        return this.list;

    }

    public void save(Flight flight) {
        this.list.add(flight);
    }


}
