package br.wals.springmockmvc.controller.mock;

import br.wals.springmockmvc.dto.Soldado;

public class SoldadoResponse {

    public static Soldado create(){
        Soldado soldado = new Soldado();
        soldado.setNome("Pedro Lucas");
        soldado.setRaca("humano");
        soldado.setIdade(20);
        soldado.setArma("Espada");
        soldado.setStatus("vivo");
        return soldado;
    }

}