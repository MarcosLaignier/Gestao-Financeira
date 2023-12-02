package com.example.gestaoOrcamentaria.enums;

public  enum SituacaoAtivoInativoEnum {

    ATIVO("Ativo"),
    INATIVO("Inativo");

    private String nome;

    private SituacaoAtivoInativoEnum(String nome) {
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
}
