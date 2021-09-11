package br.wals.springmockmvc.controller;

import br.wals.springmockmvc.dto.Soldado;
import br.wals.springmockmvc.service.SoldadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/soldado")
public class SoldadoController {

    private ObjectMapper objectMapper;
    @Value("${meuValor}")
    private String meuValor;

    private SoldadoService soldadoService;

    public SoldadoController(ObjectMapper objectMapper, SoldadoService soldadoService) {
        this.objectMapper = objectMapper;
        this.soldadoService = soldadoService;
    }

    @PostMapping
    public ResponseEntity criarSoldado(@RequestBody Soldado soldado) {
        soldadoService.salvarSoldado(soldado);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity atualizarSoldado(@RequestBody Soldado soldado) {
        soldadoService.salvarSoldado(soldado);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Soldado> buscarSoldado(@PathVariable("id") Long id) {
        String testeProperties = meuValor;
        Soldado soldado = soldadoService.getSoldado();
        return ResponseEntity.ok(soldado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable("id") Long id) {
        soldadoService.deletarSoldado(id);
        return ResponseEntity.ok().build();
    }

}
