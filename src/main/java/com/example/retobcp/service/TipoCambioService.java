package com.example.retobcp.service;

import com.example.retobcp.entity.TipoCambio;
import com.example.retobcp.request.TipoCambioInsertaRequest;
import com.example.retobcp.response.TipoCambioResponse;
import io.reactivex.Single;

import java.time.LocalDate;
import java.util.List;

public interface TipoCambioService {
    Single<List<TipoCambio>> getAllTipoCambio();
    Single<TipoCambioResponse> getTipoCambio(double monto, String monedaOrigen, String monedaDestino, LocalDate fecha);
    Single<TipoCambio> insertarTipoCambio(TipoCambioInsertaRequest tipoCambioInsertaRequest);
}
