
package com.airhacks.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 *
 * @author airhacks.com
 */
@Path("/restclient/resources/ping")
public interface PingClient {

    @GET
    String ping();
}
