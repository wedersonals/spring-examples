package br.wals.springmockmvc.service;

import br.wals.springmockmvc.dto.Soldado;
import org.springframework.stereotype.Service;

@Service
public class SoldadoService {

    public Soldado getSoldado() {
        return new Soldado();
    }

    public void salvarSoldado(Soldado soldado) {

    }

    public void deletarSoldado(Long id) {

    }
}
