package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Telefono implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "numero_telefono", nullable =false)
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
