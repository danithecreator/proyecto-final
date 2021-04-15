package co.edu.uniquindio.proyecto.Entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
public class Lugar implements Serializable {

    @Id
    private int codigo;
    private String descripcion;

    private String nombre;


    @OneToMany(mappedBy = "imagenLugar")
    private List<Imagen> imagenes;

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

    @ManyToOne
    private Moderador moderador;

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

    //Hashcode y equals
}
