package com.example.retobcp.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TipoCambioInsertaRequest {
    private int id;
    private String monedaOrigen;
    private String monedaDestino;
    private LocalDate fecha;
    private double ratio;
}
