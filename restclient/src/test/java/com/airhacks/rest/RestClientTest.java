/*
 */
package com.airhacks.rest;

import java.net.MalformedURLException;
import java.net.URI;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author airhacks.com
 */
public class RestClientTest {

    @Test
    public void init() throws MalformedURLException {
        URI baseURI = URI.create("http://localhost:8080");
        PingClient client = RestClientBuilder.newBuilder().
                baseUri(baseURI).
                build(PingClient.class);
        assertNotNull(client);

        String result = client.ping();
        assertNotNull(result);
        System.out.println("result = " + result);

    }

}
