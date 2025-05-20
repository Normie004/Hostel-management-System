package com.hms.authservice.endpoint;

import com.hms.authservice.helper.JWTUtil;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

@Path("/auth")
public class AuthResource {

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        // TODO: Replace this with real DB check
        if ("admin".equals(username) && "password".equals(password)) {
            String token = JWTUtil.generateToken(username);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return Response.ok(response).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED)
                       .entity("{"error": "Invalid credentials"}")
                       .build();
    }
}
