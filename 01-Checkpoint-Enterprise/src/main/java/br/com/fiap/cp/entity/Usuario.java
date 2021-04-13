package main.java.br.com.fiap.cp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = "LFL_TB_USUARIO")
@SequenceGenerator(name = "USUARIO", sequenceName = "SQ_TB_USUARIO", allocationSize = 1)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_USUARIO", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO")
    private Integer id;


    @Column(name = "NM_USUARIO", nullable = false)
    private String nome;

    @Column(name = "DS_EMAIL", nullable = false)
    private String email;

    @JsonIgnore
    @Column(name = "DS_SENHA", nullable = false)
    private String senha;

    @Column(name = "DT_NASCIMENTO")
    private Calendar dataNascimento;

    @Column(name = "NR_RG")
    private String rg;

    @Column(name = "NR_CPF")
    private String cpf;

    private Estado estado;

    private InformacaoUsuario informacaoUsuario;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId("ID")
    @JoinColumn(name = "ID", referencedColumnName = "ID_GENERO")
    private Genero genero;

    public Usuario(String nome, String email, String senha, Calendar dataNascimento, String rg, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
    }

    public Usuario(Integer id, String nome, String email, String senha, Calendar dataNascimento, String rg, String cpf, Estado estado, InformacaoUsuario informacaoUsuario, Genero genero) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.setEstado(estado);
        this.setInformacaoUsuario(informacaoUsuario);
        this.setGenero(genero);
    }

    public Usuario() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario usuario = (Usuario) o;
        return getId().equals(usuario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public InformacaoUsuario getInformacaoUsuario() {
        return informacaoUsuario;
    }

    public void setInformacaoUsuario(InformacaoUsuario informacaoUsuario) {
        this.informacaoUsuario = informacaoUsuario;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
