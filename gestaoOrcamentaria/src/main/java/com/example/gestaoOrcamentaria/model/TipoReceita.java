package com.example.gestaoOrcamentaria.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tipoReceita")
public class TipoReceita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private Boolean situacao;

    private Date dataCriacao;

    private Date dataInativacao;

    private Boolean temTaxa;

    private Double percentualTaxa;

    @Version
    private Integer versao = 0;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(Boolean situacao) {
        this.situacao = situacao;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataInativacao() {
        return dataInativacao;
    }

    public void setDataInativacao(Date dataInativacao) {
        this.dataInativacao = dataInativacao;
    }

    public Boolean getTemTaxa() {
        return temTaxa;
    }

    public void setTemTaxa(Boolean temTaxa) {
        this.temTaxa = temTaxa;
    }

    public Double getPercentualTaxa() {
        return percentualTaxa;
    }

    public void setPercentualTaxa(Double percentualTaxa) {
        this.percentualTaxa = percentualTaxa;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }
}
