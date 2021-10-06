package com.example.retobcp.service;

import com.example.retobcp.entity.TipoCambio;
import com.example.retobcp.repository.TipoCambioRepository;
import com.example.retobcp.request.TipoCambioInsertaRequest;
import com.example.retobcp.response.TipoCambioResponse;
import io.reactivex.Observable;
import io.reactivex.Single;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TipoCambioServiceImpl implements TipoCambioService {

    @Autowired
    private TipoCambioRepository tipoCambioRepository;

    @Override
    public Single<List<TipoCambio>> getAllTipoCambio() {
        return Single.create(singleSubscriber -> {
            singleSubscriber.onSuccess(tipoCambioRepository.findAll());
        });
    }

    @Override
    public Single<TipoCambioResponse> getTipoCambio(double montoOrigen, String monedaOrigen, String monedaDestino, LocalDate fecha) {

        return Single.create(singleSubscriber -> {
            Optional<TipoCambio> tipoCambio = tipoCambioRepository.findFirstByMonedaOrigenEqualsAndMonedaDestinoEqualsAndFechaEquals(monedaOrigen, monedaDestino, fecha);
            if (!tipoCambio.isPresent()) {
                singleSubscriber.onError(new EntityNotFoundException());
            } else {
                TipoCambioResponse tipoCambioResponse = this.calculaTipoCambioResponse(tipoCambio.get(), montoOrigen);
                singleSubscriber.onSuccess(tipoCambioResponse);
            }
        });
    }

    @Override
    public Single<TipoCambio> insertarTipoCambio(TipoCambioInsertaRequest tipoCambioInsertaRequest) {
        return Single.create(singleSubscriber -> {
            TipoCambio tipoCambio = new TipoCambio();
            //tipoCambio.setId(tipoCambioInsertaRequest.getId());
            tipoCambio.setMonedaOrigen(tipoCambioInsertaRequest.getMonedaOrigen());
            tipoCambio.setMonedaDestino(tipoCambioInsertaRequest.getMonedaDestino());
            tipoCambio.setRatio(tipoCambioInsertaRequest.getRatio());
            tipoCambio.setFecha(tipoCambioInsertaRequest.getFecha());

            tipoCambioRepository.save(tipoCambio);

            singleSubscriber.onSuccess(tipoCambio);
        });
    }

    private TipoCambioResponse calculaTipoCambioResponse(TipoCambio tipoCambio, double montoOrigen) {
        return TipoCambioResponse.builder()
                .tipoCambio(tipoCambio.getRatio())
                .monedaOrigen(tipoCambio.getMonedaOrigen())
                .monedaDestino(tipoCambio.getMonedaDestino())
                .montoOrigen(montoOrigen)
                .montoDestino(montoOrigen * tipoCambio.getRatio())
                .build();
    }
}
