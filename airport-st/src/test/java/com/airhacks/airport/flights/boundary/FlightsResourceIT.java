/*
 */
package com.airhacks.airport.flights.boundary;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import static javax.ws.rs.client.Entity.json;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
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
    public void crud() {
        JsonObject flight = Json.createObjectBuilder().
                add("numberOfSeats", 13).
                add("number", "air 13").
                build();
        Response response = this.tut.request().post(json(flight));
        Assert.assertThat(response.getStatus(), is(204));

        JsonArray flights = this.tut.request(MediaType.APPLICATION_JSON).
                get(JsonArray.class);
        System.out.println("flights = " + flights);
    }


}
