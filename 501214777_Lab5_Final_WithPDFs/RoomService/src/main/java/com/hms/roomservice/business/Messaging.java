package com.hms.roomservice.business;

import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import io.kubemq.sdk.queue.Queue;
import io.kubemq.sdk.queue.QueueMessage;
import io.kubemq.sdk.queue.QueueMessageResponse;

public class Messaging {

    public static void sendMessage(String channel, String message) {
        try {
            String kubeAddress = System.getenv("kubeMQAddress");
            Queue queue = new Queue(channel, "client-" + channel, kubeAddress);
            QueueMessage msg = new QueueMessage()
                    .setChannel(channel)
                    .setBody(message.getBytes())
                    .setMetadata("booking-update");

            QueueMessageResponse response = queue.sendQueueMessage(msg);
            if (!response.isSent()) {
                System.out.println("Failed to send message: " + response.getError());
            }
        } catch (ServerAddressNotSuppliedException e) {
            e.printStackTrace();
        }
    }
}
