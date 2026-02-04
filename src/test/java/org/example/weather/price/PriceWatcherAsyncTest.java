package org.example.weather.price;

import org.awaitility.Awaitility;
import org.example.price.NotificationService;
import org.example.price.PriceService;
import org.example.price.PriceWatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.TimeUnit;


@ExtendWith(MockitoExtension.class)
public class PriceWatcherAsyncTest {

    @Mock
    PriceService priceService;

    //Mockito gör en wrap om detta objektet och anropar
    @Spy
    NotificationService notificationService = new AsyncNotificationService();

    @InjectMocks
    PriceWatcher priceWatcher;

    @Test
    void sendNotificationWhenPriceLowerThanThreshold(){
        Mockito.when(priceService.getPrice("T-shirt"))
                .thenReturn(95);
        priceWatcher.checkPrices();

        //Async - tar ett tag innan man får ett svar tillbaka

        Awaitility.await().atMost(5, TimeUnit.SECONDS)
                .until(notificationService::isSent);
    }
}
