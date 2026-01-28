package org.example.weather.price;

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

import static org.assertj.core.api.Assertions.assertThat;

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

        assertThat(notificationService.isSent()).isTrue();
        Mockito.verify(notificationService, Mockito.times(1))
                .notify(Mockito.any(), 95);
    }
}
