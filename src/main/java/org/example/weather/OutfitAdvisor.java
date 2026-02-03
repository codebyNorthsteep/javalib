package org.example.weather;

public class OutfitAdvisor {
    WeatherService weatherService;


    public OutfitAdvisor(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public String getClothingAdvise() {
        try {
            if (weatherService.getTemperature() < 0)
                return "Vinterjacka";

            if (weatherService.getTemperature() > 15)
                return "T-shirt";

            return null;
        } catch (IllegalStateException e) {
            return "Jeans & Jacket";
        }
    }
}
