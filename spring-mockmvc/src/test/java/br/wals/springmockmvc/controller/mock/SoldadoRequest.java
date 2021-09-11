package br.wals.springmockmvc.controller.mock;

import br.wals.springmockmvc.dto.Soldado;

public class SoldadoRequest {

    public static Soldado create(){
        Soldado soldado = new Soldado();
        soldado.setNome("Wederson");
        soldado.setRaca("humano");
        soldado.setIdade(42);
        soldado.setArma("Machado");
        soldado.setStatus("vivo");
        return soldado;
    }

}
