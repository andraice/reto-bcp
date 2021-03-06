package com.example.retobcp.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TipoCambioRequest {
    private double monto;
    private String monedaOrigen;
    private String monedaDestino;
    private LocalDate fecha;
}
