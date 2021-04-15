package co.edu.uniquindio.proyecto.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Horario implements Serializable {
    @Id
    private int id;
    private LocalTime horaApertura;
    private LocalTime horaCierre;

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

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    public List<Lugar> getHorarioLugares() {
        return horarioLugares;
    }

    public void setHorarioLugares(List<Lugar> horarioLugares) {
        this.horarioLugares = horarioLugares;
    }
}
