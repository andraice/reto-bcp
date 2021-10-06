package com.example.retobcp.repository;

import com.example.retobcp.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, String> {
    Optional<TipoCambio> findFirstByMonedaOrigenEqualsAndMonedaDestinoEquals(String monedaOrigen, String monedaDestino);
    Optional<TipoCambio> findFirstByMonedaOrigenEqualsAndMonedaDestinoEqualsAndFechaEquals(String monedaOrigen, String monedaDestino, LocalDate fecha);
}