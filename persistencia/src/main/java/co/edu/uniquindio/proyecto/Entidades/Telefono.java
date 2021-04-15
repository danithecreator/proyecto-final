package co.edu.uniquindio.proyecto.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;

@Entity
public class Telefono implements Serializable {
    @Id
    private int id;
    private String numeroTelefono;
    //constructor getter y setter y hashcode y equals
    @ManyToOne
    private Lugar telefonoLugar;

    public Telefono(){
        super();
    }

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
}
