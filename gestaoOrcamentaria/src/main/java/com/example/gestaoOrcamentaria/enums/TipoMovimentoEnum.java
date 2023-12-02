package com.example.gestaoOrcamentaria.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.yaml.snakeyaml.util.EnumUtils;

public enum TipoMovimentoEnum {

    RECEITA("Receita"),
    DESPESA("Despesa");

    private String nome;

    private TipoMovimentoEnum(String nome) {
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
    public static TipoMovimentoEnum forValue(String name)
    {
        return EnumUtils.findEnumInsensitiveCase(TipoMovimentoEnum.class, name);
    }
}
