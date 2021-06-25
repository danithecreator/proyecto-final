package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Esta clase define la entidad evento de la base de datos
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
public class Evento implements Serializable {
    //Campos o atributos de la clase
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
    @Temporal(TemporalType.TIME)
    @Column(name="hora",nullable = false)
    private Date hora;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Lugar eventoLugar;

    /**
     * constructor
     */
    public Evento(){
        super();
    }

    public Evento(String nombre, String descripcion, Date fecha,Lugar eventoLugar,Date hora) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.eventoLugar = eventoLugar;
    }

    /**
     * getters y setters
     */
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

    /**
     * Hascode and equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Evento evento = (Evento) o;

        return codigo == evento.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Evento{" + "codigo=" + codigo + ", nombre='" + nombre + '\'' + ", descripcion='" + descripcion + '\'' + ", fecha=" + fecha + ", hora=" + hora + ", eventoLugar=" + eventoLugar + '}';
    }
}
