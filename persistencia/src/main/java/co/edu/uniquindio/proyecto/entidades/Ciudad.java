package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Esta clase define la entidad ciudad de la base de datos
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
public class Ciudad implements Serializable {

    //Campos o atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;
    @Column(name = "nombre", length = 200, nullable =false)
    private String nombre;

    @OneToMany(mappedBy = "ciudadUsuario")
    private List<Usuario> usuarios;

    @OneToMany(mappedBy = "ciudadLugar")
    private List<Lugar> lugares;

    /**
     * constructor
     */
    public Ciudad(){
        super();
    }

    public Ciudad(String nombre) {

        this.nombre = nombre;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    /**
     * Hascode and equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ciudad ciudad = (Ciudad) o;

        return codigo == ciudad.codigo;
    }

    @Override
    public int hashCode() {
        return codigo;
    }

    /**
     * metodo toString
     */
    @Override
    public String toString() {
        return "Ciudad{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
