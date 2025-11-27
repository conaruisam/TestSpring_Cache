package com.isam.cache.demo.db.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "parametros")
public class ParametrosEntity {
    @Id
    private String clave;
    private String valor;
    private String descripcion;
}
