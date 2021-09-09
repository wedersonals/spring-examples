package br.wals.example.restfull.enums;

import java.util.stream.Stream;

public enum Raca {
    HUMANO("Humano"),
    ELFO("Elfo"),
    ORC("Orc"),
    ANAO("Anão");

    private String value;

    Raca(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Raca of(String value) {
        Raca raca = Stream.of(Raca.values())
                .filter(it -> it.getValue().compareToIgnoreCase(value) == 0)
                .findFirst()
                .orElseThrow();
        return raca;
    }
}
