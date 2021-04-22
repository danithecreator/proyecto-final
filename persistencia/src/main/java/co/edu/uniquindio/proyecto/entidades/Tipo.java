package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Esta clase define la entidad Tipo de lugar de la base de datos
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
public class Tipo implements Serializable {
    //Campos o atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre",length = 200,nullable =false)
    private String nombre;

    @OneToMany(mappedBy = "tipo")
    private List<Lugar> lugares;

    /**
     * Constructor de la clase vacio
     */
    public Tipo(){
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    /**
     * Hashcode and equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tipo tipo = (Tipo) o;

        return id == tipo.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "Tipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
