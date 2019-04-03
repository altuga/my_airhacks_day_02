
package com.airhacks.airport.flights.control;

import com.airhacks.airport.flights.entity.Flight;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.RegistryType;

/**
 *
 * @author airhacks.com
 */
@ApplicationScoped
public class FlightListener {

    @Inject
    @RegistryType(type = MetricRegistry.Type.APPLICATION)
    MetricRegistry registry;

    public void onCreatedFlight(@Observes(during = TransactionPhase.AFTER_SUCCESS) Flight flight) {
        registry.counter("flights_successfully_created").inc();
    }
    public void onFailedCreation(@Observes(during = TransactionPhase.AFTER_FAILURE) Flight flight) {
        registry.counter("flights_unsuccessfully_created").inc();
    }

}
