package com.example.gestaoOrcamentaria.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.yaml.snakeyaml.util.EnumUtils;

public enum ReferenciaEnum {

    JANEIRO("Janeiro"),
    FEVEREIRO("Fevereiro"),
    MARCO("Marco"),
    ABRIL("Abril"),
    MAIO("Maio"),
    JUNHO("Junho"),
    JULHO("Julho"),
    AGOSTO("Agosto"),
    SETEMBRO("Setembro"),
    OUTUBRO("Outubro"),
    NOVEMBRO("Novembro"),
    DEZEMBRO("Dezembro"),
    ;

    private String nome;

    private ReferenciaEnum(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonCreator
    public static ReferenciaEnum forValue(String name)
    {
        return EnumUtils.findEnumInsensitiveCase(ReferenciaEnum.class, name);
    }

}
