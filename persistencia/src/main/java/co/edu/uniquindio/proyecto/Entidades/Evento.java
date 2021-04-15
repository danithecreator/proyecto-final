package co.edu.uniquindio.proyecto.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Evento implements Serializable {
    @Id
    private int codigo;
    private String nombre;
    private String descripcion;
    private Date fecha;

    @ManyToOne
    private Lugar eventoLugar;

    public Evento(){
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Lugar getEventoLugar() {
        return eventoLugar;
    }

    public void setEventoLugar(Lugar eventoLugar) {
        this.eventoLugar = eventoLugar;
    }

    //constructor getter y setter y hashcode y equals
}
