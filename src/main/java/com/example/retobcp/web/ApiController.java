package com.example.retobcp.web;


import com.example.retobcp.entity.TipoCambio;
import com.example.retobcp.request.TipoCambioRequest;
import com.example.retobcp.response.TipoCambioResponse;
import com.example.retobcp.service.TipoCambioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tipo-cambio")
public class ApiController {

    @RequestMapping("/health")
    public String health() {
        return "Up";
    }

    @Autowired
    private TipoCambioService tipoCambioService;

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<TipoCambioResponse>> postTipoCambio(@RequestBody TipoCambioRequest tipoCambioRequest) {
        System.out.println(tipoCambioRequest.getMonto());
        return tipoCambioService.getTipoCambio(tipoCambioRequest.getMonto(), tipoCambioRequest.getMonedaOrigen(), tipoCambioRequest.getMonedaDestino())
                .subscribeOn(Schedulers.io())
                .map(x -> ResponseEntity.ok(x));
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Single<ResponseEntity<List<TipoCambio>>> getAllTipoCambio() {
        return tipoCambioService.getAllTipoCambio()
                .subscribeOn(Schedulers.io())
                .map(x -> ResponseEntity.ok(x));
    }

}
