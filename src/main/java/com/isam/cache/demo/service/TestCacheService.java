package com.isam.cache.demo.service;

import com.isam.cache.demo.db.entities.ParametrosEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TestCacheService {

    private final ObtainParametersService obtainParametersService;


    public Response testCache() {
        Instant start = Instant.now();
        List<ParametrosEntity> parametrosEntities = obtainParametersService.obtainParameters();
        Instant end = Instant.now();

        long tiempoMillis = Duration.between(start, end).toMillis();
        Response.addTiempo(tiempoMillis);

        Response response = new Response();
        response.setParametrosEntities(parametrosEntities);

        return response;
    }

    @Data
    public static class Response {
        private static ArrayList<Long> tiempos = new ArrayList<>();
        public static void addTiempo(long tiempo) {
            tiempos.add(tiempo);
        }
        public List<Long> getTiempos() {
            return tiempos;
        }

        private List<ParametrosEntity> parametrosEntities;
    }
}
