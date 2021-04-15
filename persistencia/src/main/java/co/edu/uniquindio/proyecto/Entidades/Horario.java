package co.edu.uniquindio.proyecto.Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
public class Horario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Temporal(TemporalType.TIME)
    @Column(name="hora_apertura", nullable = false)
    private Date horaApertura;
    @Temporal(TemporalType.TIME)
    @Column(name="hora_cierre", nullable = false)
    private Date horaCierre;

    @ManyToMany
    private List<Lugar> horarioLugares;

    public Horario(){
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public List<Lugar> getHorarioLugares() {
        return horarioLugares;
    }

    public void setHorarioLugares(List<Lugar> horarioLugares) {
        this.horarioLugares = horarioLugares;
    }
}
