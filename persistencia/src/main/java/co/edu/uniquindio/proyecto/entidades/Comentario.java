package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;

/**
 * Esta clase define la entidad comentario de la base de datos
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
public class Comentario implements Serializable {
    //Campos o atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "comentario", length = 1000, nullable =false)
    private String comentario;
    @Positive
    @Column(name = "calificacion",nullable =true)
    @Max(5)
    private int calificacion;
    @Column(name = "respuesta", length = 1000, nullable =true)
    private String respuesta;
    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable = false)
    private Date fecha;

    @ManyToOne
    private Usuario usuarioComentario;

    @ManyToOne
    private Lugar lugarComentario;

    /**
     * constructor
     */
    public Comentario(){
        super();
    }

    /**
     * getters y setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Usuario getUsuarioComentario() {
        return usuarioComentario;
    }

    public void setUsuarioComentario(Usuario usuarioComentario) {
        this.usuarioComentario = usuarioComentario;
    }

    public Lugar getLugarComentario() {
        return lugarComentario;
    }

    public void setLugarComentario(Lugar lugarComentario) {
        this.lugarComentario = lugarComentario;
    }

    /**
     * Hascode and equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comentario that = (Comentario) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", comentario='" + comentario + '\'' +
                ", calificacion=" + calificacion +
                ", respuesta='" + respuesta + '\'' +
                ", fecha=" + fecha +
                '}';
    }
}
