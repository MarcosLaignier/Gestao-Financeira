package com.example.gestaoOrcamentaria.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tipoDespesa")
public class TipoDespesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Boolean situacao;
    private Date dataCriacao;
    private Date dataInativacao;
    private Boolean pagFornecedor;
    private Boolean pagFuncionario;



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

    public Boolean getPagFornecedor() {
        return pagFornecedor;
    }

    public void setPagFornecedor(Boolean pagFornecedor) {
        this.pagFornecedor = pagFornecedor;
    }

    public Boolean getPagFuncionario() {
        return pagFuncionario;
    }

    public void setPagFuncionario(Boolean pagFuncionario) {
        this.pagFuncionario = pagFuncionario;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof TipoDespesa)) return false;
        if (!super.equals(object)) return false;
        TipoDespesa that = (TipoDespesa) object;
        return java.util.Objects.equals(getId(), that.getId()) && java.util.Objects.equals(getNome(), that.getNome()) && java.util.Objects.equals(getSituacao(), that.getSituacao()) && java.util.Objects.equals(getDataCriacao(), that.getDataCriacao()) && java.util.Objects.equals(getDataInativacao(), that.getDataInativacao()) && java.util.Objects.equals(getPagFornecedor(), that.getPagFornecedor()) && java.util.Objects.equals(getPagFuncionario(), that.getPagFuncionario());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getNome(), getSituacao(), getDataCriacao(), getDataInativacao(), getPagFornecedor(), getPagFuncionario());
    }
}
