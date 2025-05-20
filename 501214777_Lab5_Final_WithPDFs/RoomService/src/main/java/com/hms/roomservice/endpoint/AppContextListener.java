package com.hms.roomservice.endpoint;

import com.hms.roomservice.business.RoomUpdateListener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        RoomUpdateListener.startListening();
        System.out.println("RoomUpdateListener started.");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Optional: cleanup
    }
}
