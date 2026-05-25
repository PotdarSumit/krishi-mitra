package com.krishi_mitra.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherResponse {
    private String city;
    private Double temperature;
    private Double humidity;
    private Double windSpeed;
    private String description;
}
