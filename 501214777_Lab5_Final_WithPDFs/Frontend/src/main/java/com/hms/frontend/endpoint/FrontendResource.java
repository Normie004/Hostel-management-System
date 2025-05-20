package com.hms.frontend.endpoint;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/frontend")
public class FrontendResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String loginPage() {
        return "<html><body><h2>Welcome to Hostel System</h2><p>Use Postman or your frontend to interact.</p></body></html>";
    }
}
