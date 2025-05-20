package com.hms.roomservice.business;

import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import io.kubemq.sdk.subscribe.Subscribe;
import io.kubemq.sdk.subscribe.SubscribeType;
import io.kubemq.sdk.subscribe.Subscriber;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoomUpdateListener {

    public static void startListening() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            try {
                String kubeAddress = System.getenv("kubeMQAddress");
                Subscribe subscribe = new Subscribe();
                subscribe.setChannel("room_update_channel");
                subscribe.setClientID("room-subscriber");
                subscribe.setSubscribeType(SubscribeType.Events);
                subscribe.setUrl(kubeAddress);

                Subscriber sub = new Subscriber(subscribe, event -> {
                    String msg = new String(event.getBody());
                    System.out.println("Received update in RoomService: " + msg);
                    // TODO: update room availability in DB
                });
                sub.start();
            } catch (ServerAddressNotSuppliedException e) {
                e.printStackTrace();
            }
        });
    }
}
