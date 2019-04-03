
package com.airhacks.ping.control;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.RegistryType;

/**
 *
 * @author airhacks.com
 */
public class FlightsCatalog {

    private Client client;
    private WebTarget tut;

    @Inject
    @RegistryType(type = MetricRegistry.Type.APPLICATION)
    MetricRegistry registry;

    @PostConstruct
    public void init() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/airport/resources/flights");
    }

    public JsonArray allFlights() {
        Response response = this.tut.request(MediaType.APPLICATION_JSON).get();
        int status = response.getStatus();
        registry.counter("flights_status_" + status).inc();
        return response.readEntity(JsonArray.class);
    }

}
