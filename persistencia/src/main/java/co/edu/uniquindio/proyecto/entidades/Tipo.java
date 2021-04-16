package co.edu.uniquindio.proyecto.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Tipo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nombre",length = 200,nullable =false)
    private String nombre;

    @OneToMany(mappedBy = "tipo")
    private List<Lugar> lugares;

    public Tipo(){
        super();
    }

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
    //constructor getter y setter y hashcode y equals
}
