package org.example.price;

public class PriceWatcher {

    private final PriceService priceService;
    private final NotificationService notificationService;

    public PriceWatcher(PriceService priceService, NotificationService notificationService){
        this.priceService = priceService;
        this.notificationService = notificationService;
    }

    public void checkPrices() {
        try {
            var price = priceService.getPrice("T-shirt");
            if(price < 100)
                notificationService.notify("T-shirt", price);
        } catch (RuntimeException e) {
            throw new RuntimeException("Error sending message");
        }
    }
}
