package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Esta clase define la entidad Horario de la base de datos
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
public class Horario implements Serializable {
    //Campos o atributos de la clase
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

    /**
     * constructor
     */
    public Horario(){
        super();
    }

    /**
     *getters y setters
     */
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

    /**
     * Hascode and equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Horario horario = (Horario) o;

        return id == horario.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
