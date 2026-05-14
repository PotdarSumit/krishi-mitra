package com.krishi_mitra.repository;

import com.krishi_mitra.entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    Optional<WeatherData> findTopByCityOrderByFetchedAtDesc(String city);
    List<WeatherData> findByCityOrderByFetchedAtDesc(String city);
}
