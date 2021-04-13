package main.java.br.com.fiap.cp.entity.pk;


import main.java.br.com.fiap.cp.entity.Usuario;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import java.io.Serializable;

@Embeddable
public class EstadoAndInfoUsuarioPk implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(name = "ID_USUARIO", nullable = false)
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    private Usuario usuario;


    @Column(name = "NR_ATUALIZACAO", nullable = false)
    private Integer numeroAtualizacao;

    public EstadoAndInfoUsuarioPk(Usuario usuario, Integer numeroAtualizacao) {
        this.usuario = usuario;
        this.numeroAtualizacao = numeroAtualizacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getNumeroAtualizacao() {
        return numeroAtualizacao;
    }

    public void setNumeroAtualizacao(Integer numeroAtualizacao) {
        this.numeroAtualizacao = numeroAtualizacao;
    }
}
