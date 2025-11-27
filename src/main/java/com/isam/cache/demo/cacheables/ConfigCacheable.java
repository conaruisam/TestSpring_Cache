package com.isam.cache.demo.cacheables;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigCacheable {
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("obtainParameters"); // "productos" es el nombre de la caché
    }
}
