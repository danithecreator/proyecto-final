package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Comentario implements Serializable {
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

    public Comentario(){
        super();
    }

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
    //constructor getter y setter y hashcode y equals
}
