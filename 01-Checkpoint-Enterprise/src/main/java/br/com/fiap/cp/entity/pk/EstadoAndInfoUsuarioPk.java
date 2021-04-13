package main.java.br.com.fiap.cp.entity.pk;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EstadoAndInfoUsuarioPk implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(name = "ID_USUARIO", nullable = false)
    private Integer idUsuario;


    @Column(name = "NR_ATUALIZACAO", nullable = false)
    private Integer numeroAtualizacao;


    public EstadoAndInfoUsuarioPk(Integer idUsuario, Integer numeroAtualizacao) {
        this.idUsuario = idUsuario;
        this.numeroAtualizacao = numeroAtualizacao;
    }

    public EstadoAndInfoUsuarioPk() {

    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getNumeroAtualizacao() {
        return numeroAtualizacao;
    }

    public void setNumeroAtualizacao(Integer numeroAtualizacao) {
        this.numeroAtualizacao = numeroAtualizacao;
    }
}
