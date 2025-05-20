package com.hms.bookingservice.endpoint;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.*;

@Path("/booking")
public class BookingResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookRoom(Map<String, String> data) {
        String room = data.get("room");
        String user = data.get("user");

        // KubeMQ call removed for Lab 4-only build
        return Response.ok("Booked " + room + " for " + user).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookings() {
        List<String> bookings = Arrays.asList("Room 101 - John", "Room 102 - Sarah");
        return Response.ok(bookings).build();
    }
}
