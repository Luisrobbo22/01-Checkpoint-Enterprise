package main.java.br.com.fiap.cp.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "LFL_TB_USUARIO_INFO")
@SequenceGenerator(name = "USER_INFO", sequenceName = "SQ_TB_INFORMACAO_USUARIO", allocationSize = 1)
public class InformacaoUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_USUARIO_INFO")
    @GeneratedValue(generator = "USER_INFO", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "NR_ATUALIZACAO", nullable = false)
    private Integer numeroAtualizacao;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private Usuario usuario;

    @CreationTimestamp
    @Column(name = "DT_ATUALIZACAO")
    private Calendar dataAtualizacao;

    @Column(name = "NR_ALTURA")
    private double altura;

    @Column(name = "NR_PESO")
    private double peso;

    @Column(name = "NR_IMC")
    private double imc;

    public InformacaoUsuario(Integer numeroAtualizacao, Calendar dataAtualizacao, double altura, double peso, Usuario usuario) {
        this.id = id;
        this.numeroAtualizacao = numeroAtualizacao;
        this.dataAtualizacao = dataAtualizacao;
        this.altura = altura;
        this.peso = peso;
        this.usuario = usuario;
        getImc();
    }

    public InformacaoUsuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumeroAtualizacao() {
        return numeroAtualizacao;
    }

    public void setNumeroAtualizacao(Integer numeroAtualizacao) {
        this.numeroAtualizacao = numeroAtualizacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        this.imc = this.peso / (this.altura * this.altura);

        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }
}
