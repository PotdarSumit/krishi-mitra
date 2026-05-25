package com.krishi_mitra.serviceImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.krishi_mitra.dto.response.WeatherResponse;
import com.krishi_mitra.entity.WeatherData;
import com.krishi_mitra.repository.WeatherDataRepository;
import com.krishi_mitra.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl  implements WeatherService {
    private final RestTemplate restTemplate;
    private final WeatherDataRepository weatherDataRepository;

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;


    @Override
    public WeatherResponse getWeatherByCity(String city) {
        String url = apiUrl + "?q=" +city +"&appid=" + apiKey + "&units=metric";
        JsonNode reponse = restTemplate.getForObject(url, JsonNode.class);

        double temperature = reponse.get("main").get("temp").asDouble();
        double humitdity = reponse.get("main").get("humidity").asDouble();
        double windSpeed = reponse.get("wind").get("speed").asDouble();
        String description = reponse.get("weather").get(0).get("description").asText();

        WeatherData weatherData = WeatherData.builder()
                .city(city)
                .temperature(temperature)
                .humidity(humitdity)
                .windSpeed(windSpeed)
                .weatherDescription(description)
                .fetchedAt(LocalDateTime.now())
                .build();

        weatherDataRepository.save(weatherData);

        return WeatherResponse.builder()
                .city(city)
                .temperature(temperature)
                .humidity(humitdity)
                .windSpeed(windSpeed)
                .description(description)
                .build();
    }
}
