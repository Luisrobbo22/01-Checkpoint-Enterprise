package main.java.br.com.fiap.cp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    @Column(name = "DS_SENHA", nullable = false)
    private String senha;

    @Temporal(TemporalType.DATE)
    @Column(name = "DT_NASCIMENTO")
    private Calendar dataNascimento;

    @Column(name = "NR_RG")
    private String rg;

    @Column(name = "NR_CPF")
    private String cpf;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_GENERO", referencedColumnName = "ID_GENERO")
    private Genero genero;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Estado> estados;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<InformacaoUsuario> infoUsers;

    public void addEstados(Estado estado) {
        if (estados == null)
            estados = new ArrayList<>();

        estados.add(estado);

        estado.setUsuario(this);
    }

    public void addInformacaoUsuario(InformacaoUsuario informacaoUsuario) {
        if (infoUsers == null)
            infoUsers = new ArrayList<>();

        infoUsers.add(informacaoUsuario);

        informacaoUsuario.setUsuario(this);
    }


    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, Calendar dataNascimento, String rg, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.rg = rg;
        this.cpf = cpf;
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

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Estado> getEstados() {
        return estados;
    }

    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }

    public List<InformacaoUsuario> getInfoUsers() {
        return infoUsers;
    }

    public void setInfoUsers(List<InformacaoUsuario> infoUsers) {
        this.infoUsers = infoUsers;
    }
}
