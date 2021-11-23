package com.example.Proyecto.controller;

import com.example.Proyecto.entity.Cuenta;
import com.example.Proyecto.repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CuentaController {

    @Autowired
    CuentaRepository cuentaRepository;

    @PostMapping("/agregarCuenta")
    public ResponseEntity<Cuenta> addCuenta(@RequestBody Cuenta cuenta) {
       // Cliente clienteEncontrado=restTemplate.getForObject("http://localhost:8080/BuscarCliente/" + id, Cliente.class);
        System.out.println("Se hizo la solicitud");
        cuentaRepository.creacionCuenta(cuenta);
        return ResponseEntity.ok(cuenta);
    }

    @GetMapping("/porCbu/{cbu}")
    public ResponseEntity<Cuenta> getCuentaPorCbu(@PathVariable("cbu") String cbu) {
        Optional<Cuenta>cuenta=cuentaRepository.getbyCbu(cbu);
        if (cuenta.isEmpty()) {
            return ResponseEntity.notFound().build();

        } else
        {
            return ResponseEntity.ok(cuenta.get());
        }
    }
}
