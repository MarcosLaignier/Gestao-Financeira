package com.example.gestaoOrcamentaria.model;

import com.example.gestaoOrcamentaria.enums.ReferenciaEnum;
import com.example.gestaoOrcamentaria.enums.TipoMovimentoEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "movfinanceiro")
public class MovimentoFinanceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date dataMovimento;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimento")
    private TipoMovimentoEnum tipoMovimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "referencia")
    private ReferenciaEnum referencia;

    @ManyToOne
    private TipoDespesa tipoDespesa;

    @ManyToOne
    private TipoReceita tipoReceita;

    private BigDecimal valorDigitado;
    private BigDecimal valorTotal;

    @Version
    private Integer versao = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }

    public void setDataMovimento(Date dataMovimento) {
        this.dataMovimento = dataMovimento;
    }

    public TipoMovimentoEnum getTipoMovimento() {
        return tipoMovimento;
    }

    public void setTipoMovimento(TipoMovimentoEnum tipoMovimento) {
        this.tipoMovimento = tipoMovimento;
    }

    public ReferenciaEnum getReferencia() {
        return referencia;
    }

    public void setReferencia(ReferenciaEnum referencia) {
        this.referencia = referencia;
    }

    public TipoDespesa getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(TipoDespesa tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public TipoReceita getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(TipoReceita tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public BigDecimal getValorDigitado() {
        return valorDigitado;
    }

    public void setValorDigitado(BigDecimal valorDigitado) {
        this.valorDigitado = valorDigitado;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovimentoFinanceiro that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDataMovimento(), that.getDataMovimento()) && getTipoMovimento() == that.getTipoMovimento() && Objects.equals(getTipoDespesa(), that.getTipoDespesa()) && Objects.equals(getTipoReceita(), that.getTipoReceita()) && Objects.equals(getValorDigitado(), that.getValorDigitado()) && Objects.equals(getValorTotal(), that.getValorTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDataMovimento(), getTipoMovimento(), getTipoDespesa(), getTipoReceita(), getValorDigitado(), getValorTotal());
    }
}
