package org.example.weather;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThat;

//Går att göra egna Extensions klasser
@ExtendWith(MockitoExtension.class)
public class OutfitAdvisorTest {

    //Skapa mockito.mock i varje test
    //Göra den i de tester som behöver
    //Använda @Mock

    //TestDouble
    @Mock
    WeatherService weatherService;

    //Kan automatiskt injekta en WeatherService i konstruktorn
    //Återanvänder samma objekt
    @InjectMocks
    OutfitAdvisor advisor;


    @Test
    void freezingTemps () {
        Mockito.when(weatherService.getTemperature()).thenReturn((float) - 5.0f);
        String advice = advisor.getClothingAdvise();

        assertThat(advice).isEqualTo("Vinterjacka");

    }

    @Test
    void summerTemps() {
        Mockito.when(weatherService.getTemperature()).thenReturn((float) 16.0f);
        String advice = advisor.getClothingAdvise();
        assertThat(advice).isEqualTo("T-shirt");
    }
}
