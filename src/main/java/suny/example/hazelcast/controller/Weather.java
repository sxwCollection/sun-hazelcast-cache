package suny.example.hazelcast.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import suny.example.hazelcast.service.WeatherService;

@RestController
@RequiredArgsConstructor
public class Weather {

    private final WeatherService weatherService;

    @GetMapping("weather/{city}")
    ResponseEntity<String> getWeather(@PathVariable String city) {
        return ResponseEntity.ok(weatherService.getWeather(city));
    }
}
