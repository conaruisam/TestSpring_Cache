package com.isam.cache.demo.service;

import com.isam.cache.demo.db.entities.ParametrosEntity;
import com.isam.cache.demo.db.repositories.ParametrosRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@AllArgsConstructor
public class ObtainParametersService {

    private final ParametrosRepository parametrosRepository;

    @Cacheable("obtainParameters")
    public List<ParametrosEntity> obtainParameters(){
        List<ParametrosEntity> all = parametrosRepository.findAll();
        all.sort(Comparator.comparing(ParametrosEntity::getClave));
        return all;
    }
}
