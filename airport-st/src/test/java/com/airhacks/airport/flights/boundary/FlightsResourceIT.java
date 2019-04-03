/*
 */
package com.airhacks.airport.flights.boundary;

import javax.json.JsonArray;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class FlightsResourceIT {

    private Client client;
    private WebTarget tut;

    @Before
    public void init() {
        this.client = ClientBuilder.newClient();
        this.tut = this.client.target("http://localhost:8080/airport/resources/flights");
    }

    @Test
    public void flights() {
        JsonArray flights = this.tut.request(MediaType.APPLICATION_JSON).
                get(JsonArray.class);
        System.out.println("flights = " + flights);
    }


}
