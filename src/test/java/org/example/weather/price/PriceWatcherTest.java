package org.example.weather.price;

import org.example.price.NotificationService;
import org.example.price.PriceService;
import org.example.price.PriceWatcher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PriceWatcherTest {

    @Mock
    PriceService priceService;

    @Mock
    NotificationService notificationService;

    @InjectMocks
    PriceWatcher priceWatcher;

    @Test
    void sendNotificationWhenPriceLowerThanThreshold(){
        Mockito.when(priceService.getPrice("T-shirt"))
                .thenReturn(95);

        priceWatcher.checkPrices();

        //verify ska bara användas där den bara behövs
        Mockito.verify(notificationService,
                        Mockito.times(1))
                .notify("T-shirt", 95);

    }
}
