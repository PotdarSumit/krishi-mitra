package com.krishi_mitra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "weather_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private Double temperature;
    private Double humidity;
    private String weatherDescription;
    private Double windSpeed;
    private LocalDateTime fetchedAt;

    @PrePersist
    public void prepersist(){
        fetchedAt = LocalDateTime.now();
    }
}
