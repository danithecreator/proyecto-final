package co.edu.uniquindio.proyecto.entidades;

import lombok.Builder;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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

    @Column(name = "comentario", length = 1000)
    @NotBlank
    private String comentario;

    @Positive
    @Column(name = "calificacion",nullable =false)
    @Positive
    @Max(5)
    @Min(1)
    private int calificacion;

    @Column(name = "respuesta", length = 1000)
    private String respuesta;

    @Temporal(TemporalType.DATE)
    @Column(name="fecha", nullable = false)
    private Date fecha;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuarioComentario;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Lugar lugarComentario;

    /**
     * constructor
     */
    public Comentario(){
        super();
    }

    /**
     *
     */
    public Comentario(String comentario, @Positive @Max(5) @Min(1) int calificacion, String respuesta, Date fecha, Usuario usuarioComentario, Lugar lugarComentario) {
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.respuesta = respuesta;
        this.fecha = fecha;
        this.usuarioComentario = usuarioComentario;
        this.lugarComentario = lugarComentario;
    }

    @Builder
    public Comentario( String comentario,  int calificacion,Lugar lugarComentario,  Usuario usuarioComentario) {
        this.comentario = comentario;
        this.calificacion = calificacion;
        this.usuarioComentario = usuarioComentario;
        this.lugarComentario = lugarComentario;
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
