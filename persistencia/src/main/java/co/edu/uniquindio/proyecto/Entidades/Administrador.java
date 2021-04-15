package co.edu.uniquindio.proyecto.Entidades;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
public class Administrador extends Persona implements Serializable {
    //constructor getter y setter y hashcode y equals

    @OneToMany(mappedBy ="administrador")
    private List<Moderador>moderadoresCreados;

    public Administrador(){
        super();
    }



}
