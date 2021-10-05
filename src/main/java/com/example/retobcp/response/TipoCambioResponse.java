package com.example.retobcp.response;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
public class TipoCambioResponse {
    private double montoOrigen;
    private double montoDestino;
    private String monedaOrigen;
    private String monedaDestino;
    private double tipoCambio;
}