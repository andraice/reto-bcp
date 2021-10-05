package com.example.retobcp.repository;

import com.example.retobcp.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, String> {
    Optional<TipoCambio> findFirstByMonedaOrigenEqualsAndMonedaDestinoEquals(String monedaOrigen, String monedaDestino);
}