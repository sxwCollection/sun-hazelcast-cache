package suny.example.hazelcast.controller;

import com.hazelcast.core.HazelcastInstance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import suny.example.hazelcast.config.CachingConfig;

@RestController
@RequiredArgsConstructor
public class WeatherCache {

    private final HazelcastInstance hazelcastInstance;

    @GetMapping("cache/size")
    String getCacheSize() {
        return String.valueOf(hazelcastInstance.getMap(CachingConfig.CACHE_NAME).size());
    }
}
