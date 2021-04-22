package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
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
    private String descripcion;
    @Column(name = "nombre", length = 200, nullable =false)
    private String nombre;
    @Column(name = "latitud",nullable =false)
    private float latitud;
    @Column(name = "longitud",nullable =false)
    private float longitud;
    @OneToMany(mappedBy = "imagenLugar")
    private List<Imagen> imagenes;

    @Column(name = "estado",nullable =false)
    private boolean estado;

    @ManyToOne
    private Ciudad ciudadLugar;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Tipo tipo;

    @OneToMany(mappedBy = "eventoLugar")
    private List<Evento> eventos;

    @OneToMany(mappedBy = "telefonoLugar")
    private  List<Telefono> telefonos;

    @ManyToMany(mappedBy = "horarioLugares")
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
