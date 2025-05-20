package com.hms.roomservice.endpoint;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.*;

@Path("/rooms")
public class RoomResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRooms(@Context HttpHeaders headers) {
        List<String> rooms = Arrays.asList("Room 101", "Room 102", "Room 201");
        return Response.ok(rooms).build();
    }
}
