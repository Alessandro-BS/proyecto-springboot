package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movimiento;
import com.example.demo.model.TipoMovimiento;
import com.example.demo.service.MovimientoService;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {

    @Autowired
    private MovimientoService service;

    @PostMapping("/entrada")
    public Movimiento entrada(
            @RequestParam Long productoId,
            @RequestParam Integer cantidad) {
        return service.registrarMovimiento(
                productoId,
                TipoMovimiento.ENTRADA,
                cantidad);
    }

    @PostMapping("/salida")
    public Movimiento salida(
            @RequestParam Long productoId,
            @RequestParam Integer cantidad) {
        return service.registrarMovimiento(
                productoId,
                TipoMovimiento.SALIDA,
                cantidad);
    }
}
