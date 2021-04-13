package main.java.br.com.fiap.cp.entity;

import main.java.br.com.fiap.cp.entity.pk.EstadoAndInfoUsuarioPk;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "LFL_TB_ESTADO")
@SequenceGenerator(name = "ESTADO", sequenceName = "SQ_TB_ESTADO", allocationSize = 1)
public class Estado implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EstadoAndInfoUsuarioPk estadoPk;

    @CreationTimestamp
    @Column(name = "DT_ATUALIZACAO", nullable = false)
    private Calendar dataAtualizacao;

    @Column(name = "MD_PRESSAO_ARTERIAL", length = 10)
    private String pressaoArterial;

    @Column(name = "MD_MONITORAMENTO_CARDIACO", length = 10)
    private String monitoramentoCardiaco;

    @Column(name = "MD_TEMPERATURA", length = 10)
    private String temperatura;

    private Usuario usuario;

    public Estado(EstadoAndInfoUsuarioPk estadoPk, Calendar dataAtualizacao, String pressaoArterial,
                  String monitoramentoCardiaco, String temperatura, Usuario usuario) {
        this.estadoPk = estadoPk;
        this.dataAtualizacao = dataAtualizacao;
        this.pressaoArterial = pressaoArterial;
        this.monitoramentoCardiaco = monitoramentoCardiaco;
        this.temperatura = temperatura;
        this.usuario = usuario;
    }

    public Estado() {
    }

    public EstadoAndInfoUsuarioPk getEstadoPk() {
        return estadoPk;
    }

    public void setEstadoPk(EstadoAndInfoUsuarioPk estadoPk) {
        this.estadoPk = estadoPk;
    }

    public Calendar getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Calendar dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public String getPressaoArterial() {
        return pressaoArterial;
    }

    public void setPressaoArterial(String pressaoArterial) {
        this.pressaoArterial = pressaoArterial;
    }

    public String getMonitoramentoCardiaco() {
        return monitoramentoCardiaco;
    }

    public void setMonitoramentoCardiaco(String monitoramentoCardiaco) {
        this.monitoramentoCardiaco = monitoramentoCardiaco;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}