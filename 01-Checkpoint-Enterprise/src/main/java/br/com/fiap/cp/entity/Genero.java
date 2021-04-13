package main.java.br.com.fiap.cp.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "LFL_TB_GENERO")
@SequenceGenerator(name = "GENERO", sequenceName = "SQ_TB_GENERO", allocationSize = 1)
public class Genero implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @Column(name = "ID_GENERO", nullable = false)
    @GeneratedValue(generator = "GENERO", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "DS_GENERO", nullable = false)
    private String descricao;

    public Genero(String descricao) {
        this.descricao = descricao;
    }

    public Genero(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Genero() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
