package org.example.weather.price;

import org.example.price.NotificationService;

public class AsyncNotificationService implements NotificationService {

    private boolean isSent = false;
    @Override
    public void notify(String productName, int price) {
        isSent = true;
    }

    @Override
    public boolean isSent() {
        return isSent;
    }
}
