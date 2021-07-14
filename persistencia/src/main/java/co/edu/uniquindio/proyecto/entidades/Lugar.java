package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Esta clase define la entidad lugar de la base de datos
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
public class Lugar implements Serializable {
    //Campos o atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "descripcion", length = 1000, nullable =false)
    @NotBlank
    @Size(max=1000)
    private String descripcion;

    @Column(name = "nombre", length = 200, nullable =false)
    @NotBlank
    @Size(max=200)
    private String nombre;

    @Column(name = "latitud",nullable =false)
    @NotNull(message = "La latitud es obligatoria")
    private float latitud;

    @Column(name = "longitud",nullable =false)
    @NotNull(message = "La longitud es obligatoria")
    private float longitud;

    @Column(name = "fecha_creacion",nullable =false)
    private Date fecha_creacion;

    @Column(name = "fecha_aprobacion")
    private Date fecha_aprobacion;

    @OneToMany(mappedBy = "imagenLugar")
    private List<Imagen> imagenes;

    @Column(name = "estado",nullable =false)
    private boolean estado;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotBlank
    private Ciudad ciudadLugar;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotBlank
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(nullable = false)
    @NotBlank
    private Tipo tipo;

    @OneToMany(mappedBy = "eventoLugar")
    private List<Evento> eventos;

    @OneToMany(mappedBy = "telefonoLugar")
    private  List<Telefono> telefonos;

    @OneToMany(mappedBy = "horarioLugar")
    private  List<Horario> horarios;

    @ManyToMany(mappedBy = "lugaresFavoritos")
    private  List<Usuario> usuariosFavoritos;

    @ManyToOne
    private Moderador moderador;

    @OneToMany(mappedBy = "lugarComentario")
    private List<Comentario> comentarios;

    /**
            * Constructor de la clase
     */
    public Lugar(){
        super();
    }

    public Lugar(String descripcion, String nombre, Ciudad ciudadLugar, Usuario usuario, Tipo tipo, Moderador moderador) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.ciudadLugar = ciudadLugar;
        this.usuario = usuario;
        this.tipo = tipo;
        this.moderador = moderador;
    }

    //getter del codigo
    public int getCodigo() {
        return codigo;
    }
    //setter del codigo
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    //getter de la descripcion
    public String getDescripcion() {
        return descripcion;
    }
    //setter de la descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //getter del nombre
    public String getNombre() {
        return nombre;
    }
    //setter del nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //getter de la lista de imagenes
    public List<Imagen> getImagenes() {
        return imagenes;
    }
    //setter de la lista de imagenes
    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_aprobacion() {
        return fecha_aprobacion;
    }

    public void setFecha_aprobacion(Date fecha_aprobacion) {
        this.fecha_aprobacion = fecha_aprobacion;
    }

    public Ciudad getCiudadLugar() {
        return ciudadLugar;
    }

    public void setCiudadLugar(Ciudad ciudadLugar) {
        this.ciudadLugar = ciudadLugar;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * Hascode and equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lugar lugar = (Lugar) o;

        return codigo == lugar.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Lugar{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", ciudadLugar=" + ciudadLugar +
                ", usuario=" + usuario +
                ", tipo=" + tipo +
                ", moderador=" + moderador +
                ", estado=" + estado +
                '}';
    }
}
