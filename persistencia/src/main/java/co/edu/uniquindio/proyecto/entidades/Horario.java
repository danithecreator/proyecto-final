package co.edu.uniquindio.proyecto.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    private Date horaApertura;

    @Temporal(TemporalType.TIME)
    @Column(name="hora_cierre", nullable = false)
    @NotBlank
    private Date horaCierre;

    @Column(name="dia_semana", nullable = false)
    @NotBlank
    private String dia;

    @ManyToOne
    private Lugar horarioLugar;

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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
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

    @Override
    public String toString() {
        return "Horario{" + "horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + ", dia='" + dia + '\'' + '}';
    }
}
