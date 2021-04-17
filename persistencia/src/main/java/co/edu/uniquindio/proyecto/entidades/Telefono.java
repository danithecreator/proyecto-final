package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Esta clase define la entidad Telefono de la base de datos
 * @author: Daniel Ceballos, Angy Tabares
 */
@Entity
public class Telefono implements Serializable {
    //Campos o atributos de la clase
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "numero_telefono", nullable =false)
    private String numeroTelefono;

    @ManyToOne
    private Lugar telefonoLugar;

    /**
     * Constructor de la clase vacio
     */
    public Telefono(){
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    /**
     * Hashcode and equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Telefono telefono = (Telefono) o;

        return id == telefono.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
