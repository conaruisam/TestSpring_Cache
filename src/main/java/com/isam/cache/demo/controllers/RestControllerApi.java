package com.isam.cache.demo.controllers;

import com.isam.cache.demo.db.entities.ParametrosEntity;
import com.isam.cache.demo.service.ObtainParametersService;
import com.isam.cache.demo.service.TestCacheService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@AllArgsConstructor
public class RestControllerApi {

    private final ObtainParametersService obtainParametersService;
    private final TestCacheService testCacheService;

    @GetMapping("/hola")
    public List<ParametrosEntity> decirHola() {
        return obtainParametersService.obtainParameters();
    }

    @GetMapping("/test/cache")
    public TestCacheService.Response probarCache() {
        TestCacheService.Response response = testCacheService.testCache();
        return response;
    }
}
