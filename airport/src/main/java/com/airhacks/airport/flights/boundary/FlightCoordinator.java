
package com.airhacks.airport.flights.boundary;

import com.airhacks.airport.flights.entity.Flight;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author airhacks.com
 */
@Stateless
public class FlightCoordinator {

    public List<Flight> flights() {
        return Arrays.asList(new Flight("lh42", 42), new Flight("lh 21", 2));

    }

}
