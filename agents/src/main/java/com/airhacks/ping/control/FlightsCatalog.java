
package com.airhacks.ping.control;

import javax.annotation.PostConstruct;
import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author airhacks.com
 */
public class FlightsCatalog {

    private Client client;
    private WebTarget tut;

    @PostConstruct
    public void init() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/airport/resources/flights");
    }

    public JsonArray allFlights() {
        return this.tut.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
    }

}
