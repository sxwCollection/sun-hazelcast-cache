package suny.example.hazelcast.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import suny.example.hazelcast.config.CachingConfig;

@Service
public class WeatherService {

    @Cacheable(value = CachingConfig.CACHE_NAME)
    public String getWeather(String city) {
        return city + "  oh, really bad!";
    }
}
