package com.example.retobcp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tipo_cambio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "moneda_origen")
    private String monedaOrigen;

    @Column(name = "moneda_destino")
    private String monedaDestino;

    @Column(name = "ratio")
    private double ratio;

    @Column(name = "fecha")
    private LocalDate fecha;
}
