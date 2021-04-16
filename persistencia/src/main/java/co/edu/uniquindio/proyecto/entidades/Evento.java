package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "nombre", length = 200, nullable =false)
    private String nombre;
    @Column(name = "descripcion", length = 1000, nullable =false)
    private String descripcion;
    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable = false)
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
