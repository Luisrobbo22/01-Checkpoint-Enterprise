package main.java.br.com.fiap.cp.entity;

import main.java.br.com.fiap.cp.entity.pk.EstadoAndInfoUsuarioPk;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "LFL_TB_USUARIO_INFO")
public class InformacaoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EstadoAndInfoUsuarioPk inforUsuarioPK;

    @CreationTimestamp
    @Column(name = "DT_ATUALIZACAO")
    private Calendar dataAtualizacao;

    @Column(name = "NR_ALTURA")
    private double altura;

    @Column(name = "NR_PESO")
    private double peso;

    @Column(name = "NR_IMC")
    private double imc;

    public InformacaoUsuario() {
    }

    public InformacaoUsuario(EstadoAndInfoUsuarioPk inforUsuarioPK, Calendar dataAtualizacao, double altura, double peso, double imc) {
        this.inforUsuarioPK = inforUsuarioPK;
        this.dataAtualizacao = dataAtualizacao;
        this.altura = altura;
        this.peso = peso;
        this.imc = imc;
    }

    public EstadoAndInfoUsuarioPk getInforUsuarioPK() {
        return inforUsuarioPK;
    }

    public void setInforUsuarioPK(EstadoAndInfoUsuarioPk inforUsuarioPK) {
        this.inforUsuarioPK = inforUsuarioPK;
    }

    public Calendar getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Calendar dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
}